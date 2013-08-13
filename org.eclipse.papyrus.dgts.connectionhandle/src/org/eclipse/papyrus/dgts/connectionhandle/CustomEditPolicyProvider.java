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
package org.eclipse.papyrus.dgts.connectionhandle;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.dgts.connectionhandle.editpolicies.DgtsConnectionHandleEditPolicy;
import org.eclipse.papyrus.dgts.connectionhandle.editpolicies.DgtsGraphicalNodeEditPolicy;



/**
 * @author gdesq
 * EditPolicy Provider, provide edit policies to activate connections handles.
 */
public class CustomEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {




	public void createEditPolicies(EditPart editPart) {

		//handle connections system
		if(editPart instanceof ShapeNodeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new DgtsConnectionHandleEditPolicy());

		}

		//Creation of link between 2 shapeEditpart

		if(editPart instanceof ShapeEditPart) {
			editPart.installEditPolicy("DgtsGraphicalNode", new DgtsGraphicalNodeEditPolicy());

		}

	}

	public boolean provides(IOperation operation) {
		if(operation instanceof CreateEditPoliciesOperation) {

			return true;
		}
		return false;
	}
}
