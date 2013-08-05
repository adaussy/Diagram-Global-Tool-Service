package org.eclipse.papyrus.dgts.wizards.utility;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class SelectionHelper {

    public static Resource getResourceFromSelection(){
	Resource resource = null;
	IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	
	
	//get the current selection
	ISelection selection = activePage.getSelection();

	if (selection instanceof IStructuredSelection) {
	    IStructuredSelection strucSelection = (IStructuredSelection) selection;
	    Object first = strucSelection.getFirstElement();

	    // We get the resource
	    if (first instanceof Resource) {//if selection is the resource
		resource = (Resource) first;
	    } else if (first instanceof EObject) {//if selection is an Eobject in the resource
		resource = ((EObject) first).eResource();
	    }
	}
	return resource;
    }
    
}
