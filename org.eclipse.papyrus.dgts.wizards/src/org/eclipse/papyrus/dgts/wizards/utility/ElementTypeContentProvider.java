package org.eclipse.papyrus.dgts.wizards.utility;

import java.util.Collections;
import java.util.List;

import javax.tools.ToolProvider;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.dgts.service.DgtsElementTypeRegistry;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.wizards.pages.DgtsGlobalPage;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.ElementType;
import DiagramGlobalToolService.Tool;
import ElementRegistry.EClassDefinition;

public class ElementTypeContentProvider implements ITreeContentProvider {

    @Override
    public void dispose() {
	// TODO Auto-generated method stub

    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	// TODO Auto-generated method stub

    }

    @Override
    public Object[] getElements(Object inputElement) {

	    if (inputElement instanceof Tool) {
		ToolsProvider toolsProvider = new ToolsProvider();
		Tool tool = (Tool) inputElement;
		DiagramDefinition diagram = DgtsGlobalPage.getCurrentDiagram();
		List<EClassDefinition> result = DgtsElementTypeRegistry.getInstance().getAllEclassFromDiagram(diagram.getDiagramType());
		//List<EClassDefinition> filter = toolsProvider.getIElementTypesFromTool(tool);
		//result.removeAll(filter);
		//Collections.sort(result, new EClassDefinitionTypeComparator());
		return result.toArray(new Object[result.size()]);
	  
	    }
	    
	

	return null;
    }

    @Override
    public Object[] getChildren(Object parentElement) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Object getParent(Object element) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean hasChildren(Object element) {
	// TODO Auto-generated method stub
	return false;
    }

}
