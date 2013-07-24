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
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Handle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.ISurfaceEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.l10n.DiagramUIPluginImages;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.PopupBarTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class KeyCustomPopupBarEditPolicy extends GraphicalEditPolicy {

    private boolean mousePressed = false;
    private Point mouseLocation;

    protected Point getMouseLocation() {
	return mouseLocation;
    }

    protected void setMouseLocation(Point mouseLocation) {
	this.mouseLocation = mouseLocation;
    }

    /* ************************** nested classes *********************** */
    /**
     * 
     * Class to hold pertinent information about the tool placed on the popup
     * bar
     * 
     * @author affrantz@us.ibm.com
     */
    private class PopupBarDescriptor {

	/** The action button tooltip */
	private String _tooltip = new String();

	/** The image for the button */
	private Image _icon = null;

	/** The typeinfo used to create the Request for the command */
	@SuppressWarnings("unused")
	private IElementType _elementType;

	/** The DracgTracker / Tool associatd with the popup bar button */
	private DragTracker _dragTracker = null;

	private boolean _isDrawerBar;

	/**
	 * constructor
	 * 
	 * @param s
	 * @param i
	 * @param elementType
	 * @param theTracker
	 */
	public PopupBarDescriptor(boolean isDrawerBar, String s, Image i, IElementType elementType, DragTracker theTracker) {
	    _tooltip = s;
	    _icon = i;
	    _dragTracker = theTracker;
	    _elementType = elementType;
	    _isDrawerBar = isDrawerBar;

	}

	/**
	 * gets the icon associated with this Descriptor
	 * 
	 * @return Image
	 */
	public final Image getIcon() {
	    return _icon;
	}

	/**
	 * gets the drag tracker associated with this Descriptor
	 * 
	 * @return drag tracker
	 */
	public final DragTracker getDragTracker() {
	    return _dragTracker;
	}

	/**
	 * gets the tool tip associated with this Descriptor
	 * 
	 * @return string
	 */
	public final String getToolTip() {
	    return _tooltip;
	}

	public final boolean isDrawerBar() {
	    return _isDrawerBar;
	}

    } // end PopupBarDescriptor

    /**
     * Default tool placed on the popup bar
     * 
     * @author affrantz@us.ibm.com
     */
    private class PopupBarLabelHandle extends Label implements Handle {
	/**
	 * flag to drawFocus rect around the handle when the mouse rolls over it
	 */
	private boolean myMouseOver = false;

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
	    myMouseOver = true;
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
	    if (mousePressed == true) {
		hideDiagramAssistant();
		mousePressed = false;
	    }

	    super.handleMouseExited(event);
	    myMouseOver = false;
	    repaint();

	}

	public void handleMousePressed(MouseEvent event) {

	    super.handleMousePressed(event);
	    mousePressed = true;
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

    private static Image IMAGE_POPUPBAR_PLUS = DiagramUIPluginImages.get(DiagramUIPluginImages.IMG_POPUPBAR_PLUS);

    private static Image IMAGE_POPUPBAR = DiagramUIPluginImages.get(DiagramUIPluginImages.IMG_POPUPBAR);

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

	    graphics.drawImage(theTail, theBounds.x + 6, theBounds.y + theBounds.height - 1);

	}

	private Image getTail() {
	    if (!bIsInit) {
		if (getIsDisplayAtMouseHoverLocation()) {
		    if (myTailImage == null) {
			myTailImage = IMAGE_POPUPBAR_PLUS;
			bIsInit = true;
		    }
		} else {
		    if (myTailImage == null) {
			myTailImage = IMAGE_POPUPBAR;
			bIsInit = true;
		    }
		}

	    }
	    return myTailImage;

	}

    }

 
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    protected boolean isDiagramAssistant(Object object) {
	return object instanceof RoundedRectangleWithTail || object instanceof PopupBarLabelHandle;
    }

    /**
     * Adds the popup bar after a delay
     */

    /**
     * Listens for mouse key presses so the popup bar can be dismissed if the
     * context menu is displayed
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
	}

	public void mouseReleased(MouseEvent me) {
	    super.mouseReleased(me);

	}
    }


    private class PopupBarMouseMotionListener extends MouseMotionListener.Stub {

	public void mouseEntered(MouseEvent me) {
	    setMouseLocation(me.getLocation());
	}

	public void mouseExited(MouseEvent me) {
	    setMouseLocation(null);

	}

	public void mouseHover(MouseEvent me) {

	    setMouseLocation(me.getLocation());

	}

	public void mouseMoved(MouseEvent me) {

	    setMouseLocation(me.getLocation());

	}

	public void mouseDragged(MouseEvent me) {
	    // do nothing

	}

    }
    
    
    


    private class PopupBarKeyListener implements KeyListener {

	public void keyPressed(KeyEvent event) {
	    // System.out.println("Code touche pressée : " + event.keyCode +
	    // " - caractère touche pressée : " + event.character);
	    showDiagramAssistant(getMouseLocation());
	}

	public void keyReleased(KeyEvent event) {
	    // System.out.println("Code touche relâchée : " + event.keyCode +
	    // " - caractère touche relâchée : " + event.character);
	    hideDiagramAssistant();
	}

    }

    /* ************************* End nested classes ******************** */

    /** Y postion offset from shape where the balloon top begin. */
    static private int BALLOON_Y_OFFSET = 10;

    /** Y postion offset from shape where the balloon top begin. */
    static private double BALLOON_X_OFFSET_RHS = 0.65;

    static private double BALLOON_X_OFFSET_LHS = 0.25;

    /** Y postion offset from shape where the balloon top begin. */
    static private int ACTION_WIDTH_HGT = 30;

    static private int DRAWERBAR_WIDTH = 5;

    static private int ACTION_BUTTON_START_X = 5;

    static private int ACTION_BUTTON_START_Y = 5;

    static private int ACTION_MARGIN_RIGHT = 10;

    /** popup bar bits */
    static private int POPUPBAR_ACTIVATEONHOVER = 0x01; /*
							 * Display the action
							 * when hovering
							 */

    static private int POPUPBAR_DISPLAYATMOUSEHOVERLOCATION = 0x04; /*
								     * Display
								     * the popup
								     * bar at
								     * the mouse
								     * location
								     * used by
								     * diagrams
								     * and
								     * machine
								     * edit
								     * parts
								     */
    static private int POPUPBAR_ONDIAGRAMACTIVATED = 0x10; /*
							    * For popup bars on
							    * diagram and
							    * machine edit
							    * parts, where we
							    * POPUPBAR_DISPLAYATMOUSEHOVERLOCATION
							    * , don't display
							    * popup bar until
							    * user clicks on
							    * surface
							    */
    static private int POPUPBAR_HOST_IS_CONNECTION = 0x20; /*
							    * For popup bars on
							    * connection edit
							    * parts
							    */

    /** Bit field for the actrionbar associated bits */
    private int myPopupBarFlags = POPUPBAR_ACTIVATEONHOVER;

    private double myBallonOffsetPercent = BALLOON_X_OFFSET_RHS;

    /** the figure used to surround the action buttons */
    private IFigure myBalloon = null;

    /** The popup bar descriptors for the popup bar buttons */
    private List myPopupBarDescriptors = new ArrayList();

    /** Images created that must be deleted when popup bar is removed */
    protected List imagesToBeDisposed = null;

    /** mouse keys listener for the owner shape */
    private PopupBarMouseListener myMouseListener = new PopupBarMouseListener();

    private MouseMotionListener myMouseMotionListener = new PopupBarMouseMotionListener();
    
    private PopupBarKeyListener myPopupBarKeyListener = new PopupBarKeyListener();
    
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





    /**
     * Populates the popup bar with popup bar descriptors added by suclassing
     * this editpolicy (i.e. <code>fillPopupBarDescriptors</code> and by
     * querying the modeling assistant service for all types supported on the
     * popup bar of this host. For those types added by the modeling assistant
     * service the icons are retrieved using the Icon Service.
     */
    protected void populatePopupBars() {

	// ////ICI on apelle direct la fonction du
	// custommodelingassistantprovider

	List types = CustomModelingAssistantService.getInstance().getTypesForPopupBar(getHost());

	for (Iterator iter = types.iterator(); iter.hasNext();) {
	    Object type = iter.next();
	    if (type instanceof IElementType) {
		addPopupBarDescriptor((IElementType) type, IconService.getInstance().getIcon((IElementType) type));
	    } else if (type instanceof String) {
		if (((String) type).equals("drawerFlag")) {
		    addPopupBarDescriptor(true, null, null, null, null);
		}
	    }
	}

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

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy
     * #shouldShowDiagramAssistant()
     */

    /**
     * allows plugins to add their own popup bar tools and tips
     * 
     * @param elementType
     * @param theImage
     * @param theTracker
     * @param theTip
     */
    protected void addPopupBarDescriptor(boolean isDrawerBar, IElementType elementType, Image theImage, DragTracker theTracker, String theTip) {

	PopupBarDescriptor desc = new PopupBarDescriptor(isDrawerBar, theTip, theImage, elementType, theTracker);
	myPopupBarDescriptors.add(desc);

    }

    /**
     * adds popup bar descriptor
     * 
     * @param elementType
     * @param theImage
     * @param theTracker
     */
    protected void addPopupBarDescriptor(IElementType elementType, Image theImage, DragTracker theTracker) {

	String theInputStr = DiagramUIMessages.PopupBar_AddNew;

	String theTip = NLS.bind(theInputStr, elementType.getDisplayName());

	addPopupBarDescriptor(false, elementType, theImage, theTracker, theTip);
    }

    /**
     * default method for plugins which passes along the PopupBarTool as the
     * tool to be used.
     * 
     * @param elementType
     * @param theImage
     */
    protected void addPopupBarDescriptor(IElementType elementType, Image theImage) {

	this.addPopupBarDescriptor(elementType, theImage, new PopupBarTool(getHost(), elementType));

    }

    /**
     * @param elementType
     * @param theImage
     * @param theTip
     */
    protected void addPopupBarDescriptor(boolean isDrawerBar, IElementType elementType, Image theImage, String theTip) {

	PopupBarTool theTracker = new PopupBarTool(getHost(), elementType);
	PopupBarDescriptor desc = new PopupBarDescriptor(isDrawerBar, theTip, theImage, elementType, theTracker);

	myPopupBarDescriptors.add(desc);

    }

    /**
     * method used primarily to add UnspecifiedTypeCreationTool
     * 
     * @param elementType
     * @param theImage
     * @param theRequest
     *            the create request to be used
     */
    protected void addPopupBarDescriptor(IElementType elementType, Image theImage, CreateRequest theRequest) {

	PopupBarTool theTracker = new PopupBarTool(getHost(), theRequest);

	this.addPopupBarDescriptor(elementType, theImage, theTracker);

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

		b.addMouseListener(this.myMouseListener);

	    }
	}
	getBalloon().setSize(totalSize, ACTION_WIDTH_HGT + 2 * ACTION_BUTTON_START_Y);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy
     * #getPreferenceName()
     */

    String getPreferenceName() {
	return IPreferenceConstants.PREF_SHOW_POPUP_BARS;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy
     * #isDiagramAssistantShowing()
     */
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
	getBalloon().addMouseMotionListener(this.myMouseMotionListener);
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
	getBalloon().removeMouseMotionListener(this.myMouseMotionListener);
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

	((IGraphicalEditPart) getHost()).getFigure().addMouseMotionListener(this.myMouseMotionListener);
	getHostFigure().addMouseListener(this.myMouseListener);

	// on rajoute un keylistener sur le viewer une seule fois par diagrame
	// (donc si on est sur la diagram edit part)
	//if (getHost() instanceof DiagramEditPart) {
	    getHost().getViewer().getControl().addKeyListener(this.myPopupBarKeyListener);
	//}

	if (getHost() instanceof ISurfaceEditPart) {
	    setIsDisplayAtMouseHoverLocation(true);
	}
    }

    public void deactivate() {
	getHostFigure().removeMouseListener(this.myMouseListener);
	((IGraphicalEditPart) getHost()).getFigure().removeMouseMotionListener(this.myMouseMotionListener);
    }

    protected String getDiagramAssistantID() {
	return KeyCustomPopupBarEditPolicy.class.getName();
    }

    /* MON CODE */

    protected boolean shouldShowDiagramAssistant() {

	// si on instance de diagramedit part, on met a jour le type du diagrame
	// courant
	if (!(getHost().isActive() && isPreferenceOn() && isHostEditable() && isHostResolvable())) {
	    return false;
	}

	    return isSelectionToolActive();

    }

    // /////////////////////////////////////////////////////////////
    // Meme code que DiagramAssistantEditPolicy
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
    // Meme code que DiagramAssistantEditPolicy
    private boolean isHostResolvable() {
	final View view = (View) getHost().getModel();
	EObject element = view.getElement();
	if (element != null) {
	    return !element.eIsProxy();
	}
	return true;
    }

    protected boolean isPreferenceOn() {
	String prefName = getPreferenceName();
	if (prefName == null) {
	    return true;
	}
	IPreferenceStore preferenceStore = (IPreferenceStore) ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint().getPreferenceStore();
	return preferenceStore.getBoolean(prefName);
    }

    // //////////////////////////////////////////////////////////

  

}
