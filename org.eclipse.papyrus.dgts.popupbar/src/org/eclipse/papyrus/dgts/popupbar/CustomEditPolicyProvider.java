package org.eclipse.papyrus.dgts.popupbar;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;

public class CustomEditPolicyProvider extends AbstractProvider implements
		IEditPolicyProvider {

	

	
	public void createEditPolicies(EditPart editPart) {
		if (editPart instanceof GraphicalEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE,
					new KeyCustomPopupBarEditPolicy());
		}

	/*	if (editPart instanceof DiagramEditPart) {
			editPart.installEditPolicy("KeyListenerForPopupBar",
					new KeyListenerForPopupBarEditPolicy());
		}*/

	}
	
	
	


	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation cepOper = (CreateEditPoliciesOperation) operation;
			if (cepOper.getEditPart() instanceof GraphicalEditPart)
				return true;
		}
		return false;
	}
}
