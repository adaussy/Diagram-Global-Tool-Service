package org.eclipse.papyrus.dgts.popupbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.papyrus.dgts.service.DgtsResourceLoader;
import org.eclipse.papyrus.dgts.service.ToolDefinitionResourceProvider;
import org.eclipse.papyrus.dgts.service.ToolsProvider;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.Tool;

public class CustomModelingAssistantService {

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
		Resource resource = ToolDefinitionResourceProvider.getResource();
		DiagramGlobalToolDefinition globalDiagramConfiguration = DgtsResourceLoader.getDiagramGlobalToolDefinitionFromResource(resource);

		// recupere la liste des tools correspondant au diagrame
		DiagramDefinition diag = toolsProvider.getDiagram(diagramType, globalDiagramConfiguration);
		List<Tool> listOfTools = new ArrayList<Tool>();
		List<DrawerDefinition> listOfDrawers = new ArrayList<DrawerDefinition>();
		listOfDrawers = toolsProvider.getDrawers(diag);

		boolean drawerContainType = false;

		if (listOfDrawers != null) {

		    for (DrawerDefinition drawer : listOfDrawers) {
			// ADD "drawerflag" to add a drawerBar in the popup bar
			if (drawerContainType) {
			    types.add("drawerFlag");
			}
			drawerContainType = false;
			listOfTools = toolsProvider.getTools(drawer);
			for (Tool tool : listOfTools) {
			    if (tool.isSetPopup()) {
				if (!(tool.isIsEdge())) {
				    List<IElementType> possibleTypes = new ArrayList<IElementType>(1);

				    // //Methode utilisant les IelementTypes du
				    // tool
				    if (tool instanceof Tool) {
					possibleTypes = toolsProvider.getIElementTypesFromTool((Tool) tool);
				    }

				    if (possibleTypes != null) {
					for (IElementType type : possibleTypes) {
					    // check if its a visual type or not
					    // :

					    if (type != null && (!(type instanceof MetamodelType))) {
						// check if the type can be add
						// to
						// the
						// current
						// container :
						if (isValidType(type, editPart)) {

						    // dont add if already exist
						    // if
						    // (!(types.contains(type)))
						    // {
						    types.add(type);
						    drawerContainType = true;
						    // }
						}
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
			if (types.get(types.size() - 1).equals("drawerFlag")) {
			    types.remove(types.size() - 1);
			}
		    }
		    return types;

		}
	    }
	}
	return Collections.emptyList();

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
