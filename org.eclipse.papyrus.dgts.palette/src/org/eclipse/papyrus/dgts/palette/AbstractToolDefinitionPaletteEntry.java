package org.eclipse.papyrus.dgts.palette;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.TargetingTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;

import DiagramGlobalToolService.AbstractTool;
import DiagramGlobalToolService.Tool;

public abstract class AbstractToolDefinitionPaletteEntry extends ToolEntry {
	protected List<IElementType> types = new ArrayList<IElementType>();




	public AbstractToolDefinitionPaletteEntry(ToolEntry entry, DiagramGlobalToolService.ToolMetaModel  toolMetaTool) {
		super(toolMetaTool.getName(), entry.getDescription(), entry.getSmallIcon(),
				entry.getLargeIcon());
		setId(entry.getId());
	}

	public AbstractToolDefinitionPaletteEntry(
			DiagramGlobalToolService.Tool elementTool,
			List<IElementType> elementType) {
		super(elementTool.getName(), "", ImageDescriptor.getMissingImageDescriptor(), ImageDescriptor.getMissingImageDescriptor());
		setId(elementTool.getName());
		types.addAll(elementType);
		setImageIcon();
		
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
			for(IElementType element : types){
				if(element.getIconURL() != null){
					setSmallIcon(ImageDescriptor
							.createFromURL(element.getIconURL()));
				}
				
			}
			
		}

	}

	abstract public org.eclipse.gef.Tool createTool();

}
