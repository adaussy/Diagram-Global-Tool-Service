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

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.common.ui.dialogs.ExpansionType;
import org.eclipse.gmf.runtime.diagram.ui.commands.PopupMenuCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.ElementTypeLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.menus.PopupMenu;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.ShowRelatedElementsRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.dgts.connectionhandle.CustomModelingAssistantService;
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
	    CreateUnspecifiedTypeConnectionRequest request = new CreateUnspecifiedTypeConnectionRequest(CustomModelingAssistantService.getInstance().getRelTypesOnTarget(getConnectionHandle().getOwner()), true, getPreferencesHint());
	    request.setDirectionReversed(true);
	    return request;
	} else {
	    return new CreateUnspecifiedTypeConnectionRequest(CustomModelingAssistantService.getInstance().getRelTypesOnSource(getConnectionHandle().getOwner()), true, getPreferencesHint());
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.tools.AbstractTool#getCommand()
     */
    protected Command getCommand() {
	if (getConnectionHandle().isIncoming()) {
	    CreateUnspecifiedTypeConnectionRequest unspecifiedTypeRequest = (CreateUnspecifiedTypeConnectionRequest) getTargetRequest();
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
