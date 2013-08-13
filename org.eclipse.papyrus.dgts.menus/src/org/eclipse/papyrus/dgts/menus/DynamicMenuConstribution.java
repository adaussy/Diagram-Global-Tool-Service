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
package org.eclipse.papyrus.dgts.menus;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MCommandsFactory;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuContribution;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.dgts.menus.handlers.CreateElementHandler;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationOperation;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationService;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.Tool;


/** Class used to create dynamic menu in the model explorer
 * @author vlartiga
 *
 */
public class DynamicMenuConstribution {

	private MMenuContribution menuContribution;
	private ToolsProvider toolProvider = new ToolsProvider();
	private List<MMenuElement> items;
	private ISelection selection;
	private MPart part;
	private Object selectedElement;

	@AboutToShow
	public void aboutToShow(
			List<MMenuElement> items,
			MApplication application,
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) ISelection selection) {

		this.items = items;
		Diagram diagram = getActiveDiagram();

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();

		this.selection = selection;
		selectedElement = ((IStructuredSelection) selection).getFirstElement();
		DGTSModelConfigurationOperation operation = new DGTSModelConfigurationOperation(
				Collections.singleton(diagram));
		List<DrawerDefinition> ListDrawers = DGTSModelConfigurationService
				.getInstance().getModelConfiguration(operation);
		if (ListDrawers != null) {
			createDynamiqueMenu(ListDrawers, application);
		}

	}

	protected Diagram getActiveDiagram() {
		IEditorPart editorCurrent = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		PapyrusMultiDiagramEditor papyrusEditor = (PapyrusMultiDiagramEditor) editorCurrent;
		DiagramEditor activeEditor = (DiagramEditor) papyrusEditor
				.getActiveEditor();
		Diagram diagram = activeEditor.getDiagramEditPart().getDiagramView();
		return diagram;
	}

	protected void createDynamiqueMenu(List<DrawerDefinition> ListDrawers,
			MApplication application) {
		MCommand command = getCommand(application);
		if (ListDrawers.size() == 1) {
			List<Tool> listElementTool = toolProvider.getTools(ListDrawers);
			generateAllItemMenu(listElementTool, command, null);
		} else {
			for (DrawerDefinition drawerDefinition : ListDrawers) {
				MMenu menu = MMenuFactory.INSTANCE.createMenu();
				if (drawerDefinition.getIconReference() != null) {
					menu.setIconURI(drawerDefinition.getIconReference()
							.getIconPath());
				}

				menu.setLabel(drawerDefinition.getName());
				generateAllItemMenu(drawerDefinition.getToolRef(), command,
						menu);
			}
		}

	}

	protected MCommand getCommand(MApplication application) {

		for (MCommand c : application.getCommands()) {
			if (DGTSEventTopics.COMMAND_ID.equals(c.getElementId()))
				return c;
		}

		return null;
	}

	protected void generateAllItemMenu(List<Tool> listElementTool,
			MCommand command, MMenu menu) {

		for (Tool elementTool : listElementTool) {
			if (!elementTool.isIsEdge() && elementTool.isSetMenu()) {
				if (menu == null) {
					items.addAll(createItemMenus(elementTool, command));
				} else {
					menu.getChildren().addAll(
							createItemMenus(elementTool, command));
				}

			}

		}
		if (menu != null) {
			if (!menu.getChildren().isEmpty()) {
				items.add(menu);
			}
		}

	}

	protected List<MHandledMenuItem> createItemMenus(Tool elementTool,
			MCommand command) {
		List<MHandledMenuItem> itemMenuList = new ArrayList<MHandledMenuItem>();
		List<IElementType> elementTypes = selectElementType(elementTool);
		for (IElementType element : elementTypes) {
			MHandledMenuItem itemMenu = createItemMenu(command, element,
					elementTool);
			if (itemMenu != null) {
				if (canExecute(itemMenu, element)) {
					if (!containItemMenu(itemMenu)) {
						itemMenuList.add(itemMenu);
					}
				}

			}
		}
		return itemMenuList;

	}

	public boolean canExecute(MHandledMenuItem itemMenu, IElementType element) {

		if (selectedElement instanceof ModelElementItem) {
			CreateElementHandler cmd = new CreateElementHandler();
			if (cmd.canExecute(element)) {
				return true;
			}
		}
		return false;
	}

	public boolean containItemMenu(MHandledMenuItem itemMenu) {
		for (MMenuElement menu : items) {
			if (menu.getLabel().equals(itemMenu.getLabel())) {
				return true;
			}
		}
		return false;

	}

	protected MHandledMenuItem createItemMenu(MCommand command,
			IElementType element, Tool elementTool) {

		MHandledMenuItem menuItem = MMenuFactory.INSTANCE
				.createHandledMenuItem();
		String label;
		if (elementTool.getElementTypes().size() == 1) {
			label = elementTool.getName();
		} else {
			label = DGTSEventTopics.getNameFromIElementDisplayName(element
					.getDisplayName());
		}
		menuItem.setLabel("Create a new " + label);
		menuItem.setElementId(element.getId());
		menuItem.setCommand(command);
		menuItem.getParameters().add(createMParameter(element));
		menuItem.setVisible(true);
		if (elementTool.getIconReference() != null) {
			ImageDescriptor img = ImageDescriptor.createFromFile(null,
					elementTool.getIconReference().getIconPath());
			URL url = null;
			try {
				url = new File(elementTool.getIconReference().getIconPath())
						.toURI().toURL();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (url != null) {
				menuItem.setIconURI(url.toString());
			}

		} else if (element.getIconURL() != null) {
			menuItem.setIconURI(element.getIconURL().toString());

		}
		return menuItem;

	}

	private ComposedAdapterFactory composedAdapterfactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	protected MParameter createMParameter(IElementType element) {

		MParameter param = MCommandsFactory.INSTANCE.createParameter();
		param.setElementId(DGTSEventTopics.COMMAND_PARAMETER_ID);
		param.setName(DGTSEventTopics.COMMAND_PARAMETER_ID);
		param.setValue(element.getId());
		return param;

	}

	protected List<IElementType> selectElementType(Tool elementTool) {
		List<IElementType> elementTypeReturnList = new ArrayList<IElementType>();
		List<IElementType> elementTypeList = toolProvider
				.getIElementTypesFromTool(elementTool);
		for (IElementType element : elementTypeList) {

			if (element instanceof IHintedType) {
				IHintedType el = (IHintedType) element;
				if (el.getSemanticHint().equals(element.getDisplayName())) {
					elementTypeReturnList.add(element);
				}
			}

		}
		// PlatformUI.getWorkbench().
		return elementTypeReturnList;

	}

}
