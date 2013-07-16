package org.eclipse.papyrus.dgts.popupbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.DefaultNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.dgts.service.DgtsResourceLoader;
import org.eclipse.papyrus.dgts.service.ToolDefinitionResourceProvider;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.service.UMLTypesProvider;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import DiagramGlobalToolService.AbstractTool;
import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.ElementType;
import DiagramGlobalToolService.Tool;
import DiagramGlobalToolService.ToolMetaModel;

public class CustomModelingAssistantService {

    private final static CustomModelingAssistantService service = new CustomModelingAssistantService();

    public static CustomModelingAssistantService getInstance() {
	return service;
    }

    /*
    private static String getUMLID(String type) {
	StringBuilder builder = new StringBuilder("org.eclipse.papyrus.uml.diagram.clazz.");
	builder.append(type);
	return builder.toString();
    }
*/
    public List<?> getTypesForPopupBar(IAdaptable host) {
	IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);

	// IClientContext clientContext =
	// ClientContextManager.getInstance().getClientContext("org.eclipse.papyrus.uml.diagram.clazz.TypeContext");

	// type du diagrame courant
	DiagramEditPart diagramPart = (DiagramEditPart) editPart.getRoot().getChildren().get(0);
	String diagramType = diagramPart.getDiagramView().getType();

	// declaration
	List<IElementType> types = new ArrayList<IElementType>(1);
	ToolsProvider toolsProvider = new ToolsProvider();

	// recupere le container
	// View containerview = editPart.getNotationView();

	// recupere le globalDiagramConfiguration actif
	Resource resource = ToolDefinitionResourceProvider.getResource();
	DiagramGlobalToolDefinition globalDiagramConfiguration = DgtsResourceLoader.getDiagramGlobalToolDefinitionFromResource(resource);

	// recupere la liste des tools correspondant au diagrame
	DiagramDefinition diag = toolsProvider.getDiagram(diagramType, globalDiagramConfiguration);
	List<AbstractTool> listOfTools = new ArrayList<AbstractTool>();
	listOfTools = toolsProvider.getTools(diag);

	// traitement de chaque tool
	if (listOfTools != null) {
	    for (AbstractTool tool : listOfTools) {

		List<IElementType> possibleTypes = new ArrayList<IElementType>(1);

		// //Methode utilisant le metamodele du Tool
		if (tool instanceof ToolMetaModel) {
		    possibleTypes = getTypesFromToolMetaModel((ToolMetaModel) tool);

		}

		// //Methode utilisant les IelementTypes du tool (plus bas
		// niveau)
		if (tool instanceof Tool) {
		    possibleTypes = getTypesFromElementType((Tool) tool);
		}

		if (possibleTypes != null) {
		    for (IElementType type : possibleTypes) {
			// check if its a visual type or not :
			if (type != null && (!(type instanceof MetamodelType))) {
			    // check if the type can be add to the current
			    // container :
			    if (isValidateType(type, editPart)) {
				// dont add if already exist
				if (!(types.contains(type))) {
				    types.add(type);
				}
			    }
			}
		    }
		}
	    }

	    return types;

	}

	return Collections.emptyList();
    }

    // recupere une liste d'element en fonction du metamodele tu tool.
    private List<IElementType> getTypesFromToolMetaModel(ToolMetaModel tool) {
	List<IElementType> types = new ArrayList<IElementType>(1);
	EClassifier eClazzifier = UMLPackage.eINSTANCE.getEClassifier(tool.getMetaModel());
	if (eClazzifier != null) {
	    EObject obj = UMLFactory.eINSTANCE.create((EClass) eClazzifier);
	    IClientContext clientContext = ClientContextManager.getInstance().getClientContext("org.eclipse.papyrus.uml.diagram.clazz.TypeContext");
	    IElementType[] elementstype = ElementTypeRegistry.getInstance().getAllTypesMatching(obj, clientContext);
	    for (IElementType type : elementstype) {
		types.add(type);
	    }
	    return types;
	}
	return null;
    }
    

    private List<IElementType> getTypesFromElementType(Tool tool) {
	List<IElementType> types = new ArrayList<IElementType>(1);
	if (tool.getElementTypes() != null) {
	    for (ElementType type : tool.getElementTypes()) {
		String ID = type.getElementType();
		IElementType elementType = ElementTypeRegistry.getInstance().getType(ID);
		if (elementType != null) {
		    types.add(elementType);
		}
	    }
	    return types;
	}
	return null;

    }

    private boolean isValidateType(IElementType elementType, IGraphicalEditPart host) {
	CreateViewAndElementRequest request = new CreateViewAndElementRequest(elementType, null);
	Command cmd = host.getCommand(request);
	if (cmd != null && cmd.canExecute()) {
	    return true;
	}
	return false;
    }

}
