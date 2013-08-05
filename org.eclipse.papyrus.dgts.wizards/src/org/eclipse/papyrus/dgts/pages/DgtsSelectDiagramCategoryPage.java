package org.eclipse.papyrus.dgts.pages;

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
