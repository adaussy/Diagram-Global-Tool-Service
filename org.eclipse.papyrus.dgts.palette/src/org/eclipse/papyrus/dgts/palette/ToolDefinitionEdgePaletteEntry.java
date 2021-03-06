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
package org.eclipse.papyrus.dgts.palette;

import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;


/** Define a edge element to add in the palette
 * @author vlartiga
 *
 */
public class ToolDefinitionEdgePaletteEntry extends
		AbstractToolDefinitionPaletteEntry {

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
