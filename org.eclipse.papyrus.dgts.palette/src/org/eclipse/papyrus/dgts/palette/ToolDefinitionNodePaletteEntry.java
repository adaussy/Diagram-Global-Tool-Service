package org.eclipse.papyrus.dgts.palette;

import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.TargetingTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;

public class ToolDefinitionNodePaletteEntry extends
		AbstractToolDefinitionPaletteEntry {

	public ToolDefinitionNodePaletteEntry(ToolEntry entry,
			DiagramGlobalToolService.ToolMetaModel toolMetaTool) {
		super(entry, toolMetaTool);
		AspectUnspecifiedTypeCreationTool tool = (AspectUnspecifiedTypeCreationTool) entry
				.createTool();
		addTypes(tool.getElementTypes());
	}

	public ToolDefinitionNodePaletteEntry(
			DiagramGlobalToolService.Tool elementTool,
			List<IElementType> elementType) {
		super(elementTool, elementType);
	}

	public void addTypes(AspectUnspecifiedTypeCreationTool tool) {
		types.addAll(tool.getElementTypes());
	}

	@Override
	public Tool createTool() {
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

}
