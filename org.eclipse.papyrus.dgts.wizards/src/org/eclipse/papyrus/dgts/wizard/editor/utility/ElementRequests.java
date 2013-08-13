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

package org.eclipse.papyrus.dgts.wizard.editor.utility;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolServiceFactory;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.ElementType;
import DiagramGlobalToolService.Icon;
import DiagramGlobalToolService.Tool;
import ElementRegistry.EClassDefinition;




/**
 * 
 * Requests used to create or remove elements in the dgts model.
 * 
 * @author gdesq
 * 
 */
public class ElementRequests {

	public static void addIconReference(DrawerDefinition drawer) {
		if(drawer.getIconReference() == null) {

			Icon icon = DiagramGlobalToolServiceFactory.eINSTANCE.createIcon();
			drawer.setIconReference(icon);
		}
	}

	public static void addIconReference(Tool tool) {
		if(tool.getIconReference() == null) {

			Icon icon = DiagramGlobalToolServiceFactory.eINSTANCE.createIcon();
			tool.setIconReference(icon);
		}
	}

	public static void deleteIconReference(DrawerDefinition drawer) {
		if(drawer.getIconReference() != null) {
			drawer.setIconReference(null);
		}
	}

	public static void deleteIconReference(Tool tool) {
		if(tool.getIconReference() != null) {
			tool.setIconReference(null);

		}
	}

	public static void addDrawer(DiagramDefinition diagram) {
		if(diagram != null) {

			DrawerDefinition drawer = DiagramGlobalToolServiceFactory.eINSTANCE.createDrawerDefinition();
			drawer.setName("New Drawer");
			diagram.getDrawerDefinitionRef().add(drawer);

		}

	}

	public static void deleteDrawer(DrawerDefinition drawer) {
		if(drawer != null) {
			((DiagramDefinition)drawer.eContainer()).getDrawerDefinitionRef().remove(drawer);
		}

	}

	public static void addTool(DrawerDefinition drawer) {
		if(drawer != null) {

			Tool tool = DiagramGlobalToolServiceFactory.eINSTANCE.createTool();
			tool.setName("New Tool");
			drawer.getToolRef().add(tool);

		}

	}

	public static void deleteTool(Tool tool) {
		if(tool != null) {

			((DrawerDefinition)tool.eContainer()).getToolRef().remove(tool);

		}

	}

	public static void addElementType(Tool tool, IElementType ielementType) {
		if(tool != null) {

			ElementType element = DiagramGlobalToolServiceFactory.eINSTANCE.createElementType();
			element.setElementType(ielementType.getId());

			tool.getElementTypes().add(element);
		}

	}

	public static void deleteIElementType(IElementType element, Tool tool) {
		if(tool != null && element != null) {

			Collection<ElementType> toDelete = new ArrayList<ElementType>();

			for(ElementType type : tool.getElementTypes()) {

				if(type.getElementType().equals(element.getId())) {
					toDelete.add(type);

				}
			}
			tool.getElementTypes().removeAll(toDelete);

		}

	}

	public static void addNewToolFromEclass(EClassDefinition eclass, DrawerDefinition drawer) {
		if(drawer != null) {

			Tool tool = DiagramGlobalToolServiceFactory.eINSTANCE.createTool();
			tool.setName(eclass.getEClass().getName());
			for(ElementRegistry.ElementType element : eclass.getRefElementTypes()) {
				ElementType type = DiagramGlobalToolServiceFactory.eINSTANCE.createElementType();
				type.setElementType(element.getElementTypeID());
				tool.getElementTypes().add(type);
			}
			drawer.getToolRef().add(tool);

		}

	}

}
