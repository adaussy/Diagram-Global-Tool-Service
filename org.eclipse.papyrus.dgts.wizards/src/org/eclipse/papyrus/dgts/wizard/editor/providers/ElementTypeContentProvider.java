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
package org.eclipse.papyrus.dgts.wizard.editor.providers;

import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.dgts.service.DgtsElementTypeRegistry;
import org.eclipse.papyrus.dgts.wizard.editor.utility.EClassDefinitionTypeComparator;

import ElementRegistry.EClassDefinition;




/**
 * Content provider for the Ielementtype bloc
 * @author gdesq
 *
 */
public class ElementTypeContentProvider implements ITreeContentProvider {

    @Override
    public void dispose() {


    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {


    }

    @Override
    public Object[] getElements(Object inputElement) {

	    if (inputElement instanceof ElementRegistry.DiagramDefinition) {
		ElementRegistry.DiagramDefinition diagram = (ElementRegistry.DiagramDefinition) inputElement;
		
		EList<EClassDefinition> result = (EList<EClassDefinition>) DgtsElementTypeRegistry.getInstance().getAllEclassFromDiagram(diagram.getDiagramType());
		
		ECollections.sort(result, new EClassDefinitionTypeComparator());
		return result.toArray(new Object[result.size()]);
	  
	    }
	    
	

	return null;
    }

    @Override
    public Object[] getChildren(Object parentElement) {
	if (parentElement instanceof EClassDefinition){
	    EClassDefinition eclass = (EClassDefinition) parentElement;
	  List<ElementRegistry.ElementType> result =  eclass.getRefElementTypes();
	  return result.toArray(new Object[result.size()]);
	}
	
	
	return null;
    }

    @Override
    public Object getParent(Object element) {
	if (element instanceof ElementRegistry.ElementType){
	    return ((ElementRegistry.ElementType) element).eContainer();
	}

	return null;
    }

    @Override
    public boolean hasChildren(Object element) {
	if (element instanceof EClassDefinition){
	EClassDefinition eclass = (EClassDefinition) element;
	if (eclass.getRefElementTypes() != null){
	    return true;
	}}
	return false;
    }

}
