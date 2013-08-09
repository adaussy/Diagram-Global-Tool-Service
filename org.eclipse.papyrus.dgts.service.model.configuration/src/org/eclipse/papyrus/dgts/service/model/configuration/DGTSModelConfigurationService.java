/*******************************************************************************
 * Copyright  2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Vincent Lartigaut (Atos) vincent.lartigaut@atos.net - Vincent Lartigaut - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.dgts.service.model.configuration;

import java.util.List;

import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.Service;

import DiagramGlobalToolService.DrawerDefinition;

public class DGTSModelConfigurationService extends Service implements
		IModelConfigurationService {

	public DGTSModelConfigurationService() {
		super();
		this.configureProviders(Activator.PLUGIN_ID, "modelConfiguration");
	}

	private static class SingleHolder {
		private static DGTSModelConfigurationService INSTANCE;

		public static DGTSModelConfigurationService getFillRequestService() {
			if (INSTANCE == null) {
				INSTANCE = new DGTSModelConfigurationService();
			}
			return INSTANCE;
		}
	}

	public static DGTSModelConfigurationService getInstance() {
		return SingleHolder.getFillRequestService();
	}

	@Override
	public List<DrawerDefinition> getModelConfiguration(IOperation operation) {
		if (operation instanceof DGTSModelConfigurationOperation) {
			List list = super.execute(ExecutionStrategy.FORWARD, operation);
			for(Object drawerList : list){
				if(drawerList!=null){
					if(!((List<DrawerDefinition>) drawerList).isEmpty()){
						return (List<DrawerDefinition>) drawerList ;
					}
				}
			
				
			}
		}
		return null;
	}
}
