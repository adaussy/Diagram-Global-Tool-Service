/*******************************************************************************
 * Copyright  2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
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

public class CustomEditPolicyProvider extends AbstractProvider implements
		IEditPolicyProvider {

	

	
	public void createEditPolicies(EditPart editPart) {
	    	//editPart.removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	    	//editPart.removeEditPolicy(org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE);
	    	
	    	//handle connections system
		if (editPart instanceof ShapeNodeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
					new DgtsConnectionHandleEditPolicy());
			
		}
		//creation of link and element with the handle system
		
		/*if (editPart instanceof DiagramEditPart || editPart instanceof ShapeCompartmentEditPart) {
			editPart.installEditPolicy("DgtsGraphicalContainer",
					new DgtsContainerNodeEditPolicy());
		}*/
		
		//Creation of link between 2 shapeEditpart
		
		if (editPart instanceof ShapeEditPart ){
		    editPart.installEditPolicy("DgtsGraphicalNode",
				new DgtsGraphicalNodeEditPolicy());
		    
		}
		
		
		
	}

	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			/*CreateEditPoliciesOperation cepOper = (CreateEditPoliciesOperation) operation;
			if (cepOper.getEditPart() instanceof  ShapeNodeEditPart ||
				cepOper.getEditPart() instanceof ShapeEditPart||
				cepOper.getEditPart() instanceof DiagramEditPart||
				cepOper.getEditPart() instanceof CompartmentEditPart
				)*/
				return true;
		}
		return false;
	}
}
