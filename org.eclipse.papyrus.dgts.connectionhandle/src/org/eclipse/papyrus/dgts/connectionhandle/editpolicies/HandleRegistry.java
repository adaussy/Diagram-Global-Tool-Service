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
package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;

import java.util.List;



/**
 * @author gdesq
 *         A registry to store the actives connections handles.
 */
public final class HandleRegistry {


	private static volatile HandleRegistry instance = null;


	private List<CustomConnectionHandle> handles = null;


	private boolean showConnectionHandle = false;

	public void setShouldShowConnectionHandles() {
		showConnectionHandle = true;
	}

	public void setShouldHideConnectionHandles() {
		showConnectionHandle = false;
	}

	public boolean shouldShowConnectionHandles() {
		return showConnectionHandle;
	}


	public void setHandles(List<CustomConnectionHandle> listHandles) {
		handles = listHandles;
	}

	public void addHandle(CustomConnectionHandle aHandle) {
		handles.add(aHandle);
	}

	public void removeHandles() {
		handles = null;
	}

	public boolean isHandles() {
		return handles != null;
	}

	public List<CustomConnectionHandle> getHandles() {
		return handles;
	}

	private HandleRegistry() {
		super();
	}

	static public HandleRegistry getInstance() {
		if(instance == null) {

			synchronized(HandleRegistry.class) {
				if(HandleRegistry.instance == null) {
					HandleRegistry.instance = new HandleRegistry();
				}
			}
		}
		return instance;

	}
}
