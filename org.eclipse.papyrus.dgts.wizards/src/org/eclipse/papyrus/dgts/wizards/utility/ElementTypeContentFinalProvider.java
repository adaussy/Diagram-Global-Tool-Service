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
