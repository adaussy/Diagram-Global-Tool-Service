package org.eclipse.papyrus.dgts.wizards.utility;

import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.dgts.service.ToolsProvider;

import DiagramGlobalToolService.Tool;

public class ElementTypeContentFinalProvider implements IStructuredContentProvider{

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

	
if (inputElement instanceof Tool){
    
    Tool tool = (Tool) inputElement;
    ToolsProvider toolsProvider = new ToolsProvider();
    List<IElementType> list = toolsProvider.getIElementTypesFromTool(tool);
    return list.toArray(new Object[list.size()]);
}
	
	
	return null;
    }

}
