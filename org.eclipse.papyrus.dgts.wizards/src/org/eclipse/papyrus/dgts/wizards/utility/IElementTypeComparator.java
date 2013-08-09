package org.eclipse.papyrus.dgts.wizards.utility;

import java.util.Comparator;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

class IElementTypeComparator implements Comparator < IElementType > {

    @Override
    public int compare(IElementType e1, IElementType e2) {
        if(e1.getDisplayName() != null && e2.getDisplayName() != null){
            return e1.getDisplayName().compareTo(e2.getDisplayName());
        }

        return 0;
    }

}