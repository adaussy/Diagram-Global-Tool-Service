package org.eclipse.papyrus.dgts.wizards.utility;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import DiagramGlobalToolService.presentation.DiagramGlobalToolServiceEditor;

public class SelectionHelper {

    public static Resource getResourceFromActiveEditor(){
	
	IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	IEditorPart editorPart = activePage.getActiveEditor();
	
	if (editorPart instanceof DiagramGlobalToolServiceEditor){
	    DiagramGlobalToolServiceEditor editor = (DiagramGlobalToolServiceEditor) editorPart;
	    return editor.getEditingDomain().getResourceSet().getResources().get(0);   
	}
	return null;
	
    }
    
}
