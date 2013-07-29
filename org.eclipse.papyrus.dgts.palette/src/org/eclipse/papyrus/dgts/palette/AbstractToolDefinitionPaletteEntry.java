/*******************************************************************************
 * Copyright  2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Vincent Lartigaut (Atos) vincent.lartigaut@atos.net - Vincent Lartigaut - initial API and implementation
 ******************************************************************************/

package org.eclipse.papyrus.dgts.palette;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;

import DiagramGlobalToolService.Tool;

public abstract class AbstractToolDefinitionPaletteEntry extends ToolEntry {
	protected List<IElementType> types = new ArrayList<IElementType>();

	public AbstractToolDefinitionPaletteEntry(
			DiagramGlobalToolService.Tool elementTool,
			List<IElementType> elementType) {
		super(elementTool.getName(), "", ImageDescriptor
				.getMissingImageDescriptor(), ImageDescriptor
				.getMissingImageDescriptor());
		setId(elementTool.getName());
		types.addAll(elementType);
		setEntryIcon(elementTool);

	}

	protected void setEntryIcon(Tool elementTool) {
		if (elementTool.getIconReference() != null) {
			ImageDescriptor img = ImageDescriptor.createFromFile(null,
					elementTool.getIconReference().getIconPath());
			setSmallIcon(img);
		} else {
			setImageIcon();
		}

	}

	public void addTypes(List<IElementType> elementType) {
		types.addAll(elementType);
	}

	public void addTypes(IElementType elementType) {
		types.add(elementType);
	}

	public void setImageIcon() {
		ImageDescriptor smallIcon = getSmallIcon();
		if (smallIcon.equals(ImageDescriptor.getMissingImageDescriptor())) {
			for (IElementType element : types) {
				if (element.getIconURL() != null) {
					setSmallIcon(ImageDescriptor.createFromURL(element
							.getIconURL()));
				}

			}

		}

	}

	abstract public org.eclipse.gef.Tool createTool();

}
