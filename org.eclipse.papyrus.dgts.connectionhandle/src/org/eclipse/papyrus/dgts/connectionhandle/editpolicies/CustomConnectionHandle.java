package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;


import org.eclipse.gef.DragTracker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle;
import org.eclipse.gmf.runtime.diagram.ui.internal.tools.ConnectionHandleTool;

public class CustomConnectionHandle extends ConnectionHandle{
	


public CustomConnectionHandle(IGraphicalEditPart ownerEditPart,
			HandleDirection relationshipDirection, String tooltip) {
		super(ownerEditPart, relationshipDirection, tooltip);
		
	}

protected DragTracker createDragTracker() {
	return new ConnectionHandleTool(this);
}

}
