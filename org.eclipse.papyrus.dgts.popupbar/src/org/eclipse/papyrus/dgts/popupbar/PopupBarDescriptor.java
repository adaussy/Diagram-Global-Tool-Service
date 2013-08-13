/*******************************************************************************
 * Copyright  2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * Vincent Lartigaut (Atos) vincent.lartigaut@atos.net - Vincent Lartigaut - initial API and implementation
 * Guilhem Desq (Atos) guilhem.desq@atos.net -  Guilhem Desq - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.dgts.popupbar;

import org.eclipse.gef.DragTracker;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.graphics.Image;

public class PopupBarDescriptor {

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
