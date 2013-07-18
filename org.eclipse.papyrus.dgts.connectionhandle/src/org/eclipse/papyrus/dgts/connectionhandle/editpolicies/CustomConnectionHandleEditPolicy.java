package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandleLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.dgts.connectionhandle.CustomModelingAssistantService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Display;


public class CustomConnectionHandleEditPolicy extends DiagramAssistantEditPolicy {

    /**
     * Listens to the owner figure being moved so the handles can be removed
     * when this occurs.
     */
    private class OwnerMovedListener implements FigureListener {

	public void figureMoved(IFigure source) {
	    hideDiagramAssistant();
	}
    }

    // listener for owner shape movement 
    private OwnerMovedListener ownerMovedListener = new OwnerMovedListener();

    //list of connection handles currently being displayed 
    private List handles = null;

    // mouseHover on the handle
    private boolean mouseHover = false;
  
    protected boolean isDiagramAssistant(Object object) {
	return object instanceof CustomConnectionHandle;
    }

    //Add the connections handles figures :
    @SuppressWarnings("unchecked")
    protected List getHandleFigures() {
	List list = new ArrayList(2);

	String tooltip;
	tooltip = buildTooltip(HandleDirection.INCOMING);
	if (tooltip != null) {
	    list.add(new CustomConnectionHandle((IGraphicalEditPart) getHost(), HandleDirection.INCOMING, tooltip){
		
		
		// if mouse hover
		@Override
		public void handleMouseEntered(MouseEvent event) {
		   mouseHover = true;
		   super.handleMouseEntered(event);
		}
		
		// if mouse go out
		@Override
		public void handleMouseExited(MouseEvent event) {
		    mouseHover = false;
		    super.handleMouseEntered(event);
		}
	    });
	}

	tooltip = buildTooltip(HandleDirection.OUTGOING);
	if (tooltip != null) {
	    list.add(new CustomConnectionHandle((IGraphicalEditPart) getHost(), HandleDirection.OUTGOING, tooltip){
		
		//if mouse hover
		@Override
		public void handleMouseEntered(MouseEvent event) { 
		   mouseHover = true;
		   super.handleMouseEntered(event);
		}
		
		
		//if mouse go out
		@Override
		public void handleMouseExited(MouseEvent event) {
		    mouseHover = false;
		    super.handleMouseEntered(event);
		}
		
	    });
	}

	return list;
    }

    
    
    /**
     * Builds the applicable tooltip string based on whether the Modeling
     * Assistant Service supports handle gestures on this element. If no
     * gestures are supported, the tooltip returned will be null.
     * 
     * @param direction
     *            the handle direction.
     * @return tooltip the tooltip string; if null, the handle should be not be
     *         displayed
     */
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

	((IGraphicalEditPart) getHost()).getFigure().addFigureListener(ownerMovedListener);
    }

    public void deactivate() {
	((IGraphicalEditPart) getHost()).getFigure().removeFigureListener(ownerMovedListener);

	super.deactivate();
    }

    
    
    //show the connections handles
    protected void showDiagramAssistant(Point referencePoint) {
	
	//to avoid double connections handles :
	hideDiagramAssistant();
	
	if (referencePoint == null) {
	    referencePoint = getHostFigure().getBounds().getRight();
	}

	handles = getHandleFigures();
	if (handles == null) {
	    return;
	}

	ConnectionHandleLocator locator = getConnectionHandleLocator(referencePoint);
	IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
	for (Iterator iter = handles.iterator(); iter.hasNext();) {
	    CustomConnectionHandle handle = (CustomConnectionHandle) iter.next();

	    handle.setLocator(locator);
	    locator.addHandle(handle);

	    Cursor cursor = new Cursor(Display.getCurrent(), SWT.CURSOR_HAND);
	    handle.setCursor(cursor);

	    handle.addMouseMotionListener(this);
	    layer.add(handle);

	    // Register this figure with it's host editpart so mouse events
	    // will be propagated to it's host.
	    getHost().getViewer().getVisualPartMap().put(handle, getHost());
	}

	if (!shouldAvoidHidingDiagramAssistant()) {
	    // dismiss the handles after a delay
	    hideDiagramAssistantAfterDelay(getDisappearanceDelay());
	}
    }


  

  
    // Removes the connection handles.
    protected void hideDiagramAssistant() {
	if (handles == null) {
	    return;
	}
	IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
	for (Iterator iter = handles.iterator(); iter.hasNext();) {
	    IFigure handle = (IFigure) iter.next();
	    handle.removeMouseMotionListener(this);
	    layer.remove(handle);
	    getHost().getViewer().getVisualPartMap().remove(handle);
	}
	handles = null;
	
    }

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

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy
     * #shouldShowDiagramAssistant()
     */

    /**
     * get the connection handle locator using the host and the passed reference
     * point
     * 
     * @param referencePoint
     * @return <code>ConnectionHandleLocator</code>
     */
    protected ConnectionHandleLocator getConnectionHandleLocator(Point referencePoint) {
	return new ConnectionHandleLocator(getHostFigure(), referencePoint);
    }


    protected boolean isDiagramAssistantShowing() {
	return handles != null;
    }

    protected String getDiagramAssistantID() {
	return CustomConnectionHandleEditPolicy.class.getName();
    }

    public void addHandle(CustomConnectionHandle aHandle) {
	handles.add(aHandle);
    }

  
    @Override
    protected boolean shouldShowDiagramAssistant() {
	return getHost().isActive() && isPreferenceOn() && isHostEditable() && isHostResolvable() && isNotMouseHover() &&isSelectionToolActive();
    }

    
    //check if the mouse is NOT hover the handles
    private boolean isNotMouseHover(){
	return !mouseHover;
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

}