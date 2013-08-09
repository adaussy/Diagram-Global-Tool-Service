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
