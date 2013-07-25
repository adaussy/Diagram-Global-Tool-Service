package org.eclipse.papyrus.dgts.connectionhandle.editpolicies;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.FigureListener;
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
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandleLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.dgts.connectionhandle.CustomModelingAssistantService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Display;


public class CopyOfDgtsConnectionHandleEditPolicy extends GraphicalEditPolicy implements MouseMotionListener {

    
    private boolean mousePressed = false;
    private Point mouseLocation;

    protected Point getMouseLocation() {
	return mouseLocation;
    }

    protected void setMouseLocation(Point mouseLocation) {
	this.mouseLocation = mouseLocation;
    }
    

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
		    super.handleMouseExited(event);
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
		    super.handleMouseExited(event);
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

    
   private ConnectionKeyListener myConnectionKeyListener = new ConnectionKeyListener();
   protected boolean keyPressed = false;
   
   protected boolean isKeyPressed(){
       return keyPressed;
   }
    
    private class ConnectionKeyListener implements KeyListener {

   	public void keyPressed(KeyEvent event) {
   	   
   	    // System.out.println("Code touche pressée : " + event.keyCode +
   	    // " - caractère touche pressée : " + event.character);

   	    //if (event.keyCode == codeKey) {
   		if (getMouseLocation() != null) {
   		
   		    keyPressed = true;
   		    showDiagramAssistant(getMouseLocation());
   		}
   	    //}
   	}

   	public void keyReleased(KeyEvent event) {
   	    
   	    // System.out.println("Code touche relâchée : " + event.keyCode +
   	    // " - caractère touche relâchée : " + event.character);
   	    keyPressed = false;
   	    hideDiagramAssistant();
   	    
   	}

       }
    public void activate() {
	super.activate();
	
	 getHost().getViewer().getControl().addKeyListener(this.myConnectionKeyListener);

	((IGraphicalEditPart) getHost()).getFigure().addFigureListener(ownerMovedListener);
    }

    public void deactivate() {
	((IGraphicalEditPart) getHost()).getFigure().removeFigureListener(ownerMovedListener);

	super.deactivate();
    }

    
    
    //show the connections handles
    protected void showDiagramAssistant(Point referencePoint) {
	if (shouldShowDiagramAssistant()){
	
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
	
	//we hide the handles: we cant be hover it anymore
	mouseHover = false;
	
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
	return CopyOfDgtsConnectionHandleEditPolicy.class.getName();
    }

    public void addHandle(CustomConnectionHandle aHandle) {
	handles.add(aHandle);
    }

  

    protected boolean shouldShowDiagramAssistant() {
	return getHost().isActive() &&isKeyPressed() && isPreferenceOn() && isHostEditable() && isHostResolvable() && isNotMouseHover() &&isSelectionToolActive();
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

    
    
    
    
    public void mouseEntered(MouseEvent me) {
	setMouseLocation(me.getLocation());
	

}

/*
 * (non-Javadoc)
 * 
 * @see org.eclipse.draw2d.MouseMotionListener#mouseExited(org.eclipse.draw2d.MouseEvent)
 */
public void mouseExited(MouseEvent me) {
	setMouseLocation(null);
	//hideDiagramAssistant();
}

/*
 * (non-Javadoc)
 * 
 * @see org.eclipse.draw2d.MouseMotionListener#mouseMoved(org.eclipse.draw2d.MouseEvent)
 */
public void mouseMoved(MouseEvent me) {
	setMouseLocation(me.getLocation());

	// do not hide the diagram assistant if the user is hovering over it
	

	showDiagramAssistant(getMouseLocation());
}

/*
 * (non-Javadoc)
 * 
 * @see org.eclipse.draw2d.MouseMotionListener#mouseHover(org.eclipse.draw2d.MouseEvent)
 */
public void mouseHover(MouseEvent me) {
	// do nothing
}

/*
 * (non-Javadoc)
 * 
 * @see org.eclipse.draw2d.MouseMotionListener#mouseDragged(org.eclipse.draw2d.MouseEvent)
 */
public void mouseDragged(MouseEvent me) {
	// do nothing
}
    


protected boolean isPreferenceOn() {
	String prefName = getPreferenceName();
	if (prefName == null) {
		return true;
	}
	IPreferenceStore preferenceStore = (IPreferenceStore) ((IGraphicalEditPart) getHost())
		.getDiagramPreferencesHint().getPreferenceStore();
	return preferenceStore.getBoolean(prefName);
}
/**
 * The preference name indicating if the preference should be on or off.
 * This preference must be a boolean preference stored in the diagram
 * preferences.
 * 
 * @return the preference name if applicable; null otherwise
 */
String getPreferenceName() {
	return null;
}
    
    
}