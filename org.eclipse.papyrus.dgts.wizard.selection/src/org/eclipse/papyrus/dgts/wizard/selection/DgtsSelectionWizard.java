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
