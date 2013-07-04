package org.eclipse.papyrus.dgts.service;

import java.util.List;


import org.eclipse.papyrus.dgts.service.interfaces.IToolsProvider;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.ToolElement;
public class ToolsProvider implements IToolsProvider {

	//get all tools from a diagram
	public List<ToolElement> getTools(DiagramDefinition diagram){
		return null;
	}
	
	//get all tools from a given diagram and a given drawer
	public List<ToolElement> getTools(DiagramDefinition diagram, DrawerDefinition drawer){
		return null;
	}
	
	//get all drawers from a diagram
	public List<DrawerDefinition> getDrawers(DiagramDefinition diagram){
		return null;
	}
}
