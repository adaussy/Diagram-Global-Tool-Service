package org.eclipse.papyrus.dgts.service.interfaces;

import java.util.List;
import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.ToolElement;

public interface IToolsProvider {
	// get Diagram from diagram string and resource
	public DiagramDefinition getDiagram(String diagramType,
			DiagramGlobalToolDefinition global);

	// get all tools from a diagram
	public abstract List<ToolElement> getTools(DiagramDefinition diagram);

	// get all tools from a given drawer
	public abstract List<ToolElement> getTools(DrawerDefinition drawer);

	// get all drawers from a diagram
	public abstract List<DrawerDefinition> getDrawers(DiagramDefinition diagram);

}