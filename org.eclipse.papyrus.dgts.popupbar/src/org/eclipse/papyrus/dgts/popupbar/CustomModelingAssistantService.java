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


import org.eclipse.papyrus.dgts.service.UMLTypesProvider;
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


	
	
	
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		
		
		
		//type du diagrame courant
		DiagramEditPart diagramPart = (DiagramEditPart)editPart.getRoot().getChildren().get(0);
		String diagramType = diagramPart.getDiagramView().getType();
	
	
			//declaration
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			ToolsProvider toolsProvider = new ToolsProvider();
			
			//recupere le container
			View containerview = editPart.getNotationView();
			
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
					EClassifier eClazzifier = UMLPackage.eINSTANCE.getEClassifier(tool.getName());
					if (eClazzifier != null) {
						
						
						EObject obj = UMLFactory.eINSTANCE.create((EClass) eClazzifier);
						
						//recupere type correspondant au container a l'objet et au diagrame en cours	
						IElementType type = UMLTypesProvider.getElementType(containerview,obj,diagramType);
			


						types.add(type);
					}
	
				}
				
				return types;
		
		}

		return Collections.EMPTY_LIST;
	}

	
}


