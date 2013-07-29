/******************************************************************************
 * Copyright (c) 2003, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.papyrus.dgts.popupbar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Handle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.ISurfaceEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

/**
 * Popup bars are esentially a cartoon balloon with buttons that are activated
 * during mouse hover over a shape.
 * 
 * @author affrantz@us.ibm.com, cmahoney
 */
public class DgtsCustomPopupBarEditPolicy extends DiagramAssistantEditPolicy {

    protected int DELAY = 50;


    private class PopupBarLabelHandle extends Label implements Handle {

	private Image myDisabledImage = null;

	/** The dragTracker CreationTool associated with the handle * */
	private DragTracker myDragTracker = null;

	private Image getDisabledImage() {
	    if (myDisabledImage != null)
		return myDisabledImage;

	    Image theImage = this.getIcon();
	    if (theImage == null)
		return null;

	    myDisabledImage = new Image(Display.getCurrent(), theImage, SWT.IMAGE_DISABLE);
	    if (imagesToBeDisposed == null) {
		imagesToBeDisposed = new ArrayList();
	    }
	    imagesToBeDisposed.add(myDisabledImage);
	    return myDisabledImage;

	}

	/**
	 * cnostructor
	 * 
	 * @param tracker
	 * @param theImage
	 */
	public PopupBarLabelHandle(DragTracker tracker, Image theImage) {
	    super(theImage);
	    myDragTracker = tracker;
	    this.setOpaque(true);
	    this.setBackgroundColor(ColorConstants.buttonLightest);
	    calculateEnabled();
	}

	/**
	 * @see org.eclipse.gef.Handle#getAccessibleLocation()
	 */
	public Point getAccessibleLocation() {
	    return null;
	}

	/**
	 * @see org.eclipse.gef.Handle#getDragTracker()
	 */
	public DragTracker getDragTracker() {
	    return myDragTracker;
	}

	/**
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 *      paint a focus rectangle for the label if the mouse is inside the
	 *      label
	 */
	protected void paintBorder(Graphics graphics) {
	    super.paintBorder(graphics);
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#handleMouseEntered(org.eclipse.draw2d.MouseEvent)
	 *      flip myMouseOver bit and repaint
	 */
	public void handleMouseEntered(MouseEvent event) {

	    // change la couleur du fond
	    if (event.getSource() instanceof PopupBarLabelHandle) {
		PopupBarLabelHandle label = (PopupBarLabelHandle) event.getSource();
		Color macolor = new Color(Display.getCurrent(), 255, 220, 170);
		label.setBackgroundColor(macolor);
	    }

	    calculateEnabled();

	    super.handleMouseEntered(event);

	    repaint();
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#handleMouseExited(org.eclipse.draw2d.MouseEvent)
	 *      flip myMouseOver bit and repaint
	 */
	public void handleMouseExited(MouseEvent event) {

	    // remet la couleur du fond d'origine
	    if (event.getSource() instanceof PopupBarLabelHandle) {
		PopupBarLabelHandle label = (PopupBarLabelHandle) event.getSource();
		label.setBackgroundColor(ColorConstants.buttonLightest);
	    }
	    super.handleMouseExited(event);
	    repaint();
	}

	private void calculateEnabled() {
	    if ((myDragTracker != null) && (myDragTracker instanceof AbstractPopupBarTool)) {
		AbstractPopupBarTool abarTool = (AbstractPopupBarTool) myDragTracker;
		setEnabled(abarTool.isCommandEnabled());
	    } else {
		setEnabled(true);
	    }
	}

	/**
	 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics graphics) {
	    if (!isEnabled()) {
		Image theImage = getDisabledImage();
		if (theImage != null) {
		    graphics.translate(bounds.x, bounds.y);
		    graphics.drawImage(theImage, getIconLocation());
		    graphics.translate(-bounds.x, -bounds.y);
		    return;
		}

	    }
	    super.paintFigure(graphics);

	}
    }

    private Image IMAGE_POPUPBAR = new Image(null, getClass().getResourceAsStream("icons/popupbar.gif"));

    /**
     * 
     * This is the figure that represents the ballon portion of the popup bar
     * 
     * @author affrantz@us.ibm.com
     */
    private class RoundedRectangleWithTail extends RoundedRectangle {

	private Image myTailImage = null;

	private boolean bIsInit = false;

	private int myCornerDimension = 6;

	/**
	 * constructor
	 */
	public RoundedRectangleWithTail() {
	    // we do not make the myActionTailFigue opaque because it
	    // doesn't look good when magnification is set.
	    this.setFill(true);
	    this.setBackgroundColor(ColorConstants.buttonLightest);
	    this.setForegroundColor(ColorConstants.lightGray);
	    this.setVisible(true);
	    this.setEnabled(true);
	    this.setOpaque(true);

	}

	/**
	 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	public void paintFigure(Graphics graphics) {
	    int shiftWidth = 3;
	    Image theTail = getTail();
	    Rectangle theBounds = this.getBounds().getCopy();
	    theBounds.height -= theTail.getBounds().height;
	    theBounds.height -= shiftWidth;// shift slight above cursor
	    theBounds.x += shiftWidth; // shift slight to right of cursor
	    theBounds.width -= (shiftWidth + 1); // otherwise rhs is clipped

	    // fill the round rectangle first since it is opaque
	    graphics.fillRoundRectangle(theBounds, myCornerDimension, myCornerDimension);
	    graphics.drawRoundRectangle(theBounds, myCornerDimension, myCornerDimension);

	    graphics.drawImage(theTail, theBounds.x + 6, theBounds.y + theBounds.height);

	}

	private Image getTail() {
	    if (!bIsInit) {
		if (myTailImage == null) {
		    myTailImage = IMAGE_POPUPBAR;
		    bIsInit = true;
		}
	    }
	    return myTailImage;

	}

    }

    protected boolean isDiagramAssistant(Object object) {
	return object instanceof RoundedRectangleWithTail || object instanceof PopupBarLabelHandle;
    }

    public void mouseHover(MouseEvent me) {
	// if the cursor is inside the popup bar
	// then we do not want to deactivate
	if (!isDiagramAssistant(me.getSource()))
	    setAvoidHidingDiagramAssistant(false);

	setMouseLocation(me.getLocation());
	if (getIsDisplayAtMouseHoverLocation())
	    showDiagramAssistantAfterDelay(DELAY);
	else if (shouldShowDiagramAssistant()) {
	    showDiagramAssistant(getMouseLocation());
	}
    }

    public void mouseMoved(MouseEvent me) {

	if (getIsDisplayAtMouseHoverLocation()) {
	    Object srcObj = me.getSource();
	    if ((srcObj != null) && srcObj.equals(getHostFigure())) {
		hideDiagramAssistant();
	    }
	}
	setAvoidHidingDiagramAssistant(true);
	setMouseLocation(me.getLocation());

	if (!getIsDisplayAtMouseHoverLocation()) {
	    // if the cursor is inside the popup bar
	    // or the keyboar triggred activation
	    // then we do not want to deactivate
	    if (!isDiagramAssistant(me.getSource()))
		setAvoidHidingDiagramAssistant(false);

	    showDiagramAssistantAfterDelay(DELAY);
	}
    }

    /**
     * Listens for mouse key presses so the popup bar can be dismissed if the
     * context menu is displayed
     * 
     * @author affrantz@us.ibm.com
     */
    private class PopupBarMouseListener extends MouseListener.Stub {

	/**
	 * @see org.eclipse.draw2d.MouseListener#mousePressed(org.eclipse.draw2d.MouseEvent)
	 */
	public void mousePressed(MouseEvent me) {
	    if (3 == me.button) // context menu, hide the popup bar
	    {
		hideDiagramAssistant();
	    }
	    super.mousePressed(me);
	    setPopupBarOnDiagramActivated(true);
	}

	public void mouseReleased(MouseEvent me) {
	    super.mouseReleased(me);

	}
    }
    
    
    protected boolean keyPressed = false;

    protected boolean isKeyPressed() {
	return keyPressed;
    }

  

    private class PopupBarKeyListener implements KeyListener {

	public void keyPressed(KeyEvent event) {

	    // CTRL + MAJ
	    if (((event.stateMask & SWT.CTRL) != 0) && (event.keyCode == SWT.SHIFT)) {
		keyPressed = true;
		showDiagramAssistantAfterDelay(0);

	    }
	}

	public void keyReleased(KeyEvent event) {

	    keyPressed = false;
	    hideDiagramAssistant();

	}
    }

    /* ************************* End nested classes ******************** */

    /** Y postion offset from shape where the balloon top begin. */
    static private int BALLOON_Y_OFFSET = 10;

    /** Y postion offset from shape where the balloon top begin. */
    static private double BALLOON_X_OFFSET_RHS = 0.65;

    /** Y postion offset from shape where the balloon top begin. */
    static private int ACTION_WIDTH_HGT = 30;

    static private int DRAWERBAR_WIDTH = 5;

    static private int ACTION_BUTTON_START_X = 5;

    static private int ACTION_BUTTON_START_Y = 5;

    static private int ACTION_MARGIN_RIGHT = 10;

    /** popup bar bits */
    static private int POPUPBAR_ACTIVATEONHOVER = 0x01;
    /*
     * Display the action when hovering
     */
 
    static private int POPUPBAR_DISPLAYATMOUSEHOVERLOCATION = 0x04;
    /*
     * Display the popup bar at the mouse location used by diagrams and machine
     * edit parts
     */
    static private int POPUPBAR_ONDIAGRAMACTIVATED = 0x10;
  

    /** Bit field for the actrionbar associated bits */
    private int myPopupBarFlags = POPUPBAR_ACTIVATEONHOVER;

    private double myBallonOffsetPercent = BALLOON_X_OFFSET_RHS;

    /** the figure used to surround the action buttons */
    private IFigure myBalloon = null;

    /** The popup bar descriptors for the popup bar buttons */
    private List myPopupBarDescriptors = new ArrayList();

    /** Images created that must be deleted when popup bar is removed */
    protected List imagesToBeDisposed = null;

    /** mouse and key listeners */
    private PopupBarMouseListener myMouseListener = new PopupBarMouseListener();
    private PopupBarKeyListener myConnectionKeyListener = new PopupBarKeyListener();

    /** flag for whether mouse cursor within shape */

    private void setFlag(int bit, boolean b) {
	if (b)
	    myPopupBarFlags |= bit;
	else if (getFlag(bit))
	    myPopupBarFlags ^= bit;

    }

    private boolean getFlag(int bit) {
	return ((myPopupBarFlags & bit) > 0);
    }

    private void setPopupBarOnDiagramActivated(boolean bVal) {
	setFlag(POPUPBAR_ONDIAGRAMACTIVATED, bVal);
    }

    private boolean getPopupBarOnDiagramActivated() {
	return getFlag(POPUPBAR_ONDIAGRAMACTIVATED);
    }


    protected void populatePopupBars() {

	myPopupBarDescriptors = CustomModelingAssistantService.getInstance().getTypesForPopupBar(getHost());
    
    }


 

    /**
     * gets the popup bar descriptors
     * 
     * @return list
     */
    protected List getPopupBarDescriptors() {
	return myPopupBarDescriptors;
    }

    /**
     * initialize the popup bars from the list of action descriptors.
     */

    private class DrawerBarFigure extends Label {

	public DrawerBarFigure(Image image) {

	    super(image);

	}

    }

    private void initPopupBars() {

	List theList = getPopupBarDescriptors();
	if (theList.isEmpty()) {
	    return;
	}
	myBalloon = createPopupBarFigure();
	int totalSize = ACTION_MARGIN_RIGHT;

	int xLoc = ACTION_BUTTON_START_X;
	int yLoc = ACTION_BUTTON_START_Y;

	for (Iterator iter = theList.iterator(); iter.hasNext();) {
	    PopupBarDescriptor theDesc = (PopupBarDescriptor) iter.next();

	    if (theDesc.isDrawerBar()) {
		totalSize = totalSize + DRAWERBAR_WIDTH;
		Image drawerBarImage = new Image(null, getClass().getResourceAsStream("icons/drawerbar.gif"));

		DrawerBarFigure drawerbar = new DrawerBarFigure(drawerBarImage);
		Rectangle r1 = new Rectangle();
		r1.setLocation(xLoc, yLoc);
		xLoc += DRAWERBAR_WIDTH;
		r1.setSize(DRAWERBAR_WIDTH, ACTION_WIDTH_HGT - ACTION_MARGIN_RIGHT);
		drawerbar.setBounds(r1);
		getBalloon().add(drawerbar);
		drawerbar.setBackgroundColor(ColorConstants.buttonLightest);

	    } else {
		totalSize = totalSize + ACTION_WIDTH_HGT;
		// Button b = new Button(theDesc.myButtonIcon);
		PopupBarLabelHandle b = new PopupBarLabelHandle(theDesc.getDragTracker(), theDesc.getIcon());

		Rectangle r1 = new Rectangle();
		r1.setLocation(xLoc, yLoc);
		xLoc += ACTION_WIDTH_HGT;
		r1.setSize(ACTION_WIDTH_HGT, ACTION_WIDTH_HGT - ACTION_MARGIN_RIGHT);

		Label l = new Label();
		l.setText(theDesc.getToolTip());

		b.setToolTip(l);
		b.setPreferredSize(ACTION_WIDTH_HGT, ACTION_WIDTH_HGT);
		b.setBounds(r1);
		// /MON CODE
		Cursor cursor = new Cursor(Display.getCurrent(), SWT.CURSOR_HAND);
		b.setCursor(cursor);
		getBalloon().add(b);
		// Color macolor = new Color(Display.getCurrent(),180,178,250);
		b.setBackgroundColor(ColorConstants.buttonLightest);
		// /
		b.addMouseMotionListener(this);
		b.addMouseListener(this.myMouseListener);

	    }
	}
	getBalloon().setSize(totalSize, ACTION_WIDTH_HGT + 2 * ACTION_BUTTON_START_Y);
    }

 
  
   
    protected boolean isDiagramAssistantShowing() {
	return getBalloon() != null;
    }

    private IFigure getBalloon() {
	return myBalloon;
    }

    protected IFigure createPopupBarFigure() {
	return new RoundedRectangleWithTail();
    }

    protected void showDiagramAssistant(Point referencePoint) {

	// already have a one
	if (getBalloon() != null && getBalloon().getParent() != null) {
	    return;
	}

	if (this.myPopupBarDescriptors.isEmpty()) {

	    populatePopupBars();
	    initPopupBars();

	    if (myPopupBarDescriptors.isEmpty()) {
		return; // nothing to show
	    }
	}
	getBalloon().addMouseMotionListener(this);
	getBalloon().addMouseListener(myMouseListener);

	// the feedback layer figures do not recieve mouse events so do not use
	// it for popup bars
	IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
	layer.add(getBalloon());

	if (referencePoint == null) {
	    referencePoint = getHostFigure().getBounds().getCenter();
	}

	Point thePoint = getBalloonPosition(referencePoint);

	getBalloon().setLocation(thePoint);

    }

    /**
     * getter for the IsDisplayAtMouseHoverLocation flag
     * 
     * @return true or false
     */
    protected boolean getIsDisplayAtMouseHoverLocation() {
	return getFlag(POPUPBAR_DISPLAYATMOUSEHOVERLOCATION);
    }

    /**
     * setter for the IsDisplayAtMouseHoverLocation
     * 
     * @param bVal
     */
    protected void setIsDisplayAtMouseHoverLocation(boolean bVal) {
	setFlag(POPUPBAR_DISPLAYATMOUSEHOVERLOCATION, bVal);
    }

    /**
     * For editparts that consume the entire viewport, statechart, structure,
     * communication, we want to display the popup bar at the mouse location.
     * 
     * @param referencePoint
     *            The reference point which may be used to determine where the
     *            diagram assistant should be located. This is most likely the
     *            current mouse location.
     * @return Point
     */
    private Point getBalloonPosition(Point referencePoint) {
	Point thePoint = new Point();
	boolean atMouse = getIsDisplayAtMouseHoverLocation();
	if (atMouse) {
	    thePoint.setLocation(referencePoint);
	    getHostFigure().translateToAbsolute(thePoint);
	    getBalloon().translateToRelative(thePoint);

	    // shift the ballon so it is above the cursor.
	    thePoint.y -= ACTION_WIDTH_HGT;
	    adjustToFitInViewport(thePoint);
	} else {
	    Dimension theoffset = new Dimension();
	    Rectangle rcBounds = getHostFigure().getBounds().getCopy();

	    getHostFigure().translateToAbsolute(rcBounds);
	    getBalloon().translateToRelative(rcBounds);

	    theoffset.height = -(BALLOON_Y_OFFSET + ACTION_WIDTH_HGT);
	    theoffset.width = (int) (rcBounds.width * myBallonOffsetPercent);

	    thePoint.x = rcBounds.x + theoffset.width;
	    thePoint.y = rcBounds.y + theoffset.height;
	    adjustToFitInViewport(thePoint);
	}
	return thePoint;
    }

    /**
     * Uses the balloon location passed in and its size to determine if the
     * balloon will appear outside the viewport. If so, the balloon location
     * will be modified accordingly.
     * 
     * @param balloonLocation
     *            the suggested balloon location passed in and potentially
     *            modified when this method completes
     */
    private void adjustToFitInViewport(Point balloonLocation) {
	Control control = getHost().getViewer().getControl();
	if (control instanceof FigureCanvas) {
	    Rectangle viewportRect = ((FigureCanvas) control).getViewport().getClientArea();
	    Rectangle balloonRect = new Rectangle(balloonLocation, getBalloon().getSize());

	    int yDiff = viewportRect.y - balloonRect.y;
	    if (yDiff > 0) {
		// balloon is above the viewport, shift down
		balloonLocation.translate(0, yDiff);
	    }
	    int xDiff = balloonRect.right() - viewportRect.right();
	    if (xDiff > 0) {
		// balloon is to the right of the viewport, shift left
		balloonLocation.translate(-xDiff, 0);
	    }
	}
    }

    private void teardownPopupBar() {
	getBalloon().removeMouseMotionListener(this);
	getBalloon().removeMouseListener(myMouseListener);
	// the feedback layer figures do not recieve mouse events
	IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
	if (myBalloon.getParent() != null) {
	    layer.remove(myBalloon);
	}
	myBalloon = null;

	this.myPopupBarDescriptors.clear();

	if (imagesToBeDisposed != null) {
	    for (Iterator iter = imagesToBeDisposed.iterator(); iter.hasNext();) {
		((Image) iter.next()).dispose();
	    }
	    imagesToBeDisposed.clear();
	}

    }

    protected void hideDiagramAssistant() {
	if (getBalloon() != null) {
	    teardownPopupBar();
	}

    }

    public void activate() {
	super.activate();

	getHostFigure().addMouseListener(this.myMouseListener);
	getHost().getViewer().getControl().addKeyListener(this.myConnectionKeyListener);

	if (getHost() instanceof ISurfaceEditPart) {
	    setIsDisplayAtMouseHoverLocation(true);
	}
    }

    public void deactivate() {
	getHostFigure().removeMouseListener(this.myMouseListener);
	getHost().getViewer().getControl().removeKeyListener(this.myConnectionKeyListener);
	super.deactivate();

    }


    
    
    ///////////////////////////////////////////////////////////////
    @Override
    protected boolean shouldShowDiagramAssistant() {
	

	if (!(getHost().isActive() && isPreferenceOn() && isHostEditable() && isHostResolvable() && isKeyPressed())) {
	    return false;
	}

	if (this.getIsDisplayAtMouseHoverLocation()) {

	    if (getPopupBarOnDiagramActivated())
		return isSelectionToolActive();
	    return false;
	} else
	    return isSelectionToolActive();

    }

    private boolean isHostEditable() {
	if (getHost() instanceof GraphicalEditPart) {
	    return ((GraphicalEditPart) getHost()).isEditModeEnabled();
	}
	return true;
    }

    /**
     * Is the host's semantic reference resolvable (if applicable)?
     * 
     * @return true if the semantic reference is resolvable, true if there is no
     *         semantic reference, and false otherwise
     */
    private boolean isHostResolvable() {
	final View view = (View) getHost().getModel();
	EObject element = view.getElement();
	if (element != null) {
	    return !element.eIsProxy();
	}
	return true;
    }

    private boolean isSelectionToolActive() {
	// getViewer calls getParent so check for null
	if (getHost().getParent() != null && getHost().isActive()) {
	    Tool theTool = getHost().getViewer().getEditDomain().getActiveTool();
	    if ((theTool != null) && theTool instanceof SelectionTool) {
		return true;
	    }
	}
	return false;
    }

    // //////////////////////////////////////////////////////////



}
