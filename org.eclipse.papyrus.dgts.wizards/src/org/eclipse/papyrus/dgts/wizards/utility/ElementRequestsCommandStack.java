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

public class ElementRequestsCommandStack {

    public static void addIconReference(DrawerDefinition drawer) {
	if (drawer.getIconReference() == null) {
	    Object editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(drawer);
	    if (editingDomain instanceof EditingDomain) {
		EditingDomain domain = (EditingDomain) editingDomain;
		Icon icon = DiagramGlobalToolServiceFactory.eINSTANCE.createIcon();
		SetCommand cmd = new SetCommand(domain, drawer, DiagramGlobalToolServicePackage.Literals.DRAWER_DEFINITION__ICON_REFERENCE, icon);
		if ((cmd != null) && cmd.canExecute()) {
		    domain.getCommandStack().execute(cmd);
		}
	    }
	}
    }

    public static void addIconReference(Tool tool) {
	if (tool.getIconReference() == null) {
	    Object editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(tool);
	    if (editingDomain instanceof EditingDomain) {
		EditingDomain domain = (EditingDomain) editingDomain;
		Icon icon = DiagramGlobalToolServiceFactory.eINSTANCE.createIcon();
		SetCommand cmd = new SetCommand(domain, tool, DiagramGlobalToolServicePackage.Literals.TOOL__ICON_REFERENCE, icon);
		if ((cmd != null) && cmd.canExecute()) {
		    domain.getCommandStack().execute(cmd);
		}
	    }
	}
    }

    public static void deleteIconReference(DrawerDefinition drawer) {
	if (drawer.getIconReference() != null) {
	    Object editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(drawer);
	    if (editingDomain instanceof EditingDomain) {
		EditingDomain domain = (EditingDomain) editingDomain;

		SetCommand cmd = new SetCommand(domain, drawer, DiagramGlobalToolServicePackage.Literals.DRAWER_DEFINITION__ICON_REFERENCE, SetCommand.UNSET_VALUE);
		if ((cmd != null) && cmd.canExecute()) {
		    domain.getCommandStack().execute(cmd);
		}
	    }
	}
    }

    public static void deleteIconReference(Tool tool) {
	if (tool.getIconReference() != null) {
	    Object editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(tool);
	    if (editingDomain instanceof EditingDomain) {
		EditingDomain domain = (EditingDomain) editingDomain;

		SetCommand cmd = new SetCommand(domain, tool, DiagramGlobalToolServicePackage.Literals.TOOL__ICON_REFERENCE, SetCommand.UNSET_VALUE);
		if ((cmd != null) && cmd.canExecute()) {
		    domain.getCommandStack().execute(cmd);
		}
	    }
	}
    }

    public static void addDrawer(DiagramDefinition diagram) {
	if (diagram != null) {
	    Object editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(diagram);
	    if (editingDomain instanceof EditingDomain) {
		EditingDomain domain = (EditingDomain) editingDomain;
		DrawerDefinition drawer = DiagramGlobalToolServiceFactory.eINSTANCE.createDrawerDefinition();
		drawer.setName("New Drawer");

		AddCommand cmd = new AddCommand(domain, diagram, DiagramGlobalToolServicePackage.Literals.DIAGRAM_DEFINITION__DRAWER_DEFINITION_REF, drawer);
		if ((cmd != null) && cmd.canExecute()) {
		    domain.getCommandStack().execute(cmd);
		}
	    }
	}

    }

    public static void deleteDrawer(DrawerDefinition drawer) {
	if (drawer != null) {
	    Object editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(drawer);
	    Collection<DrawerDefinition> drawers = new ArrayList<DrawerDefinition>();
	    drawers.add(drawer);
	    if (editingDomain instanceof EditingDomain) {
		EditingDomain domain = (EditingDomain) editingDomain;

		DeleteCommand cmd = new DeleteCommand(domain, drawers);
		if ((cmd != null) && cmd.canExecute()) {
		    domain.getCommandStack().execute(cmd);
		}
	    }
	}

    }

    public static void addTool(DrawerDefinition drawer) {
	if (drawer != null) {
	    Object editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(drawer);
	    if (editingDomain instanceof EditingDomain) {
		EditingDomain domain = (EditingDomain) editingDomain;
		Tool tool = DiagramGlobalToolServiceFactory.eINSTANCE.createTool();
		tool.setName("New Tool");

		AddCommand cmd = new AddCommand(domain, drawer, DiagramGlobalToolServicePackage.Literals.DRAWER_DEFINITION__TOOL_REF, tool);
		if ((cmd != null) && cmd.canExecute()) {
		    domain.getCommandStack().execute(cmd);
		}
	    }
	}

    }

    public static void deleteTool(Tool tool) {
	if (tool != null) {
	    Object editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(tool);
	    Collection<Tool> tools = new ArrayList<Tool>();
	    tools.add(tool);
	    if (editingDomain instanceof EditingDomain) {
		EditingDomain domain = (EditingDomain) editingDomain;
	
		DeleteCommand cmd = new DeleteCommand(domain, tools);
		if ((cmd != null) && cmd.canExecute()) {
		    domain.getCommandStack().execute(cmd);
		}
	    }
	}

    }

    public static void addElementType(Tool tool, IElementType ielementType) {
	if (tool != null) {
	    Object editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(tool);
	    if (editingDomain instanceof EditingDomain) {
		EditingDomain domain = (EditingDomain) editingDomain;

		ElementType element = DiagramGlobalToolServiceFactory.eINSTANCE.createElementType();
		element.setElementType(ielementType.getId());

		AddCommand cmd = new AddCommand(domain, tool, DiagramGlobalToolServicePackage.Literals.TOOL__ELEMENT_TYPES, element);
		if ((cmd != null) && cmd.canExecute()) {
		    domain.getCommandStack().execute(cmd);
		}
	    }
	}

    }

    public static void deleteIElementType(IElementType element, Tool tool) {
	if (tool != null &&element!=null) {
	    Object editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(tool);

	    if (editingDomain instanceof EditingDomain) {
		EditingDomain domain = (EditingDomain) editingDomain;
		Collection<ElementType> toDelete = new ArrayList<ElementType>();

		for (ElementType type : tool.getElementTypes()) {

		    if (type.getElementType().equals(element.getId())) {
			toDelete.add(type);
			
		    }
		}
		tool.getElementTypes().removeAll(toDelete);
		/*DeleteCommand cmd = new DeleteCommand(domain, toDelete);
		if ((cmd != null) && cmd.canExecute()) {
		    domain.getCommandStack().execute(cmd);
		}*/

	    }
	}

    }

    public static void addNewToolFromEclass(EClassDefinition eclass, DrawerDefinition drawer) {
	if (drawer != null) {
	    Object editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(drawer);
	    if (editingDomain instanceof EditingDomain) {
		EditingDomain domain = (EditingDomain) editingDomain;
	
		Tool tool = DiagramGlobalToolServiceFactory.eINSTANCE.createTool();
		tool.setName(eclass.getEClass().getName());
		for (ElementRegistry.ElementType element : eclass.getRefElementTypes()){
		    ElementType type = DiagramGlobalToolServiceFactory.eINSTANCE.createElementType();
		    type.setElementType(element.getElementTypeID());
		    tool.getElementTypes().add(type);
		}
		
		AddCommand cmd = new AddCommand(domain, drawer, DiagramGlobalToolServicePackage.Literals.DRAWER_DEFINITION__TOOL_REF, tool);
		if ((cmd != null) && cmd.canExecute()) {
		    domain.getCommandStack().execute(cmd);
		}
		
	    }
	}
	
    }

}
