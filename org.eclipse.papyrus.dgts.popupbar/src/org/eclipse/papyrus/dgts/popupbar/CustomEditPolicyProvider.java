package org.eclipse.papyrus.dgts.popupbar;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;

public class CustomEditPolicyProvider extends AbstractProvider implements
		IEditPolicyProvider {

	public void createEditPolicies(EditPart editPart) {
		if (editPart instanceof DiagramEditPart || editPart instanceof ShapeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE,
					new CustomPopupBarEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
					new CustomConnectionHandleEditPolicy());
		}
	}

	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation cepOper = (CreateEditPoliciesOperation) operation;
			if (cepOper.getEditPart() instanceof DiagramEditPart
					|| cepOper.getEditPart() instanceof ShapeEditPart)
				return true;
		}
		return false;
	}
}
