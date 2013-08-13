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

import org.eclipse.gmf.runtime.common.core.service.IOperation;

/** Interface implemented by the DGTS Model configuration service
 * @author vlartiga
 *
 */
public interface IModelConfigurationService {
	
	public Object getModelConfiguration(IOperation operation) ;

}
