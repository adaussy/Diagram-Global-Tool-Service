/*******************************************************************************
 * Copyright  2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Vincent Lartigaut (Atos) vincent.lartigaut@atos.net - Vincent Lartigaut - initial API and implementation
 * Guilhem Desq (Atos) guilhem.desq@atos.net -  Guilhem Desq - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.dgts.service.interfaces;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.Tool;

public interface IToolsProvider {
	
    	// get all Diagrams from GlobalDiagramToolDef
    	public List<DiagramDefinition> getAllDiagrams(DiagramGlobalToolDefinition global);
    	// get the DiagramGlobalToolDefinition from a given resource
    	public DiagramGlobalToolDefinition getDiagramGlobalToolDefinitionFromResource(Resource resource);
    
    	// get Diagram from diagram string and resource
	public DiagramDefinition getDiagram(String diagramType,
			DiagramGlobalToolDefinition global);

	// get all tools from a diagram
	public abstract List<Tool> getTools(DiagramDefinition diagram);

	// get all tools from a given drawer
	public abstract List<Tool> getTools(DrawerDefinition drawer);

	// get all drawers from a diagram
	public abstract List<DrawerDefinition> getDrawers(DiagramDefinition diagram);
	
	public List<IElementType> getIElementTypesFromTool(Tool tool);
	
	//public List<IElementType> getIElementTypesFromToolMetaModel(ToolMetaModel tool, IClientContext clientContext);

}