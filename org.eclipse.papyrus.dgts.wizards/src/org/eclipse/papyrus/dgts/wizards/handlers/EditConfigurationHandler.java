package org.eclipse.papyrus.dgts.wizards.handlers;

import org.eclipse.core.resources.IFile;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.dgts.wizards.DgtsGlobalWizard;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class EditConfigurationHandler {

    @Execute
    public void execute() {
	


	DgtsGlobalWizard newWizard = new DgtsGlobalWizard();
	WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), newWizard);
	 if (dialog.open() == WizardDialog.OK) {

	    }
	
    }

    @CanExecute
    public boolean canExecute() {
	return true;
    }

}