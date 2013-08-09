package org.eclipse.papyrus.dgts.wizard.selection;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.dgts.service.ServiceStaticEventNotifier;
import org.eclipse.papyrus.dgts.wizard.selection.command.DGTSWizardTransactionalAddEAnnotationCommand;

public class DgtsSelectionWizard extends Wizard {

	DgtsCustomPage mainPage;
	DiagramEditPart editPart ;
    @Override
    public void addPages() {

	mainPage = new DgtsCustomPage(editPart);
	addPage(mainPage);

    }
    
    public DgtsSelectionWizard(DiagramEditPart editPart){
    	this.editPart = editPart ;
    }
    @Override
    public boolean performFinish() {
    	final Diagram diagramView = editPart.getDiagramView();
    	String description = "Link configuration model";
    	TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramView);
    	DGTSWizardTransactionalAddEAnnotationCommand cmd = new DGTSWizardTransactionalAddEAnnotationCommand(diagramView,description,mainPage);
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		ServiceStaticEventNotifier.notifyObservers();
    	return true;
    }
    
    public boolean canFinish() {
              return true;
    }
    
}
