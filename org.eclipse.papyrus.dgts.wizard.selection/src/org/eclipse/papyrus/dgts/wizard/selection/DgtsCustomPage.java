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
package org.eclipse.papyrus.dgts.wizard.selection;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

/**
 * Page present in the DGTS Selection wizard which allow the user to select a custom DGTS model configuration
 * 
 * @author vlartiga
 * 
 */
public class DgtsCustomPage extends WizardPage {

	private Composite container;

	private TableViewer toolSelectionTableViewer;

	private Table selectionTable;

	private Combo combo;

	protected List<String> listPath = new ArrayList<String>();

	private DiagramEditPart editPart;

	private IStructuredSelection currentSelection = null;

	private Button deletModelConfiguration;

	protected DgtsCustomPage(DiagramEditPart editPart) {

		super("Select DGTS Model Configuration");

		setTitle("Select DGTS Model Configuration");

		setDescription("Select DGTS Model Configuration");
		this.editPart = editPart;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		setControl(container);

		GridLayout gridLayout1 = new GridLayout(2, false);
		Composite addanddeleteComposite = new Composite(container, SWT.NONE);
		addanddeleteComposite.setLayout(gridLayout1);
		createLoadModelButton(addanddeleteComposite);
		createDeleteButton(addanddeleteComposite);


		GridLayout gridLayout2 = new GridLayout(2, false);
		Composite addpredefinedContainer = new Composite(container, SWT.NONE);
		addpredefinedContainer.setLayout(gridLayout2);

		combo = new Combo(addpredefinedContainer, Combo.LIMIT);
		combo.setText("select predefined model configuration");

		addPredefiniedModelConfigurationFromPreferences(combo);
		createAddPreferencesButton(addpredefinedContainer);
		createModelConfigurationList(container);
		setPageComplete(false);

	}

	protected void createModelConfigurationList(Composite container) {
		GridData selectionData = new GridData(SWT.FILL, SWT.FILL, true, true);
		selectionData.heightHint = 300;
		Group group = createGroup(container, "Model configuration list");
		selectionTable = new Table(group, SWT.NO_BACKGROUND);
		selectionTable.setFont(group.getFont());
		selectionTable.setBackground(group.getBackground());
		selectionTable.setLayoutData(selectionData);
		selectionTable.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				currentSelection = (StructuredSelection)toolSelectionTableViewer.getSelection();
				deletModelConfiguration.setEnabled(true);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		toolSelectionTableViewer = new TableViewer(selectionTable);
		initToolSelectionTableViewer(toolSelectionTableViewer);


	}

	protected void createLoadModelButton(Composite container) {
		Button loadPersonnalModelConfiguration = new Button(container, SWT.NONE);
		loadPersonnalModelConfiguration.setToolTipText("Add Dgts configuration from file");
		Image image = new Image(null, getClass().getResourceAsStream("icons/editconfiguration.png"));
		loadPersonnalModelConfiguration.setImage(image);
		loadPersonnalModelConfiguration.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.NULL);
				String path = dialog.open();
				if(path != null) {
					toolSelectionTableViewer.add(path);
					listPath.add(path);
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	protected void createAddPreferencesButton(Composite container) {
		Button addPredefined = new Button(container, SWT.NONE);
		addPredefined.setText("Add a registred Dgts configuration");
		addPredefined.addMouseListener(new MouseListener() {


			@Override
			public void mouseUp(MouseEvent e) {
				if(!"".equals(combo.getText()) && !listPath.contains(combo.getText())) {
					listPath.add(combo.getText());
					toolSelectionTableViewer.add(combo.getText());
				}



			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	protected void createDeleteButton(Composite container) {
		deletModelConfiguration = new Button(container, SWT.NONE);
		deletModelConfiguration.setEnabled(false);
		deletModelConfiguration.setToolTipText("Delete model Configuration");
		Image image = new Image(null, getClass().getResourceAsStream("icons/delete.png"));
		deletModelConfiguration.setImage(image);
		deletModelConfiguration.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				if(currentSelection != null) {
					listPath.remove(currentSelection.getFirstElement());
					toolSelectionTableViewer.remove(currentSelection.getFirstElement());
					deletModelConfiguration.setEnabled(false);
				}
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void initToolSelectionTableViewer(TableViewer toolSelectionTableViewer2) {
		for(EAnnotation annotation : this.editPart.getDiagramView().getEAnnotations()) {
			toolSelectionTableViewer.add(annotation.getSource());
			listPath.add(annotation.getSource());
		}

	}

	protected void addPredefiniedModelConfigurationFromPreferences(Combo combo) {
		IConfigurationElement[] conf = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.papyrus.dgts.preferences.DGTSPreferences");
		String resource = null;
		String ID = null;
		for(IConfigurationElement c : conf) {
			resource = c.getAttribute("resource");
			ID = c.getAttribute("ID");
			if(resource != null && ID != null) {
				Bundle bundle = Platform.getBundle(c.getContributor().getName());
				URL url = bundle.getEntry(resource);
				File file = null;
				try {
					file = new File(FileLocator.resolve(url).toURI());
				} catch (URISyntaxException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				combo.add(file.getAbsolutePath());

			}
		}

	}

	private static Group createGroup(Composite parent, String name) {

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


	public List<String> getAllModelConfigurationPath() {
		return listPath;

	}

}
