package org.eclipse.papyrus.dgts.wizards.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.dgts.wizards.DgtsGlobalWizard;
import org.eclipse.ui.PlatformUI;

public class EditConfigurationHandler {

    @Execute
    public void execute() {
	
	DgtsGlobalWizard newWizard = new DgtsGlobalWizard();
	WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), newWizard);
	 if (dialog.open() == WizardDialog.OK) {
	      System.out.println("Ok pressed");
	    }
	
    }

    @CanExecute
    public boolean canExecute() {
	return true;
    }

}