package org.eclipse.papyrus.dgts.wizards.utility;

import java.util.Comparator;

import ElementRegistry.EClassDefinition;

class EClassDefinitionTypeComparator implements Comparator<EClassDefinition> {

    @Override
    public int compare(EClassDefinition e1, EClassDefinition e2) {
	if (e1.getEClass() != null && e2.getEClass() != null) {
	    if (e1.getEClass().getName() != null && e2.getEClass().getName() != null) {
		return e1.getEClass().getName().compareTo(e2.getEClass().getName());
	    }
	}

	return 0;
    }

}