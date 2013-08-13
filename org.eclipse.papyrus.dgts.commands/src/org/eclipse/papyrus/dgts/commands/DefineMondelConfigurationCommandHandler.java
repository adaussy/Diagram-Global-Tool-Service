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
package org.eclipse.papyrus.dgts.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.dgts.wizard.selection.DgtsSelectionWizard;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


/** Handler witch load wiard for select current model configuration. The execute function is called when the user click on 
 * "Define model configuration" on a diagram
 * @author vlartiga
 *
 */
public class DefineMondelConfigurationCommandHandler extends AbstractHandler {
    DgtsSelectionWizard wizard;

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
	// TODO Auto-generated method stub

	IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

	Object selection = (activeWorkbenchWindow != null) ? activeWorkbenchWindow.getSelectionService().getSelection() : null;
	if (selection != null) {

	    if (selection instanceof StructuredSelection) {

		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object firstElement = structuredSelection.getFirstElement();
		if (firstElement instanceof DiagramEditPart) {
		    wizard = new DgtsSelectionWizard((DiagramEditPart) firstElement);
		    WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
		    dialog.open();
		}
	    }
	}
	return null;
    }

}
