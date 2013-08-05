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

package org.eclipse.papyrus.dgts.menus.provider;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.dgts.service.provider.FillRequestOperation;
import org.eclipse.papyrus.dgts.service.provider.ICompleteRequestProvider;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreatePartWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateReferenceWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

public class DGTSCompleteRequestProvider implements ICompleteRequestProvider {

	@Override
	public void addProviderChangeListener(IProviderChangeListener listener) {

	}

	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof FillRequestOperation) {
			IEditCommandRequest request = getIEditCommandRequest(operation);
			if (request != null) {
				if (request instanceof CreateElementRequest) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void removeProviderChangeListener(IProviderChangeListener listener) {

	}

	@Override
	public void fillRequest(IEditCommandRequest request, IElementType element) {
		IConfigureCommandFactory createParameter = null ;
		if (request instanceof CreateElementRequest) {
			if (element == SysMLElementTypes.PART_PROPERTY) {
				createParameter = new CreatePartWithTypeConfigureCommandFactory();
			}
			else if(element == SysMLElementTypes.REFERENCE_PROPERTY){
				createParameter = new CreateReferenceWithTypeConfigureCommandFactory() ;
			}
			
			if(createParameter != null){
				request.setParameter(
						IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID,
						new CreatePartWithTypeConfigureCommandFactory());
			}
		}

	}

	@Override
	public IEditCommandRequest getIEditCommandRequest(IOperation operation) {
		if (operation instanceof FillRequestOperation) {
			return ((FillRequestOperation) operation).getIEditCommandRequest();
		}
		return null;
	}

	


}
