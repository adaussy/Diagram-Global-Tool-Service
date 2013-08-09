
package org.eclipse.papyrus.dgts.wizards.utility;

import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import ElementRegistry.ElementType;

/**
 * A label provider that provides the name and image for
 * <code>IElementType</code> objects.
 * 
 * @author cmahoney
 */
public class IElementTypeLabelProvider extends LabelProvider {


    public Image getImage(Object object) {
	if (object instanceof IElementType) {
	    return IconService.getInstance().getIcon((IElementType) object);
	}
	return null;
    }


    public String getText(Object object) {
	if (object instanceof IElementType) {
	    String label = ((IElementType) object).getId();
	    if (label == null || label.length() == 0) {
		return "";
	    } else {
		String extension = "";

		int i = label.lastIndexOf('.');
		if (i > 0) {
		    extension = label.substring(i + 1);
		}
		return extension;
	    }

	}
	return "";
    }
}
