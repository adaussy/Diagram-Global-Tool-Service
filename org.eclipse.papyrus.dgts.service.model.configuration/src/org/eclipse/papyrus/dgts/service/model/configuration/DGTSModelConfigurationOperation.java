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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;

import DiagramGlobalToolService.DrawerDefinition;


/** Operation to get model configuration from the context
 * @author vlartiga
 *
 */
public class DGTSModelConfigurationOperation implements IOperation{
	
	private Collection<EObject> context;

	@SuppressWarnings("unchecked")
	public DGTSModelConfigurationOperation(Collection<? extends EObject> content){
		this.context =  (Collection<EObject>) content ;
		
	}

	@Override
	public List<DrawerDefinition> execute(IProvider provider) {
		if(provider instanceof IDGTSModelConfigurationProvider){
			return ((IDGTSModelConfigurationProvider) provider).provideModelConfiguration(context);
		}
		return null;
	}

	public Collection<EObject> getContext() {
		return context;
	}
	

}
