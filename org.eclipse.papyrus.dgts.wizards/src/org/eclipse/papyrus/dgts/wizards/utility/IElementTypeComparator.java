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
