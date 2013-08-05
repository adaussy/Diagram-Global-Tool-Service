package org.eclipse.papyrus.dgts.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.dgts.pages.DgtsSelectDiagramCategoryPage;
import org.eclipse.papyrus.dgts.pages.DgtsGlobalPage;

public class DgtsGlobalWizard extends Wizard {

    DgtsGlobalPage mainPage;
    @Override
    public void addPages() {

	mainPage = createGlobalPage();
	addPage(mainPage);

    }
    
    
    @Override
    public boolean performFinish() {
	// TODO Auto-generated method stub
	return false;
    }
    
    
    protected DgtsGlobalPage createGlobalPage() {
	return new DgtsGlobalPage();
    }

}
