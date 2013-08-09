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