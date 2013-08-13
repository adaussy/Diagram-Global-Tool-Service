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

import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;

/** Define 
 * @author vlartiga
 * 
 */
public class ToolDefinitionNodePaletteEntry extends
		AbstractToolDefinitionPaletteEntry {
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
