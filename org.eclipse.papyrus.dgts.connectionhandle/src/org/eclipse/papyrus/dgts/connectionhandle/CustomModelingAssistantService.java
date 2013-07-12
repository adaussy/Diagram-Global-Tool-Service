package org.eclipse.papyrus.dgts.connectionhandle;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.gmf.runtime.common.ui.services.util.ActivityFilterProviderDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;
import org.eclipse.gmf.runtime.emf.ui.internal.MslUIPlugin;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProviderConfiguration;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.dgts.service.DgtsResourceLoader;
import org.eclipse.papyrus.dgts.service.ToolDefinitionResourceProvider;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.ToolElement;

@SuppressWarnings("restriction")
public class CustomModelingAssistantService extends ModelingAssistantService {

    protected static class ProviderDescriptor extends ActivityFilterProviderDescriptor {

	/** the provider configuration parsed from XML */
	private ModelingAssistantProviderConfiguration providerConfiguration;

	/**
	 * Constructs a <code>ISemanticProvider</code> descriptor for the
	 * specified configuration element.
	 * 
	 * @param element
	 *            The configuration element describing the provider.
	 */
	public ProviderDescriptor(IConfigurationElement element) {
	    super(element);

	    this.providerConfiguration = ModelingAssistantProviderConfiguration.parse(element);
	    assert providerConfiguration != null : "providerConfiguration is null"; //$NON-NLS-1$
	}

	public boolean provides(IOperation operation) {
	    if (!super.provides(operation)) {
		return false;
	    }
	    if (!policyInitialized) {
		policy = getPolicy();
		policyInitialized = true;
	    }
	    if (policy != null)
		return policy.provides(operation);

	    return isSupportedInExtension(operation) ? getProvider().provides(operation) : false;
	}

	/**
	 * Checks if the operation is supported by the XML extension
	 * 
	 * @param operation
	 * @return true if the operation is supported; false otherwise
	 */
	private boolean isSupportedInExtension(IOperation operation) {
	    if (operation instanceof IModelingAssistantOperation) {
		String operationId = ((IModelingAssistantOperation) operation).getId();
		IAdaptable context = ((IModelingAssistantOperation) operation).getContext();

		return providerConfiguration.supports(operationId, context);
	    }
	    return false;
	}

    }

    /** The singleton instance of the modeling assistant service. */
    private final static CustomModelingAssistantService service = new CustomModelingAssistantService();

    static {
	service.configureProviders(MslUIPlugin.getPluginId(), "modelingAssistantProviders"); //$NON-NLS-1$
    }

    protected Service.ProviderDescriptor newProviderDescriptor(IConfigurationElement element) {
	return new ProviderDescriptor(element);
    }

    /**
     * Retrieves the singleton instance of the modeling assistant service.
     * 
     * @return The modeling assistant service singleton.
     */

    public static CustomModelingAssistantService getInstance() {
	return service;
    }

    public List getTypes(String hint, IAdaptable data) {
	System.out.println("function : getTypes");
	return super.getTypes(hint, data);
    }


    public List getRelTypesOnSource(IAdaptable source) {
	System.out.println("function : getRelTypesOnSource"+source);
	// on recupere la liste des lien possible depuis la source
	getPossibleRelTypes(source);

	return getPossibleRelTypes(source);
	// return super.getRelTypesOnSource(source);
    }

    /**
     * Executes the <code>GetRelTypesOnTargetOperation</code> using the
     * <code>FORWARD</code> execution strategy.
     */
    public List getRelTypesOnTarget(IAdaptable target) {
	System.out.println("function : getRelTypesOnTarget");
	return getPossibleRelTypes(target);
	// return super.getRelTypesOnTarget(target);
    }

    /**
     * Executes the <code>GetRelTypesOnSourceAndTargetOperation</code> using the
     * <code>FORWARD</code> execution strategy.
     */
    public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
	System.out.println("function : getRelTypesOnSourceAndTarget");
	return super.getRelTypesOnSourceAndTarget(source, target);
    }

    /**
     * Executes the <code>GetRelTypesForSREOnSourceOperation</code> using the
     * <code>FORWARD</code> execution strategy.
     */
    public List getRelTypesForSREOnSource(IAdaptable source) {
	System.out.println("function : getRelTypesForSREOnSource");
	return getPossibleRelTypes(source);
	// return super.getRelTypesForSREOnSource(source);
    }

    /**
     * Executes the <code>GetRelTypesForSREOnTargetOperation</code> using the
     * <code>FORWARD</code> execution strategy.
     */
    public List getRelTypesForSREOnTarget(IAdaptable target) {
	System.out.println("function : getRelTypesForSREOnTarget");
	return getPossibleRelTypes(target);
	// return super.getRelTypesForSREOnTarget(target);
    }

    /**
     * Executes the <code>GetTypesForSourceOperation</code> using the
     * <code>FORWARD</code> execution strategy.
     */
    public List getTypesForSource(IAdaptable target, IElementType relationshipType) {

	System.out.println("function : getTypesForSource");
	// on recupere tout les types possible générés par le generateur
	List generatedTypes = super.getTypesForSource(target, relationshipType);
	// on recupere les types présents dans le modele de tools
	List possibleTypes = getPossibleElementTypes(target);

	// intersection des 2 listes
	possibleTypes.retainAll(generatedTypes);
	return possibleTypes;

    }

    /**
     * Executes the <code>GetTypesForTargetOperation</code> using the
     * <code>FORWARD</code> execution strategy.
     */

    public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {

	System.out.println("function : getTypesForSource");
	// on recupere tout les types possible générés par le generateur
	List generatedTypes = super.getTypesForSource(source, relationshipType);
	// on recupere les types présents dans le modele de tools
	List possibleTypes = getPossibleElementTypes(source);

	// intersection des 2 listes
	possibleTypes.retainAll(generatedTypes);
	return possibleTypes;

    }

    /**
     * Executes the <code>SelectExistingElementForSourceOperation</code> using
     * the <code>FIRST</code> execution strategy.
     */
    public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
	System.out.println("function : selectExistingElementForSource");
	return super.selectExistingElementForSource(target, relationshipType);
    }

    /**
     * Executes the <code>SelectExistingElementForTargetOperation</code> using
     * the <code>FIRST</code> execution strategy.
     */
    public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
	System.out.println("function : selectExistingElementForTarget");
	return super.selectExistingElementForTarget(source, relationshipType);
    }

    /**
     * Executes the <code>GetTypesForPopupBarOperation</code> using the
     * <code>FORWARD</code> execution strategy.
     */
    /*
     * public List getTypesForPopupBar(IAdaptable host) { List results =
     * execute(ExecutionStrategy.FORWARD, new
     * GetTypesForPopupBarOperation(host)); return collapseList(results); }
     */

    /**
     * Executes the <code>GetTypesForPopupBarOperation</code> using the
     * <code>FORWARD</code> execution strategy.
     * 
     * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getTypesForActionBar(IAdaptable)
     * @deprecated Renamed to {@link #getTypesForPopupBar(IAdaptable)}
     */

    public List getTypesForActionBar(IAdaptable host) {
	return super.getTypesForActionBar(host);
    }

    private List getPossibleElementTypes(IAdaptable element) {
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
		EClassifier eClazzifier = UMLPackage.eINSTANCE.getEClassifier(tool.getTool());
		if (eClazzifier != null) {

		    IElementType type = null;
		    EObject obj = UMLFactory.eINSTANCE.create((EClass) eClazzifier);

		    type = getElementType(diagramPart.getNotationView(), obj, diagramType);
		    if (type != null) {
			types.add(type);
		    }

		}

	    }

	    return types;

	}
	return null;

    }

    private List getPossibleRelTypes(IAdaptable element) {
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
		EClassifier eClazzifier = UMLPackage.eINSTANCE.getEClassifier(tool.getTool());
		if (eClazzifier != null) {

		    IElementType type = null;
		    EObject obj = UMLFactory.eINSTANCE.create((EClass) eClazzifier);

		    type = getLinkType(obj, diagramType);
		    if (type != null) {
			types.add(type);
		    }

		}

	    }

	    return types;

	}
	return null;

    }

    private IElementType getLinkType(EObject obj, String diagram) {
	int visualID;
	switch (diagram) {
	case "PapyrusUMLClassDiagram":
	    visualID = org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj);
	    if (visualID == -1) {
		// si c'est un element
		return null;
	    } else {
		return org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes.getElementType(visualID);
	    }

	case "PapyrusUMLActivityDiagram":
	    visualID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj);
	    if (visualID == -1) {
		// si c'est un element
		return null;
	    } else {
		return org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes.getElementType(visualID);
	    }

	case "PapyrusUMLCommunicationDiagram":
	    visualID = org.eclipse.papyrus.uml.diagram.communication.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj);
	    if (visualID == -1) {
		// si c'est un element
		return null;
	    } else {
		return org.eclipse.papyrus.uml.diagram.communication.providers.UMLElementTypes.getElementType(visualID);
	    }

	case "PapyrusUMLComponentDiagram":
	    visualID = org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj);
	    if (visualID == -1) {
		// si c'est un element
		return null;
	    } else {
		return org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.getElementType(visualID);
	    }

	case "CompositeStructure":
	    visualID = org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj);
	    if (visualID == -1) {
		// si c'est un element
		return null;
	    } else {
		return org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes.getElementType(visualID);
	    }

	case "PapyrusUMLDeploymentDiagram":
	    visualID = org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj);
	    if (visualID == -1) {
		// si c'est un element
		return null;
	    } else {
		return org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.getElementType(visualID);
	    }

	case "PapyrusUMLInteractionOverviewDiagram":
	    visualID = org.eclipse.papyrus.uml.diagram.interactionoverview.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj);
	    if (visualID == -1) {
		// si c'est un element
		return null;
	    } else {
		return org.eclipse.papyrus.uml.diagram.interactionoverview.provider.UMLElementTypes.getElementType(visualID);
	    }

	case "PapyrusUMLSequenceDiagram":
	    visualID = org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj);
	    if (visualID == -1) {
		// si c'est un element
		return null;
	    } else {
		return org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes.getElementType(visualID);
	    }

	case "PapyrusUMLStateMachineDiagram":
	    visualID = org.eclipse.papyrus.uml.diagram.statemachine.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj);
	    if (visualID == -1) {
		// si c'est un element
		return null;
	    } else {
		return org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes.getElementType(visualID);
	    }

	case "Package":
	    // TO DO --> le mecanisme est un peu different......c'est la loose.

	}
	return null;
    }

    private IElementType getElementType(View containerview, EObject obj, String diagram) {
	int visualID;

	switch (diagram) {
	case "PapyrusUMLClassDiagram":
	    if (org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj) != -1) {
		// si c'est un lien
		return null;
	    }
	    visualID = org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
	    // Objets speciauw a enlever du popup :
	    if (visualID == DefaultNamedElementEditPart.VISUAL_ID) {
		return null;
	    }
	    return org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes.getElementType(visualID);
	case "PapyrusUMLActivityDiagram":
	    if (org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj) != -1) {
		// null si c'est un lien
		return null;
	    }
	    visualID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
	    return org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes.getElementType(visualID);
	case "PapyrusUMLCommunicationDiagram":
	    if (org.eclipse.papyrus.uml.diagram.communication.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj) != -1) {
		// null si c'est un lien
		return null;
	    }
	    visualID = org.eclipse.papyrus.uml.diagram.communication.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
	    return org.eclipse.papyrus.uml.diagram.communication.providers.UMLElementTypes.getElementType(visualID);
	case "PapyrusUMLComponentDiagram":
	    if (org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj) != -1) {
		// null si c'est un lien
		return null;
	    }
	    visualID = org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
	    return org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.getElementType(visualID);
	case "CompositeStructure":
	    if (org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj) != -1) {
		// null si c'est un lien
		return null;
	    }
	    visualID = org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
	    return org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes.getElementType(visualID);
	case "PapyrusUMLDeploymentDiagram":
	    if (org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj) != -1) {
		// null si c'est un lien
		return null;
	    }
	    visualID = org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
	    return org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.getElementType(visualID);
	case "PapyrusUMLInteractionOverviewDiagram":
	    if (org.eclipse.papyrus.uml.diagram.interactionoverview.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj) != -1) {
		// null si c'est un lien
		return null;
	    }
	    visualID = org.eclipse.papyrus.uml.diagram.interactionoverview.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
	    return org.eclipse.papyrus.uml.diagram.interactionoverview.provider.UMLElementTypes.getElementType(visualID);
	    // !!! ici moche provider au lieu de providers

	case "PapyrusUMLSequenceDiagram":
	    if (org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj) != -1) {
		// null si c'est un lien
		return null;
	    }
	    visualID = org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
	    return org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes.getElementType(visualID);
	case "PapyrusUMLStateMachineDiagram":
	    if (org.eclipse.papyrus.uml.diagram.statemachine.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj) != -1) {
		// null si c'est un lien
		return null;
	    }
	    visualID = org.eclipse.papyrus.uml.diagram.statemachine.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
	    return org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes.getElementType(visualID);

	case "Package":
	    // TO DO --> le mecanisme est un peu different......c'est la loose.

	}
	return null;
    }
}
