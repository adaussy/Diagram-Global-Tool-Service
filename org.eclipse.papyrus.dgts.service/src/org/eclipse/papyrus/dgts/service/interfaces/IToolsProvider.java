package org.eclipse.papyrus.dgts.service.interfaces;

import java.util.List;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.ToolElement;

public interface IToolsProvider {

	//get all tools from a diagram
	public abstract List<ToolElement> getTools(DiagramDefinition diagram);

	//get all tools from a given diagram and a given drawer
	public abstract List<ToolElement> getTools(DiagramDefinition diagram,DrawerDefinition drawer);

	//get all drawers from a diagram
	public abstract List<DrawerDefinition> getDrawers(DiagramDefinition diagram);

}