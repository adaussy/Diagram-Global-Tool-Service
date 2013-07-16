package org.eclipse.papyrus.dgts.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.dgts.service.interfaces.IToolsProvider;

import DiagramGlobalToolService.AbstractTool;
import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.ElementType;
import DiagramGlobalToolService.Tool;

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
}
