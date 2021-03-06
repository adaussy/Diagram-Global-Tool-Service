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
package org.eclipse.papyrus.dgts.wizard.editor.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.dgts.wizard.editor.DgtsGlobalWizard;
import org.eclipse.ui.PlatformUI;




/**
 * @author gdesq
 * This handler launch the dgts wizard editor
 */
public class EditConfigurationHandler {

	@Execute
	public void execute() {

		DgtsGlobalWizard newWizard = new DgtsGlobalWizard();
		WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), newWizard);
		if(dialog.open() == WizardDialog.OK) {

		}

	}

	@CanExecute
	public boolean canExecute() {
		return true;
	}

}
