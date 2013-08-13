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

import org.eclipse.papyrus.uml.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.XMLMemento;

public class ProcessPalettePreferences extends PapyrusPalettePreferences implements IPapyrusPaletteConstant {
	public static boolean isHiddenPalette(String editorClassName, String paletteID) {
		// retrieve preferences for the given editor
		XMLMemento rootMemento = getExistingCustomizations();
		IMemento editorMemento = getEditorMemento(rootMemento, editorClassName);
		IMemento hiddenPalettesMemento = getEditorHiddenPalettesMemento(editorMemento);
		return getHiddenPalettesList(hiddenPalettesMemento).contains(paletteID);
	}
}
