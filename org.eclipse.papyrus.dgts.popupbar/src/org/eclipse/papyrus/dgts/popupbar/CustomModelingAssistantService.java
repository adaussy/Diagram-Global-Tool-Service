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

public class CustomModelingAssistantService {

    private final static CustomModelingAssistantService service = new CustomModelingAssistantService();

    public static CustomModelingAssistantService getInstance() {
	return service;
    }

    // test function
    private List<IElementType> getAllTypeFromName(AbstractTool tool) {
	List<IElementType> types = new ArrayList<IElementType>(1);
	EClassifier eClazzifier = UMLPackage.eINSTANCE.getEClassifier(tool.getName());
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
    
    private static String getUMLID(String type) {
   	StringBuilder builder = new StringBuilder("org.eclipse.papyrus.uml.diagram.clazz.");
   	builder.append(type);
   	return builder.toString();
       }


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
		
		
		
		/*
		 * OLD WAY // System.out.println(tool.getTool()); EClassifier
		 * eClazzifier =
		 * UMLPackage.eINSTANCE.getEClassifier(tool.getName()); if
		 * (eClazzifier != null) {
		 * 
		 * EObject obj = UMLFactory.eINSTANCE.create((EClass)
		 * eClazzifier);
		 * 
		 * // recupere type correspondant au container a l'objet et au
		 * // diagrame en cours IElementType type =
		 * UMLTypesProvider.getElementType(containerview, obj,
		 * diagramType); //IElementType[] elementstype =
		 * ElementTypeRegistry.getInstance().getAllTypesMatching(obj,
		 * clientContext);
		 * 
		 * 
		 * 
		 * types.add(type);
		 */
		
		
		
		/*
		List <IElementType> typesToTest = getAllTypeFromName(tool);
		if (typesToTest !=null){
        		for (IElementType type : typesToTest){
        		    if (type != null && (!(type instanceof MetamodelType))) {
        			    CreateViewAndElementRequest request = new CreateViewAndElementRequest(type, null);
        			    Command cmd = editPart.getCommand(request);
        			    if (cmd != null && cmd.canExecute()) {
        				types.add(type);
        
        			    }
        			}
        		}
		}*/
		/*
		String ID = tool.getIElementType();
		IElementType elementType = ElementTypeRegistry.getInstance().getType(getUMLID(ID));
		if (elementType != null) {
		    CreateViewAndElementRequest request = new CreateViewAndElementRequest(elementType, null);
		    Command cmd = editPart.getCommand(request);
		    if (cmd != null && cmd.canExecute()) {
			types.add(elementType);

		    }
		}*/
		
		

	    }

	    return types;

	}

	return Collections.emptyList();
    }

}
