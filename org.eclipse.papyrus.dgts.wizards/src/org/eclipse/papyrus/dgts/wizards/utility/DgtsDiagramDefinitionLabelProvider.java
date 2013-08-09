package org.eclipse.papyrus.dgts.wizards.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.commands.CreationCommandRegistry;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.swt.graphics.Image;

import DiagramGlobalToolService.DiagramDefinition;

public class DgtsDiagramDefinitionLabelProvider extends LabelProvider {



    public Image getImage(Object object) {
	if (object instanceof DiagramDefinition) {
	    DiagramDefinition diagram = (DiagramDefinition)object;
	    ICreationCommandRegistry creationCommandRegistry = CreationCommandRegistry.getInstance(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);

	    Collection<CreationCommandDescriptor> descriptors = creationCommandRegistry.getCommandDescriptors();

	    for (CreationCommandDescriptor descriptor : descriptors) {
		try {
		    if (descriptor.getCommand().getCreatedDiagramType().equals(diagram.getDiagramType())) {
			ImageDescriptor image = (descriptor.getIcon());
			// image is an optional attribute
			if (image != null) {
			    return new Image(null, image.getImageData());
			}

		    }
		} catch (BackboneException e) {
		    // Do nothing
		}

	    }

	}
	return null;
    }

    public String getText(Object object) {
	if (object instanceof DiagramDefinition) {
	    return ((DiagramDefinition) object).getDiagramType();
	}
	return null;
    }
}
