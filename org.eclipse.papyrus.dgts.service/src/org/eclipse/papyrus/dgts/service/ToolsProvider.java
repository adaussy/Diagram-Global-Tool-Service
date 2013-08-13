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
package org.eclipse.papyrus.dgts.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.dgts.service.interfaces.IToolsProvider;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.ElementType;
import DiagramGlobalToolService.Tool;




/**
 * @author gdesq, vlartigaut
 *         This class is used to get elements of the diagramglobaltoolmodel.
 */
public class ToolsProvider implements IToolsProvider {

	// get the DiagramGlobalToolDefinition from a given resource
	public DiagramGlobalToolDefinition getDiagramGlobalToolDefinitionFromResource(Resource resource) {
		if(resource != null) {
			for(EObject object : resource.getContents()) {
				if(object instanceof DiagramGlobalToolDefinition) {
					return (DiagramGlobalToolDefinition)object;
				}
			}
		}
		return null;

	}

	// get Diagram from diagram string and resource
	public DiagramDefinition getDiagram(String diagramType, DiagramGlobalToolDefinition global) {

		if(global != null) {
			for(DiagramDefinition diagram : global.getDiagramDefinitionRef()) {
				if(diagram.getDiagramType().equals(diagramType)) {
					return diagram;
				}

			}

		}
		return null;
	}

	// get all Diagrams from GlobalDiagramToolDef
	public List<DiagramDefinition> getAllDiagrams(DiagramGlobalToolDefinition global) {
		List<DiagramDefinition> diags = new ArrayList<DiagramDefinition>();
		if(global != null) {
			for(DiagramDefinition diagram : global.getDiagramDefinitionRef()) {
				diags.add(diagram);
			}
			return diags;
		}
		return Collections.emptyList();
	}

	// get all tools from a diagram
	public List<Tool> getTools(DiagramDefinition diagram) {
		if(diagram != null) {
			List<Tool> toolList = new ArrayList<Tool>();
			for(DrawerDefinition drawer : diagram.getDrawerDefinitionRef()) {
				for(Tool tool : drawer.getToolRef()) {
					toolList.add(tool);
				}
			}
			return toolList;
		}
		return Collections.emptyList();
	}

	public List<Tool> getTools(List<DrawerDefinition> drawerList) {
		List<Tool> listTool = new ArrayList<>();
		for(DrawerDefinition drawerDefinition : drawerList) {
			listTool.addAll(getTools(drawerDefinition));
		}
		return listTool;
	}

	// get all tools from a given drawer
	public List<Tool> getTools(DrawerDefinition drawer) {
		if(drawer != null) {
			List<Tool> toolList = new ArrayList<Tool>();
			for(Tool tool : drawer.getToolRef()) {
				toolList.add(tool);
			}
			return toolList;
		}
		return Collections.emptyList();
	}

	// get all drawers from a diagram
	public List<DrawerDefinition> getDrawers(DiagramDefinition diagram) {
		if(diagram != null) {
			List<DrawerDefinition> drawerList = new ArrayList<DrawerDefinition>();
			for(DrawerDefinition drawer : diagram.getDrawerDefinitionRef()) {
				drawerList.add(drawer);
			}
			return drawerList;
		}
		return Collections.emptyList();
	}

	public List<DrawerDefinition> getDrawers(DiagramGlobalToolDefinition global) {
		List<DrawerDefinition> listDrawers = new ArrayList<>();
		if(global != null) {
			List<DiagramDefinition> listDiagram = getAllDiagrams(global);
			for(DiagramDefinition diagramDefinition : listDiagram) {
				listDrawers.addAll(getDrawers(diagramDefinition));
			}
		}
		return listDrawers;


	}

	public List<ElementType> getElementTypes(Tool tool) {
		if(tool != null) {
			List<ElementType> elementTypeList = new ArrayList<ElementType>();
			for(ElementType elementType : tool.getElementTypes()) {
				elementTypeList.add(elementType);
			}
			return elementTypeList;
		}
		return null;

	}

	public List<IElementType> getIElementTypesFromTool(Tool tool) {

		List<IElementType> types = new ArrayList<IElementType>(1);
		if(tool.getElementTypes() != null) {
			for(ElementType type : tool.getElementTypes()) {
				String ID = type.getElementType();
				IElementType elementType = ElementTypeRegistry.getInstance().getType(ID);
				if(elementType != null) {
					types.add(elementType);
				}
			}
			return types;
		}
		return null;

	}

	public List<Tool> getAllElement(DiagramGlobalToolDefinition globalToolDefinition) {
		List<Tool> listElement = new ArrayList<Tool>();
		for(DiagramDefinition diagram : globalToolDefinition.getDiagramDefinitionRef()) {
			listElement.addAll(this.getTools(diagram));

		}
		return listElement;
	}



}
