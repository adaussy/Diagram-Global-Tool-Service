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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.SharedImages;
import org.eclipse.swt.graphics.Image;

public class CustomConnectionHandle extends AbstractHandle {


    /**
	 * An enumeration of connection directions.
	 * OUTGOING = source to target
	 * INCOMING = target to source
	 */
	public static final class HandleDirection {
		private HandleDirection() {
		    // empty
		}

		/** source to target */
		public static final HandleDirection OUTGOING = new HandleDirection();

		/** target to source */
		public static final HandleDirection INCOMING = new HandleDirection();
	}

	/** the error icon that can be superimposed on the connection handle image */
	private static final ImageFigure ERROR_IMAGE = new ImageFigure(SharedImages
		.get(SharedImages.IMG_ERROR));

	static {
		ERROR_IMAGE.setSize(SharedImages.get(SharedImages.IMG_ERROR)
			.getBounds().width, SharedImages.get(SharedImages.IMG_ERROR)
			.getBounds().height);
	}

	/** direction that the relationship is to be created */
	private HandleDirection handleDirection;

	/**
	 * Creates a new <code>ConnectionHandle</code>.
	 * @param ownerEditPart the editpart for which the handle belongs
	 * @param relationshipDirection direction that the relationship is to be created
	 * @param tooltip the tooltip
	 */
	public CustomConnectionHandle(
		IGraphicalEditPart ownerEditPart,
		HandleDirection relationshipDirection,
		String tooltip) {

		setOwner(ownerEditPart);
		setRelationshipDirection(relationshipDirection);
		setToolTip(new Label(tooltip));

		// A stack layout is used so that the error icon can be overlayed on top.
		setLayoutManager(new StackLayout());
	}
	

	/**
	 * @see org.eclipse.draw2d.IFigure#findFigureAt(int, int, org.eclipse.draw2d.TreeSearch)
	 */
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		// return the ConnectionHandle and not the children figures
		if (containsPoint(x, y)) {
			return this;
		}
		return super.findFigureAt(x, y, search);
	}

	/**
	 * Make public.
	 * @see org.eclipse.gef.handles.AbstractHandle#setLocator(org.eclipse.draw2d.Locator)
	 */
	public void setLocator(Locator locator) {
		super.setLocator(locator);
	}

	/**
	 * Make public.
	 * @see org.eclipse.gef.handles.AbstractHandle#getOwner()
	 */
	public GraphicalEditPart getOwner() {
		return super.getOwner();
	}

	/**
	 * Sets the direction that the relationship is to be created.
	 * @param direction the <code>HandleDirection</code> that the relationship is to be created
	 */
	protected void setRelationshipDirection(HandleDirection direction) {
		handleDirection = direction;
	}

	/**
	 * Is this for incoming relationships?
	 * @return true if this is for incoming relationships, false otherwise
	 */
	public boolean isIncoming() {
		return handleDirection == HandleDirection.INCOMING;
	}

	/**
	 * Superimposes an error icon on this connection handle.
	 */
	public void addErrorIcon() {
		add(ERROR_IMAGE);
	}

	/**
	 * Removes the error icon if it is being displayed.
	 */
	public void removeErrorIcon() {
		if (getChildren().contains(ERROR_IMAGE)) {
			remove(ERROR_IMAGE);
		}
	}

	/**
	 * Updates the images used for the handles, based on the side they will
	 * appear on.  Sets the location of the handles using the locator.
	 * @see org.eclipse.draw2d.IFigure#validate()
	 */
	public void validate() {
		if (isValid())
			return;

		removeAll();
		int side = ((DgtsConnectionHandleLocator) getLocator())
			.getBorderSide();
		Image image = getImage(side);

		ImageFigure imageFigure = new ImageFigure(image);
		imageFigure.setSize(image.getBounds().width, image.getBounds().height);
		add(imageFigure);

		setSize(imageFigure.getSize().getUnioned(ERROR_IMAGE.getSize()));

		super.validate();
	}

    
    
    
    
    
    protected DragTracker createDragTracker() {
	return new CustomConnectionHandleTool(this);
    }

    
   
    protected Image getImage(int side) {
        if (side == PositionConstants.WEST) {
            return isIncoming() ? new Image(null, getClass().getResourceAsStream("../icons/IMG_HANDLE_INCOMING_WEST.png"))
                : new Image(null, getClass().getResourceAsStream("../icons/IMG_HANDLE_OUTGOING_WEST.png"));
        } else if (side == PositionConstants.EAST) {
            return isIncoming() ? new Image(null, getClass().getResourceAsStream("../icons/IMG_HANDLE_INCOMING_EST.png"))
            : new Image(null, getClass().getResourceAsStream("../icons/IMG_HANDLE_OUTGOING_EST.png"));
        } else if (side == PositionConstants.SOUTH) {
            return isIncoming() ? new Image(null, getClass().getResourceAsStream("../icons/IMG_HANDLE_INCOMING_SOUTH.png"))
            : new Image(null, getClass().getResourceAsStream("../icons/IMG_HANDLE_OUTGOING_SOUTH.png"));
        } else {
            return isIncoming() ? new Image(null, getClass().getResourceAsStream("../icons/IMG_HANDLE_INCOMING_NORTH.png"))
            : new Image(null, getClass().getResourceAsStream("../icons/IMG_HANDLE_OUTGOING_NORTH.png"));
        }
    }
    
}
