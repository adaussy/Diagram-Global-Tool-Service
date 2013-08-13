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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import DiagramGlobalToolService.presentation.DiagramGlobalToolServiceEditor;

public class SelectionHelper {

    public static Resource getResourceFromSelection() {
	IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

	ISelection selection = activeWorkbenchWindow.getSelectionService().getSelection();
	if (selection instanceof IStructuredSelection) {
	    IStructuredSelection structuredSelection = (IStructuredSelection) selection;
	    IFile file = (IFile) structuredSelection.getFirstElement();
	    URI uri = URI.createFileURI(file.getFullPath().toString());
	    ResourceSet resourceSet = new ResourceSetImpl();
	    org.eclipse.emf.ecore.resource.Resource resource = resourceSet.getResource(uri, true);
	    Map<Object, Object> options = new HashMap<Object, Object>();
	    try {
		resource.load(options);
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    return resource;

	}
	return null;
    }

    public static Resource getResourceFromActiveEditor() {

	IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	IEditorPart editorPart = activePage.getActiveEditor();

	if (editorPart instanceof DiagramGlobalToolServiceEditor) {
	    DiagramGlobalToolServiceEditor editor = (DiagramGlobalToolServiceEditor) editorPart;
	    return editor.getEditingDomain().getResourceSet().getResources().get(0);
	}
	return null;

    }

}
