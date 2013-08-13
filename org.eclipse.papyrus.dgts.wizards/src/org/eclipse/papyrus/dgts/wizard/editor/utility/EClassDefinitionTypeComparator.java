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

package org.eclipse.papyrus.dgts.wizard.editor.utility;

import java.util.Comparator;

import ElementRegistry.EClassDefinition;



/**
 * Comparator of eclass => alphabetical order (name)
 * 
 * @author gdesq
 * 
 */
public class EClassDefinitionTypeComparator implements Comparator<EClassDefinition> {

	@Override
	public int compare(EClassDefinition e1, EClassDefinition e2) {
		if(e1.getEClass() != null && e2.getEClass() != null) {
			if(e1.getEClass().getName() != null && e2.getEClass().getName() != null) {
				return e1.getEClass().getName().compareTo(e2.getEClass().getName());
			}
		}
		return 0;
	}
}
