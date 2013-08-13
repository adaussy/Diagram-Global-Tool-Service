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

package org.eclipse.papyrus.dgts.menus.handlers;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/** Provide and element type in function of the element id
 * @author vlartiga
 *
 */
public class DGTSElementTypeCreator extends AbstractElementTypeEnumerator{
	public static IElementType getIElementType(String ID){
		return getElementType(ID) ;
	}

}
