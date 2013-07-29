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

package org.eclipse.papyrus.dgts.service.provider;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

public class FillRequestOperation implements IOperation {
	protected IEditCommandRequest request ;
	private IElementType element = null;
	public FillRequestOperation(IEditCommandRequest request, IElementType elementType){
		this.request = request ;
		element = elementType ;
	}

	@Override
	public Object execute(IProvider provider) {
		
		if(provider instanceof ICompleteRequestProvider){
			
			((ICompleteRequestProvider) provider).fillRequest(request, element);
		}
		return null ;
	}
	
	public IEditCommandRequest getIEditCommandRequest(){
		return request ;
	}

}
