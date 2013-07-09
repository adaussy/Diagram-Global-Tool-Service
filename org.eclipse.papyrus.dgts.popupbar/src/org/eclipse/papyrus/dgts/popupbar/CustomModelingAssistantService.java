package org.eclipse.papyrus.dgts.popupbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.dgts.service.DgtsResourceLoader;
import org.eclipse.papyrus.dgts.service.ToolDefinitionResourceProvider;
import org.eclipse.papyrus.dgts.service.ToolsProvider;


import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;




import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.ToolElement;

public class CustomModelingAssistantService {

	private final static CustomModelingAssistantService service = new CustomModelingAssistantService();

	public static CustomModelingAssistantService getInstance() {
		return service;
	}


	
	/*Liste des diagrames possible en uml

	PapyrusUMLClassDiagram
	PapyrusUMLActivityDiagram
	PapyrusUMLCommunicationDiagram
	PapyrusUMLComponentDiagram
	CompositeStructure
	PapyrusUMLDeploymentDiagram
	PapyrusUMLInteractionOverviewDiagram
	Package
	PapyrusUMLSequenceDiagram
	PapyrusUMLStateMachineDiagram
	 */
	
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		
		
		
		//type du diagrame courant
		DiagramEditPart diagramPart = (DiagramEditPart)editPart.getRoot().getChildren().get(0);
		String diagramType = diagramPart.getDiagramView().getType();
		//System.out.println(diagramType);
	
		System.out.println(editPart);
		//if (editPart instanceof DiagramEditPart) {
			//declaration
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			ToolsProvider toolsProvider = new ToolsProvider();
			
			//recupere le globalDiagramConfiguration actif
			Resource resource = ToolDefinitionResourceProvider.getResource();
			DiagramGlobalToolDefinition globalDiagramConfiguration = DgtsResourceLoader.getDiagramGlobalToolDefinitionFromResource(resource);
			
			
			//recupere la liste des tools correspondant au diagrame
			DiagramDefinition diag = toolsProvider.getDiagram(diagramType, globalDiagramConfiguration);
			List<ToolElement> listOfTools = new ArrayList<ToolElement>();
			listOfTools = toolsProvider.getTools(diag);
			
			
			//traitement de chaque tool
			if (listOfTools !=null){
				for (ToolElement tool : listOfTools) {
	
					//System.out.println(tool.getTool());
					EClassifier eClazzifier = UMLPackage.eINSTANCE.getEClassifier(tool.getTool());
					if (eClazzifier != null) {
						
						View containerview = editPart.getNotationView();
						EObject obj = UMLFactory.eINSTANCE.create((EClass) eClazzifier);
						
						//recupere type correspondant au container a l'objet et au diagrame en cours	
						IElementType type = getElementType(containerview,obj,diagramType);
					


						types.add(type);
					}
	
				}
				
				return types;
			//}
		}

		return Collections.EMPTY_LIST;
	}

	private IElementType getElementType(View containerview, EObject obj, String diagram) {
		int visualID;
		switch (diagram){
		case "PapyrusUMLClassDiagram":
			visualID = org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
			return org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes.getElementType(visualID);
		case "PapyrusUMLActivityDiagram":
			visualID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
			return org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes.getElementType(visualID);
		case "PapyrusUMLCommunicationDiagram":
			visualID = org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
			return org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes.getElementType(visualID);	
		case "PapyrusUMLComponentDiagram":
			visualID = org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
			return org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.getElementType(visualID);	
		case "CompositeStructure":
			visualID = org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
			return org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes.getElementType(visualID);	
		case "PapyrusUMLDeploymentDiagram":
			visualID = org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
			return org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.getElementType(visualID);	
		case "PapyrusUMLInteractionOverviewDiagram":
			visualID = org.eclipse.papyrus.uml.diagram.interactionoverview.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
			return org.eclipse.papyrus.uml.diagram.interactionoverview.provider.UMLElementTypes.getElementType(visualID);	
			//!!! ici moche provider au lieu de providers
		case "Package":
		//TO DO --> le mecanisme est un peu different...
		case "PapyrusUMLSequenceDiagram":
			visualID = org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
			return org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes.getElementType(visualID);	
		case "PapyrusUMLStateMachineDiagram":
			visualID = org.eclipse.papyrus.uml.diagram.statemachine.part.UMLVisualIDRegistry.getNodeVisualID(containerview, obj);
			return org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes.getElementType(visualID);	
			
			
			
		}
		return null;
	}
}


