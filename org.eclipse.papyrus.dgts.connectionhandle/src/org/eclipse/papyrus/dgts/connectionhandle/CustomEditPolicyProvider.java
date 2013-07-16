package org.eclipse.papyrus.dgts.connectionhandle;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ContainerNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.dgts.connectionhandle.editpolicies.CustomConnectionHandleEditPolicy;
import org.eclipse.papyrus.dgts.connectionhandle.editpolicies.CustomContainerNodeEditPolicy;
import org.eclipse.papyrus.dgts.connectionhandle.editpolicies.CustomGraphicalNodeEditPolicy;

public class CustomEditPolicyProvider extends AbstractProvider implements
		IEditPolicyProvider {

	

	
	public void createEditPolicies(EditPart editPart) {
	    
	    	//handle connections system
		if (editPart instanceof ShapeNodeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
					new CustomConnectionHandleEditPolicy());
			
		}
		//creation of link and element with the handle system
		if (editPart instanceof DiagramEditPart || editPart instanceof CompartmentEditPart) {
			editPart.installEditPolicy(org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE,
					new CustomContainerNodeEditPolicy());
		}
		//Creation of link between 2 shapeEditpart
		if (editPart instanceof ShapeEditPart){
		    editPart.installEditPolicy(org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE,
				new CustomGraphicalNodeEditPolicy());
		}
			
	}

	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation cepOper = (CreateEditPoliciesOperation) operation;
			if (cepOper.getEditPart() instanceof  ShapeNodeEditPart ||
				cepOper.getEditPart() instanceof ShapeEditPart||
				cepOper.getEditPart() instanceof DiagramEditPart||
				cepOper.getEditPart() instanceof CompartmentEditPart
				)
				return true;
		}
		return false;
	}
}