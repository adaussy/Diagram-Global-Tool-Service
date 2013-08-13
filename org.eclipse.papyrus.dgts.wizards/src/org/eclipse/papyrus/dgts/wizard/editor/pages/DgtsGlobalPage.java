/*******************************************************************************
 * Copyright  2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 * Vincent Lartigaut (Atos) vincent.lartigaut@atos.net - Vincent Lartigaut - initial API and implementation
 * Guilhem Desq (Atos) guilhem.desq@atos.net -  Guilhem Desq - initial API and implementation
 ******************************************************************************/

package org.eclipse.papyrus.dgts.wizard.editor.pages;

import javax.annotation.PostConstruct;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.wizard.editor.AddDiagramWizard;
import org.eclipse.papyrus.dgts.wizard.editor.providers.DgtsDiagramDefinitionLabelProvider;
import org.eclipse.papyrus.dgts.wizard.editor.utility.MyObjectTransfer;
import org.eclipse.papyrus.dgts.wizard.editor.utility.SelectionHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;




/**
 * @author gdesq
 *         This is the main page of the dgts editor wizard.
 *         It contain :
 *         - the diagram selection box
 *         - the edit tool bloc
 *         - the tool selection bloc
 *         - the Ielement type selection bloc
 */
public class DgtsGlobalPage extends WizardPage {

	// Constants

	private static final int HEIGHT_DIAGRAM_SELECTION = 250;

	// Types for Transfer :
	private String DIAGRAM_TYPE = "DiagramType";


	// TODO change the way we get the resource
	protected static Resource myResource = null;


	public static Resource getResource() {
		return myResource;
	}



	protected ToolsProvider toolsProvider = new ToolsProvider();

	private Composite container;

	protected DiagramGlobalToolDefinition globalDiag;

	private ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	// Blocs
	ChooseIElementTypesBloc chooseIElementTypesBloc;

	MainTreeBloc mainTreeBloc;

	EditBloc editBloc;

	private Button addDiagramButton;

	private TableViewer diagramSelectionTableViewer;

	// current state of the wizard
	private static DiagramDefinition currentSelectedDiagram;




	public static DiagramDefinition getCurrentDiagram() {
		return currentSelectedDiagram;
	}

	protected void setCurrentDiagram(DiagramDefinition diag) {
		DgtsGlobalPage.currentSelectedDiagram = diag;
	}

	public DgtsGlobalPage() {

		super("Tools Configuration Helper");
		DgtsGlobalPage.myResource = SelectionHelper.getResourceFromSelection();
		setTitle("Tools Configuration Helper");

		setDescription("Tools Configuration Helper");
	}

	@PostConstruct
	@Override
	public void createControl(Composite parent) {

		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.makeColumnsEqualWidth = true;
		setControl(container);
		Group group = createGroup(container, "");

		createDiagramSelectionForm(group);
		editBloc = new EditBloc(group);

		globalDiag = toolsProvider.getDiagramGlobalToolDefinitionFromResource(myResource);
		diagramSelectionTableViewer.setInput(globalDiag);

		mainTreeBloc = new MainTreeBloc(container);
		editBloc.setMainTreeBloc(mainTreeBloc);
		mainTreeBloc.setEditBloc(editBloc);
		chooseIElementTypesBloc = new ChooseIElementTypesBloc(container);

		mainTreeBloc.disableToolBar();

		setPageComplete(true);

	}

	protected void createDiagramSelectionForm(Group mainGroup) {

		// Add Diagram
		addDiagramButton = new Button(mainGroup, SWT.PUSH);
		addDiagramButton.setText("Add Diagram");
		addDiagramButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}

			@Override
			public void mouseDown(MouseEvent e) {
			}

			@Override
			public void mouseUp(MouseEvent e) {

				// Create an AddDiagramWizard
				AddDiagramWizard newWizard = new AddDiagramWizard();
				WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), newWizard);
				if(dialog.open() == WizardDialog.OK) {


				}

				// Refresh
				diagramSelectionTableViewer.setInput(globalDiag);

			}

		});
		Group group = createGroup(mainGroup, "Select a diagram");

		group.setSize(-1, HEIGHT_DIAGRAM_SELECTION);
		GridData selectionData = new GridData(SWT.FILL, SWT.FILL, true, true);

		final Table diagramSelectionTable = new Table(group, SWT.NO_BACKGROUND | SWT.FULL_SELECTION);
		diagramSelectionTable.getHorizontalBar().setEnabled(false);
		diagramSelectionTable.setFont(group.getFont());
		diagramSelectionTable.setBackground(group.getBackground());
		diagramSelectionTable.setLayoutData(selectionData);
		diagramSelectionTable.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */

			public void widgetSelected(SelectionEvent e) {
				if(e.item.getData() instanceof DiagramDefinition) {
					DiagramDefinition diag = (DiagramDefinition)e.item.getData();
					setCurrentDiagram(diag);

					editBloc.setCurrentSelectedDrawer(null);
					editBloc.setCurrentSelectedTool(null);
					editBloc.refreshBloc();
					mainTreeBloc.setCurrentTarget(null);
					mainTreeBloc.refreshBloc(getCurrentDiagram());
					chooseIElementTypesBloc.RefreshBloc(getCurrentDiagram());

				}

			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// does nothing
			}
		});
		diagramSelectionTableViewer = new TableViewer(diagramSelectionTable);
		diagramSelectionTableViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		diagramSelectionTableViewer.setLabelProvider(new DgtsDiagramDefinitionLabelProvider());

		Transfer[] types = new Transfer[]{ new MyObjectTransfer(new String[]{ DIAGRAM_TYPE }) };
		addDragSupport(types, diagramSelectionTableViewer);
		addDropSupportForDiagram(types);

	}

	protected void addDropSupportForDiagram(Transfer[] types) {
		diagramSelectionTableViewer.addDropSupport(DND.DROP_MOVE, types, new ViewerDropAdapter(diagramSelectionTableViewer) {

			@Override
			public boolean performDrop(Object data) {
				if(data instanceof DiagramDefinition) {
					DiagramDefinition source = (DiagramDefinition)data;
					if(getCurrentTarget() instanceof DiagramDefinition) {
						DiagramDefinition target = (DiagramDefinition)getCurrentTarget();
						// Move the diagram :
						int targetPosition = globalDiag.getDiagramDefinitionRef().indexOf(target);
						globalDiag.getDiagramDefinitionRef().move(targetPosition, source);
						diagramSelectionTableViewer.setInput(globalDiag);
					}
				}

				return false;
			}

			@Override
			public boolean validateDrop(Object target, int operation, TransferData transferType) {
				if(operation == DND.DROP_MOVE) {
					if(target instanceof DiagramDefinition) {

						return true;

					}
				}
				return false;
			}
		});
	}

	public static Group createGroup(Composite parent, String name) {

		Group group = new Group(parent, SWT.NONE);
		group.setText(name);
		Color color = new Color(null, 255, 255, 255);
		group.setBackground(color);
		group.setBackground(color);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		group.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		group.setLayoutData(data);
		return group;
	}

	protected void addDragSupport(Transfer[] types, TableViewer tableViewer) {
		tableViewer.addDragSupport(DND.DROP_MOVE, types, new DragSourceAdapter() {

			@Override
			public void dragSetData(DragSourceEvent event) {
				// Get the selected items in the drag source
				DragSource ds = (DragSource)event.widget;
				Table table = (Table)ds.getControl();
				TableItem[] selection = table.getSelection();
				event.data = selection[0].getData();
			}
		});
	}

}
