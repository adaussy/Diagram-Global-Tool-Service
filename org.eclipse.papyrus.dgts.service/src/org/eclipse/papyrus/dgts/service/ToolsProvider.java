package org.eclipse.papyrus.dgts.service;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.papyrus.dgts.service.interfaces.IToolsProvider;
import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.ToolElement;

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
	public List<ToolElement> getTools(DiagramDefinition diagram) {
		if (diagram != null) {
			List<ToolElement> toolList = new ArrayList<ToolElement>();
			for (DrawerDefinition drawer : diagram.getDrawerDefinitionRef()) {
				for (ToolElement tool : drawer.getToolElementRef()) {
					toolList.add(tool);
				}
			}
			return toolList;
		}
		return null;
	}

	// get all tools from a given drawer
	public List<ToolElement> getTools(DrawerDefinition drawer) {
		if (drawer != null) {
			List<ToolElement> toolList = new ArrayList<ToolElement>();
			for (ToolElement tool : drawer.getToolElementRef()) {
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
}
