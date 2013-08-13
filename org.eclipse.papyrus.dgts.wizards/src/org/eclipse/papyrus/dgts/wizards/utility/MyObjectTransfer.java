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

import org.eclipse.gef.dnd.SimpleObjectTransfer;

public class MyObjectTransfer extends SimpleObjectTransfer {
	private String[] myTypes;
	final int[] myTypeIds;

	public MyObjectTransfer(String[] types) {
	    super();
	    this.myTypes = types;
	    int[] typeIds = new int[types.length];
	    for (int i = 0; i < types.length; i++) {
		typeIds[i] = registerType(types[i]);
	    }
	    this.myTypeIds = typeIds;

	}

	@Override
	protected String[] getTypeNames() {

	    return myTypes;
	}

	@Override
	protected int[] getTypeIds() {
	    return myTypeIds;
	}

}
