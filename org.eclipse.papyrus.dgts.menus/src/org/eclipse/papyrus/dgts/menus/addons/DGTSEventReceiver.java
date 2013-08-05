/*******************************************************************************
 * Copyright  2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Vincent Lartigaut (Atos) vincent.lartigaut@atos.net - Vincent Lartigaut - initial API and implementation
 ******************************************************************************/

package org.eclipse.papyrus.dgts.menus.addons;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.runtime.URIUtil;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MCommandsFactory;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuContribution;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.dgts.service.DgtsResourceLoader;
import org.eclipse.papyrus.dgts.service.ToolsProvider;

import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.Tool;

public class DGTSEventReceiver {

	protected static MMenu globalMenu = MMenuFactory.INSTANCE.createMenu();
	private MMenuContribution menuContribution;
	private ToolsProvider toolProvider;

	@Inject
	@Optional
	void handleConfLoaded(
			@EventTopic(DGTSEventTopics.CONF_LOADED) Resource resource,
			MApplication application) {
		createGlobalMenu(application);
		createDynamiqueMenu(resource, application);
		menuContribution.getChildren().add(globalMenu);

	}

	@Inject
	@Optional
	void handleConfChanged(
			@EventTopic(DGTSEventTopics.CONF_UNLOAD) Resource data) {

		globalMenu.getChildren().clear();
		menuContribution.getChildren().remove(globalMenu);

	}

	protected void createGlobalMenu(MApplication application) {
		globalMenu.getChildren().clear();
		globalMenu.setElementId("Global_Menu_ID");
		globalMenu.setLabel("Create Custom Child");
		globalMenu.setAccessibilityPhrase("Create Custom Child");
		for (MMenuContribution mc : application.getMenuContributions()) {
			if (DGTSEventTopics.MENU_CONTRIBUTION_ID.equals(mc.getElementId()))
				menuContribution = mc;
		}
		if (menuContribution == null)
			return;
		globalMenu.setContributorURI(menuContribution.getContributorURI());

	}

	protected void createDynamiqueMenu(Resource resource,
			MApplication application) {
		toolProvider = new ToolsProvider();
		DiagramGlobalToolDefinition globalToolDefinition = DgtsResourceLoader
				.getDiagramGlobalToolDefinitionFromResource(resource);
		List<Tool> listElementTool = toolProvider
				.getAllElement(globalToolDefinition);
		MCommand command = getCommand(application);
		generateAllItemMenu(listElementTool, command);
	}

	protected MCommand getCommand(MApplication application) {

		for (MCommand c : application.getCommands()) {
			if (DGTSEventTopics.COMMAND_ID.equals(c.getElementId()))
				return c;
		}

		return null;
	}

	protected void generateAllItemMenu(List<Tool> listElementTool,
			MCommand command) {

		for (Tool elementTool : listElementTool) {
			if (!elementTool.isIsEdge() && elementTool.isSetMenu()) {
				globalMenu.getChildren().addAll(
						createItemMenus(elementTool, command));
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
				itemMenuList.add(itemMenu);
			}
		}
		return itemMenuList;

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
		return elementTypeReturnList;
	}

}