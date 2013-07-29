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
package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.dgts.connectionhandle.CustomModelingAssistantService;
import org.eclipse.papyrus.dgts.connectionhandle.editpolicies.CustomConnectionHandle.HandleDirection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Display;

public class DgtsConnectionHandleEditPolicy extends GraphicalEditPolicy implements MouseMotionListener {

    private Point mouseLocation;

    protected Point getMouseLocation() {
	return mouseLocation;
    }

    protected void setMouseLocation(Point mouseLocation) {
	this.mouseLocation = mouseLocation;
    }

    protected boolean keyPressed = false;

    protected boolean isKeyPressed() {
	return keyPressed;
    }

    private ConnectionKeyListener myConnectionKeyListener = new ConnectionKeyListener();

    private class ConnectionKeyListener implements KeyListener {

	public void keyPressed(KeyEvent event) {

	    // CTRL + MAJ
	    if (((event.stateMask & SWT.CTRL) != 0) && (event.keyCode == SWT.SHIFT)) {
		HandleRegistry.getInstance().setShouldShowConnectionHandles();
		if (getMouseLocation() != null) {
		    showHandles(getMouseLocation());
		}
	    }
	}

	public void keyReleased(KeyEvent event) {

	    HandleRegistry.getInstance().setShouldHideConnectionHandles();
	    hideHandles();

	}
    }

    // Add the connections handles figures :
    @SuppressWarnings("unchecked")
    protected List<CustomConnectionHandle> getHandleFigures() {
	List list = new ArrayList(2);

	String tooltip;
	tooltip = buildTooltip(HandleDirection.INCOMING);
	if (tooltip != null) {
	    list.add(new CustomConnectionHandle((IGraphicalEditPart) getHost(), HandleDirection.INCOMING, tooltip) {

	    });
	}
	tooltip = buildTooltip(HandleDirection.OUTGOING);
	if (tooltip != null) {
	    list.add(new CustomConnectionHandle((IGraphicalEditPart) getHost(), HandleDirection.OUTGOING, tooltip) {

	    });
	}

	return list;
    }

    // Build the applicable tooltip
    protected String buildTooltip(HandleDirection direction) {
	CustomModelingAssistantService service = CustomModelingAssistantService.getInstance();

	boolean supportsCreation = (direction == HandleDirection.OUTGOING) ? !service.getRelTypesOnSource(getHost()).isEmpty() : !service.getRelTypesOnTarget(getHost()).isEmpty();

	if (supportsCreation) {
	    return DiagramUIMessages.ConnectionHandle_ToolTip_CreateRelationshipOnly;
	}
	return null;
    }

    public void activate() {
	super.activate();

	getHost().getViewer().getControl().addKeyListener(this.myConnectionKeyListener);

    }

    public void deactivate() {
	getHost().getViewer().getControl().removeKeyListener(this.myConnectionKeyListener);

	super.deactivate();
    }

    // show the connections handles
    protected void showHandles(Point referencePoint) {
	 hideHandles();
	if (shouldShowHandles()) {

	    // to avoid double connections handles :
	   

	    HandleRegistry.getInstance().setHandles(getHandleFigures());

	    if (!HandleRegistry.getInstance().isHandles()) {
		return;
	    }

	    DgtsConnectionHandleLocator locator = getConnectionHandleLocator(referencePoint);
	    IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);

	    for (Iterator iter = HandleRegistry.getInstance().getHandles().iterator(); iter.hasNext();) {
		CustomConnectionHandle handle = (CustomConnectionHandle) iter.next();

		handle.setLocator(locator);
		locator.addHandle(handle);

		Cursor cursor = new Cursor(Display.getCurrent(), SWT.CURSOR_HAND);
		handle.setCursor(cursor);

		layer.add(handle);

		// Register this figure with it's host editpart so mouse events
		// will be propagated to it's host.
		getHost().getViewer().getVisualPartMap().put(handle, getHost());
	    }

	}

    }

    // Removes the connection handles.
    protected void hideHandles() {
	if (!HandleRegistry.getInstance().isHandles()) {
	    return;
	}
	IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
	for (Iterator iter = HandleRegistry.getInstance().getHandles().iterator(); iter.hasNext();) {
	    IFigure handle = (IFigure) iter.next();
	    layer.remove(handle);
	    getHost().getViewer().getVisualPartMap().remove(handle);
	}
	HandleRegistry.getInstance().removeHandles();

    }

    // Test if we show the handles or not
    protected boolean shouldShowHandles() {
	return getHost().isActive() && isHostEditable() && isHostResolvable() && isSelectionToolActive() && HandleRegistry.getInstance().shouldShowConnectionHandles();
    }

    // Check if host is editable
    private boolean isHostEditable() {
	if (getHost() instanceof GraphicalEditPart) {
	    return ((GraphicalEditPart) getHost()).isEditModeEnabled();
	}
	return true;
    }

    // Check if host is resolvable
    private boolean isHostResolvable() {
	final View view = (View) getHost().getModel();
	EObject element = view.getElement();
	if (element != null) {
	    return !element.eIsProxy();
	}
	return true;
    }

    // Check if the selection tool is active
    private boolean isSelectionToolActive() {
	// getViewer calls getParent so check for null
	if (getHost().getParent() != null) {
	    Tool theTool = getHost().getViewer().getEditDomain().getActiveTool();
	    if ((theTool != null) && theTool instanceof SelectionTool) {
		return true;
	    }
	}
	return false;
    }

    public void mouseEntered(MouseEvent me) {
	setMouseLocation(me.getLocation());

    }

    public void mouseExited(MouseEvent me) {
	setMouseLocation(null);

    }

    public void mouseMoved(MouseEvent me) {
	setMouseLocation(me.getLocation());
	showHandles(getMouseLocation());
    }

    public void mouseHover(MouseEvent me) {
	// do nothing
    }

    public void mouseDragged(MouseEvent me) {
	// do nothing
    }

    protected DgtsConnectionHandleLocator getConnectionHandleLocator(Point referencePoint) {
	return new DgtsConnectionHandleLocator(getHostFigure(), referencePoint);
    }

}