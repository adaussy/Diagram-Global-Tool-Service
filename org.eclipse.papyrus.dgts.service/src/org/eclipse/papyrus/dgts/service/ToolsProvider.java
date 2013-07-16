package org.eclipse.papyrus.dgts.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.dgts.service.interfaces.IToolsProvider;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import DiagramGlobalToolService.AbstractTool;
import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.ElementType;
import DiagramGlobalToolService.Tool;
import DiagramGlobalToolService.ToolMetaModel;

public class ToolsProvider implements IToolsProvider {

	// get Diagram from diagram string and resource
	public DiagramDefinition getDiagram(String diagramType,
			DiagramGlobalToolDefinition global) {

		if (global != null) {
			for (DiagramDefinition diagram : global.getDiagramDefinitionRef()) {
				if (diagram.getDiagramType().equals(diagramType)) {
					return diagram;
				}

			}
			
			
		}
		return null;
	}

	// get all tools from a diagram
	public List<AbstractTool> getTools(DiagramDefinition diagram) {
		if (diagram != null) {
			List<AbstractTool> toolList = new ArrayList<AbstractTool>();
			for (DrawerDefinition drawer : diagram.getDrawerDefinitionRef()) {
				for (AbstractTool tool : drawer.getAbstractToolRef()) {
					toolList.add(tool);
				}
			}
			return toolList;
		}
		return null;
	}

	// get all tools from a given drawer
	public List<AbstractTool> getTools(DrawerDefinition drawer) {
		if (drawer != null) {
			List<AbstractTool> toolList = new ArrayList<AbstractTool>();
			for (AbstractTool tool : drawer.getAbstractToolRef()) {
				toolList.add(tool);
			}
			return toolList;
		}
		return null;
	}

	// get all drawers from a diagram
	public List<DrawerDefinition> getDrawers(DiagramDefinition diagram) {
		if (diagram != null) {
			List<DrawerDefinition> drawerList = new ArrayList<DrawerDefinition>();
			for (DrawerDefinition drawer : diagram.getDrawerDefinitionRef()) {
				drawerList.add(drawer);
			}
			return drawerList;
		}
		return null;
	}
	
	public List<ElementType> getElementTypes(Tool tool){
		if(tool != null){
			List<ElementType> elementTypeList = new ArrayList<ElementType>();	
			for(ElementType elementType : tool.getElementTypes()){
				elementTypeList.add(elementType);
			}
			return elementTypeList ;
		}
		return null;
		
	}
	
	
	 // recupere une liste d'element en fonction du metamodele tu tool.
	    public List<IElementType> getIElementTypesFromToolMetaModel(ToolMetaModel tool, IClientContext clientContext) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		EClassifier eClazzifier = UMLPackage.eINSTANCE.getEClassifier(tool.getMetaModel());
		if (eClazzifier != null) {
		    EObject obj = UMLFactory.eINSTANCE.create((EClass) eClazzifier);
		
		    IElementType[] elementstype = ElementTypeRegistry.getInstance().getAllTypesMatching(obj, clientContext);
		    for (IElementType type : elementstype) {
			types.add(type);
		    }
		    return types;
		}
		return null;
	    }
	    // recupere une liste d'IElementType en fonction d'un tool
	    public List<IElementType> getIElementTypesFromTool(Tool tool) {

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
	
	
}
