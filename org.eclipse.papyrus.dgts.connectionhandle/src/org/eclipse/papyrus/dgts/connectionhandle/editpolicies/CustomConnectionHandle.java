package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;

import org.eclipse.gef.DragTracker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle;
import org.eclipse.swt.graphics.Image;

public class CustomConnectionHandle extends ConnectionHandle {

    public CustomConnectionHandle(IGraphicalEditPart ownerEditPart, HandleDirection relationshipDirection, String tooltip) {
	super(ownerEditPart, relationshipDirection, tooltip);

    }

    protected DragTracker createDragTracker() {
	return new CustomConnectionHandleTool(this);
    }
/*
    protected Image getImage(int side) {
	if (isIncoming()) {
	  
	   Image connectionImage = new Image(null, getClass().getResourceAsStream("../icons/connectionL.png"));
	    return connectionImage;

	} else {
	    Image connectionImage = new Image(null, getClass().getResourceAsStream("../icons/connectionR.png"));
	    return connectionImage;

	}
    }*/
}
