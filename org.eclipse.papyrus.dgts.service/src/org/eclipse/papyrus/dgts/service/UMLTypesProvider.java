package org.eclipse.papyrus.dgts.service;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;


public class UMLTypesProvider {
   
    
    
    /*
     * Return the element type of the link obj, return null if obj is not a link
     */
    public static IElementType getLinkType(EObject obj, String diagram) {
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

    /*
     * Return the element type of the node obj, return null if obj is not a node or is not defined
     */
    public static IElementType getElementType(View containerview, EObject obj, String diagram) {
	int visualID;

	switch (diagram) {
	case "PapyrusUMLClassDiagram":
	    if (org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getLinkWithClassVisualID(obj) != -1) {
		// si c'est un lien
		return null;
	    }
	    visualID = org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
	    // Objets speciaux a enlever du popup :
	    if (visualID == org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DefaultNamedElementEditPart.VISUAL_ID) {
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
