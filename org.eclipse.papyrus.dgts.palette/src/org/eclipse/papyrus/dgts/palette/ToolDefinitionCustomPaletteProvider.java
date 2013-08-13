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

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.providers.DefaultPaletteProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.internal.palette.PaletteDrawer;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationOperation;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationService;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.ui.IEditorPart;

import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.Tool;

/** Provide a palette in function of a DGTS model configuration. 
 * It is a provider of the extension point org.eclipse.gmf.runtime.diagram.ui.paletteProviders
 * @author vlartiga
 *
 */
@SuppressWarnings("restriction")

public class ToolDefinitionCustomPaletteProvider extends DefaultPaletteProvider {
    protected static List<DrawerDefinition> ListDrawers = null;

    public static List<DrawerDefinition> getListDrawers() {
	return ListDrawers;
    }
    Map<String, String> editorIDtoClassName = new HashMap<>();

    @SuppressWarnings("rawtypes")
	protected Map predefinedEntries;
    protected IEditorPart editor = null;
    protected PaletteRoot root = null;
    protected ToolsProvider toolProvider = new ToolsProvider();

    public Object content;
    protected static HashMap<String, AbstractToolDefinitionPaletteEntry> ToolDefinitionMap = new HashMap<String, AbstractToolDefinitionPaletteEntry>();

    @SuppressWarnings("rawtypes")
	public void contributeToPalette(IEditorPart editorCurrent, Object content, PaletteRoot root, Map predefinedEntries) {

	if (editorCurrent instanceof IDiagramWorkbenchPart) {
	    DGTSModelConfigurationOperation operation = new DGTSModelConfigurationOperation(Collections.singleton(((IDiagramWorkbenchPart) editorCurrent).getDiagram()));
	    ListDrawers = DGTSModelConfigurationService.getInstance().getModelConfiguration(operation);

	    if (!(ListDrawers == null || ListDrawers.isEmpty())) {
		this.editor = editorCurrent;
		this.root = root;
		this.content = content;
		this.predefinedEntries = predefinedEntries;
		contributeCustomPalette(predefinedEntries);
	    }

	}
	else {
	    super.contributeToPalette(editorCurrent, content, root, predefinedEntries);
	}
	
    }


    protected void addDrawerIcon(PaletteDrawer drawer, DrawerDefinition drawerDefinition) {
	if (drawerDefinition.getIconReference() != null) {
	    ImageDescriptor img = ImageDescriptor.createFromFile(null, drawerDefinition.getIconReference().getIconPath());
	    drawer.setSmallIcon(img);
	}

    }

    @SuppressWarnings("rawtypes")
	protected void createElement(DrawerDefinition drawerDefinition, PaletteDrawer drawer, Map predefinedEntries) {
	for (Tool elementTool : drawerDefinition.getToolRef()) {
	    if (elementTool.isSetPalette()) {
		createPaletteEntry(drawer, elementTool);

	    }
	}

    }

    protected void createPaletteEntry(PaletteDrawer drawer, Tool elementTool) {
	if (!elementTool.getElementTypes().isEmpty()) {
	    createEntryFromTool(drawer, elementTool);
	}

    }

    protected void createEntryFromTool(PaletteDrawer drawer, Tool elementTool) {
	List<IElementType> elementTypeList;
	DiagramGlobalToolService.Tool tool = (DiagramGlobalToolService.Tool) elementTool;
	elementTypeList = this.toolProvider.getIElementTypesFromTool(tool);
	if (elementTool.isIsEdge()) {
	    createEdgeToolPaletteEntry(drawer, (DiagramGlobalToolService.Tool) elementTool, elementTypeList);

	} else {
	    createNodeToolPaletteEntry(drawer, (DiagramGlobalToolService.Tool) elementTool, elementTypeList);
	}
    }

    protected void createEdgeToolPaletteEntry(PaletteDrawer drawer, Tool elementTool, List<IElementType> elementType) {
	if (!ToolDefinitionMap.containsKey(elementTool.getName())) {
	    createNewEdgeToolPaletteEntry(drawer, elementTool, elementType);
	}

	else {
	    setEdgeToolPaletteEntry(elementTool, elementType);

	}
    }

    protected void createNewEdgeToolPaletteEntry(PaletteDrawer drawer, Tool elementTool, List<IElementType> elementType) {
	ToolDefinitionEdgePaletteEntry toolDefinitionEntry;
	toolDefinitionEntry = new ToolDefinitionEdgePaletteEntry((DiagramGlobalToolService.Tool) elementTool, elementType);
	ToolDefinitionMap.put(elementTool.getName(), toolDefinitionEntry);
	setMissingImageIcon(toolDefinitionEntry, elementType);
	drawer.add(toolDefinitionEntry);
    }

    protected void setEdgeToolPaletteEntry(Tool elementTool, List<IElementType> elementType) {
	ToolDefinitionEdgePaletteEntry toolDefinitionEntry;
	toolDefinitionEntry = (ToolDefinitionEdgePaletteEntry) ToolDefinitionMap.get(elementTool.getName());
	toolDefinitionEntry.addTypes(elementType);
    }

    protected void createNodeToolPaletteEntry(PaletteDrawer drawer, Tool elementTool, List<IElementType> elementType) {
	if (!ToolDefinitionMap.containsKey(elementTool.getName())) {
	    createNewNodeToolPaletteEntry(drawer, elementTool, elementType);
	}

	else {
	    setNodeToolPaletteEntry(elementTool, elementType);

	}

    }

    protected void createNewNodeToolPaletteEntry(PaletteDrawer drawer, Tool elementTool, List<IElementType> elementType) {
	ToolDefinitionNodePaletteEntry toolDefinitionNodePaletteEntry;
	toolDefinitionNodePaletteEntry = new ToolDefinitionNodePaletteEntry((DiagramGlobalToolService.Tool) elementTool, elementType);
	ToolDefinitionMap.put(elementTool.getName(), toolDefinitionNodePaletteEntry);
	setMissingImageIcon(toolDefinitionNodePaletteEntry, elementType);
	drawer.add(toolDefinitionNodePaletteEntry);
    }

    protected void setNodeToolPaletteEntry(Tool elementTool, List<IElementType> elementType) {
	ToolDefinitionNodePaletteEntry toolDefinitionEntry = (ToolDefinitionNodePaletteEntry) ToolDefinitionMap.get(elementTool.getName());
	toolDefinitionEntry.addTypes(elementType);

    }

    protected void setMissingImageIcon(AbstractToolDefinitionPaletteEntry toolDefinitionEntry, List<IElementType> elementTypeList) {
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

    protected boolean isCorrespondingIElement(ToolEntry entry, IElementType elementType) {
	org.eclipse.gef.Tool tool = entry.createTool();

	if (tool instanceof AspectUnspecifiedTypeCreationTool) {
	    for (IElementType element : ((AspectUnspecifiedTypeCreationTool) tool).getElementTypes()) {
		if (element.equals(elementType)) {
		    return true;
		}

	    }
	} else if (tool instanceof AspectUnspecifiedTypeConnectionTool) {
	    for (IElementType element : ((AspectUnspecifiedTypeConnectionTool) tool).getElementTypes()) {
		if (element.equals(elementType)) {
		    return true;
		}

	    }
	}

	return false;

    }

    public void hideDefaultPalette() {
	for (Object child : root.getChildren()) {

	    if (child instanceof org.eclipse.gef.palette.PaletteDrawer) {
		org.eclipse.gef.palette.PaletteDrawer drawer = (org.eclipse.gef.palette.PaletteDrawer) child;
		drawer.setVisible(false);
	    }

	}
    }

   

	@SuppressWarnings("rawtypes")
	
	protected void contributeCustomPalette(Map predefinedEntries) {
		ToolDefinitionMap.clear();
		hideDefaultPalette();
		createDrawers(predefinedEntries);

	}

	@SuppressWarnings("rawtypes")
	protected void createDrawers(Map predefinedEntries) {
		PaletteDrawer drawer;
		for (DrawerDefinition drawerDefinition : ListDrawers) {
			drawer = new PaletteDrawer("drawer " + drawerDefinition.getName(),
					drawerDefinition.getName());
			drawer.setInitialState(PaletteDrawer.INITIAL_STATE_OPEN);
			createElement(drawerDefinition, drawer, predefinedEntries);
			addDrawerIcon(drawer, drawerDefinition);
			root.add(drawer);
		}

    }


}
