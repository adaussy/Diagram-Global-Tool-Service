package org.eclipse.papyrus.dgts.connectionhandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.internal.MslUIPlugin;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.dgts.service.DgtsResourceLoader;
import org.eclipse.papyrus.dgts.service.ToolDefinitionResourceProvider;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.service.UMLTypesProvider;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedTypesRegistry;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.AbstractTool;

@SuppressWarnings("restriction")
public class CustomModelingAssistantService extends ModelingAssistantService {

    /** The singleton instance of the modeling assistant service. */
    private final static CustomModelingAssistantService service = new CustomModelingAssistantService();

    static {
	service.configureProviders(MslUIPlugin.getPluginId(), "modelingAssistantProviders"); //$NON-NLS-1$
    }

    /**
     * Retrieves the singleton instance of the custom modeling assistant
     * service.
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
    public List<?> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
	return getPossibleRelTypes(source);

    }

    public List<?> getTypesForSourceAndContainer(IAdaptable target, IElementType relationshipType, IGraphicalEditPart container) {
	
	//TODO : recuperer les types possibles directement depuis le modèle et non pas avec la fonction super.getTypesFor source, qui ne renvoie pas toujours ce qu'il faut.
	
	// on recupere tout les types possible générés
	List<?> generatedTypes = super.getTypesForSource(target, relationshipType);
	if (generatedTypes!=null){
	// on recupere les types présents dans le modele de tools
	List<?> possibleTypes = getPossibleElementTypes(container);

	// intersection des 2 listes
	possibleTypes.retainAll(generatedTypes);
	return possibleTypes;
	}
	return null;

    }

    public List<?> getTypesForTargetAndContainer(IAdaptable source, IElementType relationshipType, IGraphicalEditPart container) {
	
	//TODO : recuperer les types possibles directement depuis le modèle et non pas avec la fonction super.getTypesFor source, qui ne renvoie pas toujours ce qu'il faut.
	
	// on recupere tout les types possible générés
	List<?> generatedTypes = super.getTypesForTarget(source, relationshipType);
	
	if (generatedTypes != null) {
	 // on recupere les types présents dans le modele de tools
	    List<?> possibleTypes = getPossibleElementTypes(container);

	    // intersection des 2 listes
	    possibleTypes.retainAll(generatedTypes);
	    return possibleTypes;
	}
	return null;
    }

    private List<?> getPossibleElementTypes(IAdaptable element) {
	IGraphicalEditPart editPart = (IGraphicalEditPart) element.getAdapter(IGraphicalEditPart.class);

	// type du diagrame courant
	DiagramEditPart diagramPart = (DiagramEditPart) editPart.getRoot().getChildren().get(0);
	String diagramType = diagramPart.getDiagramView().getType();

	// declaration
	List<IElementType> types = new ArrayList<IElementType>(1);
	ToolsProvider toolsProvider = new ToolsProvider();
	View containerview = editPart.getNotationView();
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

		// System.out.println(tool.getTool());
		EClassifier eClazzifier = UMLPackage.eINSTANCE.getEClassifier(tool.getName());
		if (eClazzifier != null) {

		    IElementType type = null;
		    EObject obj = UMLFactory.eINSTANCE.create((EClass) eClazzifier);

		    type = UMLTypesProvider.getElementType(containerview, obj, diagramType);
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
	
	
	IClientContext clientContext = ClientContextManager.getInstance().getClientContext("org.eclipse.papyrus.uml.diagram.clazz.TypeContext");
	
	
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

		// System.out.println(tool.getTool());
		EClassifier eClazzifier = UMLPackage.eINSTANCE.getEClassifier(tool.getName());
		if (eClazzifier != null) {

		    IElementType type = null;
		    EObject obj = UMLFactory.eINSTANCE.create((EClass) eClazzifier);
		    type = UMLTypesProvider.getLinkType(obj, diagramType);
		    IElementType elementTypeTest = ElementTypeRegistry.getInstance().getElementType((EClass)eClazzifier, clientContext);
		    IElementType[] elementstype = ElementTypeRegistry.getInstance().getAllTypesMatching(obj, clientContext);
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
