package org.eclipse.papyrus.dgts.palette;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.AbstractTool;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.providers.DefaultPaletteProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.internal.palette.PaletteDrawer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.dgts.service.ToolDefinitionResourceProvider;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.ui.IEditorPart;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.ElementType;
import DiagramGlobalToolService.Tool;

public class ToolDefinitionCustomPaletteProvider extends DefaultPaletteProvider {
	protected static List<DrawerDefinition> ListDrawers = null;

	public static List<DrawerDefinition> getListDrawers() {
		return ListDrawers;
	}

	protected Map predefinedEntries;
	protected static IEditorPart editor = null;
	protected static PaletteRoot root = null;
	protected ToolsProvider toolProvider = new ToolsProvider();

	public static IEditorPart getEditor() {
		return editor;
	}

	public static PaletteRoot getRoot() {
		return root;
	}

	public static Object getContent() {
		return content;
	}

	public static Object content;
	private String diagramID;
	private String PATH;
	protected static Map ToolDefinitionMap = new HashMap<String, AbstractToolDefinitionPaletteEntry>();

	public ToolDefinitionCustomPaletteProvider() {
		// TODO Auto-generated constructor stub

	}

	public void contributeToPalette(IEditorPart editorCurrent, Object content,
			PaletteRoot root, Map predefinedEntries) {
		if (ToolDefinitionResourceProvider.isAvailable()) {
			if (editorCurrent instanceof IDiagramWorkbenchPart) {
				Diagram diagram = ((IDiagramWorkbenchPart) editorCurrent)
						.getDiagram();
				InitiElements(diagram.getType(),
						ToolDefinitionResourceProvider
								.getDiagramGlobalToolDefinition());
				if (ListDrawers == null||ListDrawers.isEmpty() ) {
					
					super.contributeToPalette(editor, content, root,
							predefinedEntries);
				} else {
					
					this.editor = editorCurrent;
					this.root = root;
					this.content = content;
					this.predefinedEntries = predefinedEntries;
					contributeCustomPalette(predefinedEntries);
				}

			}

		} else {
			super.contributeToPalette(editor, content, root, predefinedEntries);
		}
	}

	/*
	 * Init global variable
	 */
	protected void InitiElements(String diagram,
			DiagramGlobalToolDefinition global) {
		if(ListDrawers != null){
			ListDrawers.clear();
		}
		DiagramDefinition diagramDefinition = toolProvider.getDiagram(diagram,
				global);
		if(toolProvider.activatePalette(diagram, global)){
			ListDrawers = toolProvider.getDrawers(diagramDefinition);

		}
	}

	protected void contributeCustomPalette(Map predefinedEntries) {
		ToolDefinitionMap.clear();
		hideDefaultPalette();
		createDrawers(predefinedEntries);

	}

	protected void createDrawers(Map predefinedEntries) {
		PaletteDrawer drawer;
		PaletteToolEntry entry;
		for (DrawerDefinition drawerDefinition : ListDrawers) {
			drawer = new PaletteDrawer("drawer " + drawerDefinition.getName(),
					drawerDefinition.getName());
			drawer.setInitialState(PaletteDrawer.INITIAL_STATE_OPEN);
			createElement(drawerDefinition, drawer, predefinedEntries);
			root.add(drawer);
		}

	}

	protected void createElement(DrawerDefinition drawerDefinition,
			PaletteDrawer drawer, Map predefinedEntries) {
		ToolEntry entry;

		for (Tool elementTool : drawerDefinition.getToolRef()) {
			createPaletteEntry(drawer, elementTool);
		}

	}

	protected void createPaletteEntry(PaletteDrawer drawer, Tool elementTool) {
		List<IElementType> elementTypeList;
		createEntryFromTool(drawer, elementTool);

	}

	protected void createEntryFromTool(PaletteDrawer drawer, Tool elementTool) {
		List<IElementType> elementTypeList;
		DiagramGlobalToolService.Tool tool = (DiagramGlobalToolService.Tool) elementTool;
		List<ElementType> listElement = this.toolProvider.getElementTypes(tool);
		elementTypeList = this.toolProvider.getIElementTypesFromTool(tool);
		if (elementTool.isIsEdge()) {
			createEdgeToolPaletteEntry(drawer,
					(DiagramGlobalToolService.Tool) elementTool,
					elementTypeList);

		} else {
			createNodeToolPaletteEntry(drawer,
					(DiagramGlobalToolService.Tool) elementTool,
					elementTypeList);
		}
	}

	protected void createEdgeToolPaletteEntry(PaletteDrawer drawer,
			Tool elementTool, List<IElementType> elementType) {
		ToolDefinitionEdgePaletteEntry toolDefinitionEntry;
		if (!ToolDefinitionMap.containsKey(elementTool.getName())) {
			createNewEdgeToolPaletteEntry(drawer, elementTool, elementType);
		}

		else {
			setEdgeToolPaletteEntry(elementTool, elementType);

		}
	}

	protected void createNewEdgeToolPaletteEntry(PaletteDrawer drawer,
			Tool elementTool, List<IElementType> elementType) {
		ToolDefinitionEdgePaletteEntry toolDefinitionEntry;
		toolDefinitionEntry = new ToolDefinitionEdgePaletteEntry(
				(DiagramGlobalToolService.Tool) elementTool, elementType);
		ToolDefinitionMap.put(elementTool.getName(), toolDefinitionEntry);
		setMissingImageIcon(toolDefinitionEntry, elementType);
		drawer.add(toolDefinitionEntry);
	}

	protected void setEdgeToolPaletteEntry(Tool elementTool,
			List<IElementType> elementType) {
		ToolDefinitionEdgePaletteEntry toolDefinitionEntry;
		toolDefinitionEntry = (ToolDefinitionEdgePaletteEntry) ToolDefinitionMap
				.get(elementTool.getName());
		toolDefinitionEntry.addTypes(elementType);
	}

	protected void createNodeToolPaletteEntry(PaletteDrawer drawer,
			Tool elementTool, List<IElementType> elementType) {
		ToolDefinitionNodePaletteEntry toolDefinitionNodePaletteEntry;
		if (!ToolDefinitionMap.containsKey(elementTool.getName())) {
			createNewNodeToolPaletteEntry(drawer, elementTool, elementType);
		}

		else {
			setNodeToolPaletteEntry(elementTool, elementType);

		}

	}

	protected void createNewNodeToolPaletteEntry(PaletteDrawer drawer,
			Tool elementTool, List<IElementType> elementType) {
		ToolDefinitionNodePaletteEntry toolDefinitionNodePaletteEntry;
		toolDefinitionNodePaletteEntry = new ToolDefinitionNodePaletteEntry(
				(DiagramGlobalToolService.Tool) elementTool, elementType);
		ToolDefinitionMap.put(elementTool.getName(),
				toolDefinitionNodePaletteEntry);
		setMissingImageIcon(toolDefinitionNodePaletteEntry, elementType);
		drawer.add(toolDefinitionNodePaletteEntry);
	}

	protected void setNodeToolPaletteEntry(Tool elementTool,
			List<IElementType> elementType) {
		ToolDefinitionNodePaletteEntry toolDefinitionEntry = (ToolDefinitionNodePaletteEntry) ToolDefinitionMap
				.get(elementTool.getName());
		toolDefinitionEntry.addTypes(elementType);

	}

	protected void setMissingImageIcon(
			AbstractToolDefinitionPaletteEntry toolDefinitionEntry,
			List<IElementType> elementTypeList) {
		ImageDescriptor missing = ImageDescriptor.getMissingImageDescriptor();
		if (toolDefinitionEntry.getSmallIcon().equals(missing)) {
			for (IElementType iElement : elementTypeList) {
				ToolEntry entry = searchToolElementByIElementType(iElement);
				if (entry != null) {
					toolDefinitionEntry.setSmallIcon(entry.getSmallIcon());
				}
			}
		}
	}

	protected ToolEntry searchToolElementByIElementType(IElementType elementType) {
		Set<?> cles = predefinedEntries.keySet();
		Object cle;
		Object value;
		Iterator<?> it = cles.iterator();
		while (it.hasNext()) {
			cle = it.next();
			value = predefinedEntries.get(cle);
			if (value instanceof ToolEntry) {
				if (isCorrespondingIElement((ToolEntry) value, elementType)) {
					return (ToolEntry) value;

				}

			}

		}

		return null;

	}

	protected boolean isCorrespondingIElement(ToolEntry entry,
			IElementType elementType) {
		org.eclipse.gef.Tool tool = entry.createTool();

		if (tool instanceof AspectUnspecifiedTypeCreationTool) {
			for (IElementType element : ((AspectUnspecifiedTypeCreationTool) tool)
					.getElementTypes()) {
				if (element.equals(elementType)) {
					return true;
				}

			}
		} else if (tool instanceof AspectUnspecifiedTypeConnectionTool) {
			for (IElementType element : ((AspectUnspecifiedTypeConnectionTool) tool)
					.getElementTypes()) {
				if (element.equals(elementType)) {
					return true;
				}

			}
		}

		return false;

	}

	public static void hideDefaultPalette() {
		for (Object child : root.getChildren()) {

			if (child instanceof org.eclipse.gef.palette.PaletteDrawer) {
				org.eclipse.gef.palette.PaletteDrawer drawer = (org.eclipse.gef.palette.PaletteDrawer) child;
				drawer.setVisible(false);
			}

		}
	}

}
