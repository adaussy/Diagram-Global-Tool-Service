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
package org.eclipse.papyrus.dgts.service.provider;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.Service;

public class FillRequestService extends Service {

	public FillRequestService() {
		super();
		this.configureProviders(Activator.PLUGIN_ID, "fillrequestprovider");
	}

	public final List execute(IOperation operation) {
		if (operation instanceof FillRequestOperation) {
			List list = super.execute(ExecutionStrategy.REVERSE, operation);
			return list;
		}
		return Collections.emptyList();

	}

	private static class SingleHolder {
		private static FillRequestService INSTANCE;

		public static FillRequestService getFillRequestService() {
			if (INSTANCE == null) {
				INSTANCE = new FillRequestService();
			}
			return INSTANCE;
		}
	}

	public static FillRequestService getInstance() {
		return SingleHolder.getFillRequestService();
	}

}
