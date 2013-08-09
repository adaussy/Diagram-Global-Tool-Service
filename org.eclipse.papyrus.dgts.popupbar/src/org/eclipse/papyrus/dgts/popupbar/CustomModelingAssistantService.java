/*******************************************************************************
 * Copyright  2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Guilhem Desq (Atos) guilhem.desq@atos.net -  Guilhem Desq - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.dgts.popupbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.PopupBarTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationOperation;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationService;
import org.eclipse.swt.graphics.Image;

import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.Tool;

public class CustomModelingAssistantService {

    public class PopupBarType {
	private IElementType type;
	private String iconPath = null;
	private boolean isDrawerBar = false;

	public IElementType getType() {
	    return type;
	}

	public String getIconReference() {
	    return iconPath;
	}

	public boolean isDrawerBar() {
	    return isDrawerBar;
	}

	PopupBarType(boolean isDrawerBar) {
	    type = null;
	    iconPath = null;
	    isDrawerBar = true;
	}

	PopupBarType(IElementType theType, String theIconPath) {
	    type = theType;
	    iconPath = theIconPath;
	    isDrawerBar = false;

	}

    }

    private final static CustomModelingAssistantService service = new CustomModelingAssistantService();

    public static CustomModelingAssistantService getInstance() {
	return service;
    }

    public List<?> getTypesForPopupBar(IAdaptable host) {
	IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);

	if (editPart != null) {
	    if (editPart.getRoot().getChildren().get(0) instanceof DiagramEditPart) {
		// type du diagrame courant
		DiagramEditPart diagramPart = (DiagramEditPart) editPart.getRoot().getChildren().get(0);
		String diagramType = diagramPart.getDiagramView().getType();

		// declaration
		List<Object> types = new ArrayList<>(1);
		ToolsProvider toolsProvider = new ToolsProvider();
		
		// recupere le container
		// View containerview = editPart.getNotationView();

		// recupere le globalDiagramConfiguration actif
		DGTSModelConfigurationOperation operation = new DGTSModelConfigurationOperation(Collections.singleton((View)diagramPart.getModel()));
		List<DrawerDefinition> listOfDrawers = DGTSModelConfigurationService.getInstance().getModelConfiguration(operation);
		// recupere la liste des tools correspondant au diagrame
		List<Tool> listOfTools = new ArrayList<Tool>();
		boolean drawerContainType = false;

		if (listOfDrawers != null) {

		    for (DrawerDefinition drawer : listOfDrawers) {
			// ADD "drawerflag" to add a drawerBar in the popup bar
			if (drawerContainType) {
			    PopupBarDescriptor drawerBar = new PopupBarDescriptor(true, null, null, null, null);
			    types.add(drawerBar);
			}
			drawerContainType = false;
			listOfTools = toolsProvider.getTools(drawer);

			for (Tool tool : listOfTools) {
			    if (tool.isSetPopup()) {
				if (!(tool.isIsEdge())) {
				    List<IElementType> possibleTypes = new ArrayList<IElementType>(1);

				    if (tool instanceof Tool) {
					possibleTypes = toolsProvider.getIElementTypesFromTool((Tool) tool);
				    }

				    if (possibleTypes != null) {
					for (IElementType type : possibleTypes) {

					    // check if the type can be
					    // added
					    // to
					    // the
					    // current
					    // container :
					    if (isValidType(type, editPart)) {

						// dont add if already exist
						// if
						// (!(types.contains(type)))
						// {

						PopupBarDescriptor popupBarDesc = createPopupBarDescriptor(type, editPart, tool);

						types.add(popupBarDesc);
						drawerContainType = true;
						// }
					    }
					}

				    }

				}
			    }
			}

		    }

		    // If the last drawer has no types, we need to remove the
		    // last
		    // drawerbar
		    if (!types.isEmpty()) {
			if (((PopupBarDescriptor) types.get(types.size() - 1)).isDrawerBar()) {
			    types.remove(types.size() - 1);
			}
		    }
		    return types;

		}
	    }
	}
	return Collections.emptyList();

    }

    private PopupBarDescriptor createPopupBarDescriptor(IElementType type, IGraphicalEditPart host, Tool tool) {
	String iconPath = null;
	Image img = null;
	String theInputStr = DiagramUIMessages.PopupBar_AddNew;
	String tip = NLS.bind(theInputStr, type.getDisplayName());

	if (tool.getIconReference() != null) {
	    iconPath = tool.getIconReference().getIconPath();
	    if (iconPath != null) {
		try {
		    img = new Image(null, iconPath);
		} catch (Exception e) {
		    img = null;
		}
	    }
	}
	if (img == null) {
	    img = IconService.getInstance().getIcon((IElementType) type);
	}

	return new PopupBarDescriptor(false, tip, img, type, new PopupBarTool(host, type));
    }

    private boolean isValidType(IElementType elementType, IGraphicalEditPart host) {

	boolean valid = false;

	CreateViewAndElementRequest request = new CreateViewAndElementRequest(elementType, null);
	Command cmd = host.getCommand(request);
	if (cmd != null && cmd.canExecute()) {
	    valid = true;
	}
	// If we are in a compartement, we test and his parent if this
	// compartement returned false :
	if (host instanceof CompartmentEditPart && valid == false) {
	    host = (IGraphicalEditPart) host.getParent();
	    cmd = host.getCommand(request);
	    if (cmd != null && cmd.canExecute()) {
		valid = true;
	    }

	}
	return valid;
    }
}
