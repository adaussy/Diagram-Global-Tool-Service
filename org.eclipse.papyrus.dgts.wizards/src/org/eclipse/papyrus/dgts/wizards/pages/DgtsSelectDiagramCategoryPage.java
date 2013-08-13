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

package org.eclipse.papyrus.dgts.wizards.pages;

import org.eclipse.papyrus.uml.diagram.wizards.Messages;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;

public class DgtsSelectDiagramCategoryPage extends SelectDiagramCategoryPage {

    @Override
    protected boolean validatePage() {
	setMessage(null);
	setErrorMessage(null);
	String[] categories = getDiagramCategories();
	if(categories == null || categories.length == 0) {
		setErrorMessage(Messages.SelectDiagramCategoryPage_select_one_category);
		return false;
	}
	for(String newCategory : categories) {
		if(!validateCategoryExists(newCategory)) {
			return false;
		}
	}
	return true;
}

    
}
