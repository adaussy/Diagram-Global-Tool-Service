package org.eclipse.papyrus.dgts.connectionhandle;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.internal.MslUIPlugin;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.GetRelTypesOnSourceAndTargetOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.dgts.service.DgtsResourceLoader;
import org.eclipse.papyrus.dgts.service.ToolDefinitionResourceProvider;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.service.UMLTypesProvider;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.ToolElement;

@SuppressWarnings("restriction")
public class CustomModelingAssistantService extends ModelingAssistantService {


    /** The singleton instance of the modeling assistant service. */
    private final static CustomModelingAssistantService service = new CustomModelingAssistantService();

    
    static {
	service.configureProviders(MslUIPlugin.getPluginId(), "modelingAssistantProviders"); //$NON-NLS-1$
    }

    /**
     * Retrieves the singleton instance of the custom modeling assistant service.
     * 
     * @return The custom modeling assistant service singleton.
     */

    public static CustomModelingAssistantService getInstance() {
	return service;
    }
    
    
   
    @Override
    public List<?> getRelTypesOnSource(IAdaptable source) {
	return getPossibleRelTypes(source);
	
    }
    @Override
    public List<?> getRelTypesOnTarget(IAdaptable target) {
	return getPossibleRelTypes(target);
    }
    @Override
    public List<?> getRelTypesForSREOnSource(IAdaptable source) {
	return getPossibleRelTypes(source);
    }
    @Override
    public List<?> getRelTypesForSREOnTarget(IAdaptable target) {
	return getPossibleRelTypes(target);
    }
@Override
public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
    return getPossibleRelTypes(source);
		
}

    
    @Override
    public List<?> getTypesForSource(IAdaptable target, IElementType relationshipType) {

	
	// on recupere tout les types possible générés par le generateur
	List<?> generatedTypes = super.getTypesForSource(target, relationshipType);
	// on recupere les types présents dans le modele de tools
	List<?> possibleTypes = getPossibleElementTypes(target);

	// intersection des 2 listes
	possibleTypes.retainAll(generatedTypes);
	return possibleTypes;

    }
    @Override
    public List<?> getTypesForTarget(IAdaptable source, IElementType relationshipType) {

	
	// on recupere tout les types possible générés par le generateur
	List<?> generatedTypes = super.getTypesForSource(source, relationshipType);
	// on recupere les types présents dans le modele de tools
	List<?> possibleTypes = getPossibleElementTypes(source);

	// intersection des 2 listes
	possibleTypes.retainAll(generatedTypes);
	return possibleTypes;

    }

    
    private List<?> getPossibleElementTypes(IAdaptable element) {
	IGraphicalEditPart editPart = (IGraphicalEditPart) element.getAdapter(IGraphicalEditPart.class);
	
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
	List<ToolElement> listOfTools = new ArrayList<ToolElement>();
	listOfTools = toolsProvider.getTools(diag);

	// traitement de chaque tool
	if (listOfTools != null) {
	    for (ToolElement tool : listOfTools) {

		// System.out.println(tool.getTool());
		EClassifier eClazzifier = UMLPackage.eINSTANCE.getEClassifier(tool.getName());
		if (eClazzifier != null) {

		    IElementType type = null;
		    EObject obj = UMLFactory.eINSTANCE.create((EClass) eClazzifier);

		    type = UMLTypesProvider.getElementType(diagramPart.getNotationView(), obj, diagramType);
		    if (type != null) {
			types.add(type);
		    }

		}

	    }

	    return types;

	}
	return null;

    }

    private List<?> getPossibleRelTypes(IAdaptable element) {
	IGraphicalEditPart editPart = (IGraphicalEditPart) element.getAdapter(IGraphicalEditPart.class);

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
	List<ToolElement> listOfTools = new ArrayList<ToolElement>();
	listOfTools = toolsProvider.getTools(diag);

	// traitement de chaque tool
	if (listOfTools != null) {
	    for (ToolElement tool : listOfTools) {

		// System.out.println(tool.getTool());
		EClassifier eClazzifier = UMLPackage.eINSTANCE.getEClassifier(tool.getName());
		if (eClazzifier != null) {

		    IElementType type = null;
		    EObject obj = UMLFactory.eINSTANCE.create((EClass) eClazzifier);
		    type = UMLTypesProvider.getLinkType(obj, diagramType);
		    if (type != null) {
			types.add(type);
		    }

		}

	    }

	    return types;

	}
	return null;

    }


}
