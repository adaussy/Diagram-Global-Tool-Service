package org.eclipse.papyrus.dgts.palette;

import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;

public class ToolDefinitionEdgePaletteEntry extends
		AbstractToolDefinitionPaletteEntry {

	public ToolDefinitionEdgePaletteEntry(ToolEntry entry, DiagramGlobalToolService.ToolMetaModel toolMetaTool) {
		super(entry,toolMetaTool);
		AspectUnspecifiedTypeConnectionTool tool = (AspectUnspecifiedTypeConnectionTool) entry.createTool();
		addTypes(tool.getElementTypes());
	}


	public ToolDefinitionEdgePaletteEntry(DiagramGlobalToolService.Tool elementTool,
			List<IElementType> elementTypeList) {
		super(elementTool,elementTypeList);
	}



	public void addTypes(AspectUnspecifiedTypeConnectionTool tool) {
		types.addAll( tool.getElementTypes());
	}

	@Override
	public Tool createTool() {
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}



	

}
