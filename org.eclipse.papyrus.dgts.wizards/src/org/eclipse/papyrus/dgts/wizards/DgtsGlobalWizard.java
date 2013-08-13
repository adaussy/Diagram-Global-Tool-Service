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
package org.eclipse.papyrus.dgts.wizards;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.internal.resources.SaveContext;
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
	saveModelConfiguration();
    	return true;
    }


	private void saveModelConfiguration() {
	    Map<Object, Object> options = new HashMap<Object, Object>();
	    try {
		DgtsGlobalPage.getResource().save(options);
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
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
