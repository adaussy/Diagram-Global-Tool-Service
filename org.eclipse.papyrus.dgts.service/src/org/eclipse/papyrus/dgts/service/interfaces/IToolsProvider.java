package org.eclipse.papyrus.dgts.service.interfaces;

import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import DiagramGlobalToolService.AbstractTool;
import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.Tool;
import DiagramGlobalToolService.ToolMetaModel;

public interface IToolsProvider {
	// get Diagram from diagram string and resource
	public DiagramDefinition getDiagram(String diagramType,
			DiagramGlobalToolDefinition global);

	// get all tools from a diagram
	public abstract List<AbstractTool> getTools(DiagramDefinition diagram);

	// get all tools from a given drawer
	public abstract List<AbstractTool> getTools(DrawerDefinition drawer);

	// get all drawers from a diagram
	public abstract List<DrawerDefinition> getDrawers(DiagramDefinition diagram);
	
	public List<IElementType> getIElementTypesFromTool(Tool tool);
	
	public List<IElementType> getIElementTypesFromToolMetaModel(ToolMetaModel tool, IClientContext clientContext);

}