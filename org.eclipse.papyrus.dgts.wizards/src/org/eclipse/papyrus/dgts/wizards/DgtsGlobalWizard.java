package org.eclipse.papyrus.dgts.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.dgts.wizards.pages.DgtsGlobalPage;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class DgtsGlobalWizard extends Wizard {

    DgtsGlobalPage mainPage;
    @Override
    public void addPages() {

	mainPage = createGlobalPage();
	addPage(mainPage);

    }
    
    
    @Override
    public boolean performFinish() {
//    	saveModelConfiguration();	
//    	DGTSFileServiceProvider.setContent(mainPage.getGlobalDiag());
//		ServiceStaticEventNotifier.notifyObservers();
    	return true;
    }


	private void saveModelConfiguration() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    	IEditorPart editor = page.getActiveEditor();
    	page.saveEditor(editor, false );
	}
    
    public boolean canFinish() {
              return true;
    }
    
    
    protected DgtsGlobalPage createGlobalPage() {
	return new DgtsGlobalPage();
    }

}
