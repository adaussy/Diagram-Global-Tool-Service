package org.eclipse.papyrus.dgts.wizards.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.dgts.service.ToolsProvider;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolServiceFactory;
import DiagramGlobalToolService.DiagramGlobalToolServicePackage;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.ElementType;
import DiagramGlobalToolService.Icon;
import DiagramGlobalToolService.Tool;
import ElementRegistry.EClassDefinition;

public class ElementRequests {

    public static void addIconReference(DrawerDefinition drawer) {
	if (drawer.getIconReference() == null) {

	    Icon icon = DiagramGlobalToolServiceFactory.eINSTANCE.createIcon();
	    drawer.setIconReference(icon);
	}
    }

    public static void addIconReference(Tool tool) {
	if (tool.getIconReference() == null) {

	    Icon icon = DiagramGlobalToolServiceFactory.eINSTANCE.createIcon();
	    tool.setIconReference(icon);
	}
    }

    public static void deleteIconReference(DrawerDefinition drawer) {
	if (drawer.getIconReference() != null) {
	    drawer.setIconReference(null);
	}
    }

    public static void deleteIconReference(Tool tool) {
	if (tool.getIconReference() != null) {
	    tool.setIconReference(null);

	}
    }

    public static void addDrawer(DiagramDefinition diagram) {
	if (diagram != null) {

	    DrawerDefinition drawer = DiagramGlobalToolServiceFactory.eINSTANCE.createDrawerDefinition();
	    drawer.setName("New Drawer");
	    diagram.getDrawerDefinitionRef().add(drawer);

	}

    }

    public static void deleteDrawer(DrawerDefinition drawer) {
	if (drawer != null) {
	    ((DiagramDefinition) drawer.eContainer()).getDrawerDefinitionRef().remove(drawer);
	}

    }

    public static void addTool(DrawerDefinition drawer) {
	if (drawer != null) {

	    Tool tool = DiagramGlobalToolServiceFactory.eINSTANCE.createTool();
	    tool.setName("New Tool");
	    drawer.getToolRef().add(tool);

	}

    }

    public static void deleteTool(Tool tool) {
	if (tool != null) {

	    ((DrawerDefinition) tool.eContainer()).getToolRef().remove(tool);

	}

    }

    public static void addElementType(Tool tool, IElementType ielementType) {
	if (tool != null) {

	    ElementType element = DiagramGlobalToolServiceFactory.eINSTANCE.createElementType();
	    element.setElementType(ielementType.getId());

	    tool.getElementTypes().add(element);
	}

    }

    public static void deleteIElementType(IElementType element, Tool tool) {
	if (tool != null && element != null) {

	    Collection<ElementType> toDelete = new ArrayList<ElementType>();

	    for (ElementType type : tool.getElementTypes()) {

		if (type.getElementType().equals(element.getId())) {
		    toDelete.add(type);

		}
	    }
	    tool.getElementTypes().removeAll(toDelete);

	}

    }

    public static void addNewToolFromEclass(EClassDefinition eclass, DrawerDefinition drawer) {
	if (drawer != null) {

	    Tool tool = DiagramGlobalToolServiceFactory.eINSTANCE.createTool();
	    tool.setName(eclass.getEClass().getName());
	    for (ElementRegistry.ElementType element : eclass.getRefElementTypes()) {
		ElementType type = DiagramGlobalToolServiceFactory.eINSTANCE.createElementType();
		type.setElementType(element.getElementTypeID());
		tool.getElementTypes().add(type);
	    }
	    drawer.getToolRef().add(tool);

	}

    }

}
