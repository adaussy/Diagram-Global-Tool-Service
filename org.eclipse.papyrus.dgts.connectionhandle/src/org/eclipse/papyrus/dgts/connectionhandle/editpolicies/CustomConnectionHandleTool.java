package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;

/******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.papyrus.dgts.connectionhandle.CustomModelingAssistantService;
import org.eclipse.papyrus.dgts.connectionhandle.requests.DgtsCreateUnspecifiedTypeConnectionRequest;
import org.eclipse.swt.widgets.Display;

/**
 * This tool is responsible for reacting to mouse events on the connection
 * handles. It will get a command to create a connection when the user clicks
 * and drags the handle. It will get a command to expand elements, when the user
 * clicks the handle. It also adds support to create relationships from target
 * to source.
 * 
 * @author cmahoney
 */
public class CustomConnectionHandleTool extends ConnectionCreationTool implements DragTracker {

    /** Time in ms to display error icon when there are no related elements. */
    private static final int NO_RELATED_ELEMENTS_DISPLAY_TIME = 2000;

    /** the connection handle containing required information */
    private ConnectionHandle connectionHandle;

    /**
     * Constructor for ConnectionHandleTool.
     * 
     * @param connectionHandle
     *            the connection handle
     */
    public CustomConnectionHandleTool(ConnectionHandle connectionHandle) {
	this.connectionHandle = connectionHandle;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.tools.TargetingTool#createTargetRequest()
     */
    protected Request createTargetRequest() {
	if (getConnectionHandle().isIncoming()) {
	    DgtsCreateUnspecifiedTypeConnectionRequest request = new DgtsCreateUnspecifiedTypeConnectionRequest(CustomModelingAssistantService.getInstance().getRelTypesOnTarget(getConnectionHandle().getOwner()), true, getPreferencesHint());
	    request.setDirectionReversed(true);
	    return request;
	} else {
	    return new DgtsCreateUnspecifiedTypeConnectionRequest(CustomModelingAssistantService.getInstance().getRelTypesOnSource(getConnectionHandle().getOwner()), true, getPreferencesHint());
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.tools.AbstractTool#getCommand()
     */
    protected Command getCommand() {
	if (getConnectionHandle().isIncoming()) {
	    DgtsCreateUnspecifiedTypeConnectionRequest unspecifiedTypeRequest = (DgtsCreateUnspecifiedTypeConnectionRequest) getTargetRequest();
	    unspecifiedTypeRequest.setDirectionReversed(true);
	}

	return super.getCommand();
    }



    /**
     * Temporary shows a red X over the connection handle to indicate that there
     * are no related elements to be expanded.
     */
    protected void signalNoRelatedElements() {
	getConnectionHandle().addErrorIcon();
	Display.getCurrent().timerExec(NO_RELATED_ELEMENTS_DISPLAY_TIME, new Runnable() {

	    public void run() {
		getConnectionHandle().removeErrorIcon();
	    }
	});
    }

    /**
     * Returns the connection handle.
     * 
     * @return the connection handle
     */
    protected ConnectionHandle getConnectionHandle() {
	return connectionHandle;
    }

}
