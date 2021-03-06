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

package org.eclipse.papyrus.dgts.wizard.editor.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.wizard.editor.pages.DgtsGlobalPage;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.uml.diagram.wizards.kind.DiagramKindContentProvider;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;



/**
 * Label provider for Diagram (when the input element is a creationcommandescriptor) 
 * Used for the create diagram wizard
 * @author gdesq
 *
 */
public class DgtsDiagramKindContentProvider extends DiagramKindContentProvider {

    public DgtsDiagramKindContentProvider(ICreationCommandRegistry creationCommandRegistry) {
	super(creationCommandRegistry);
    }

    @Override
    public Object[] getElements(Object inputElement) {
	if (inputElement instanceof Object[]) {
	    List<CreationCommandDescriptor> result = new ArrayList<CreationCommandDescriptor>();
	    for (Object next : (Object[]) inputElement) {
		if (next instanceof String) {
		    String diagramCategory = (String) next;
		    result.addAll(getCreationCommands(diagramCategory));
		}
	    }
	    result = filterCreationCommandRegistry(result);
	    Collections.sort(result, new Comparator<CreationCommandDescriptor>() {

		public int compare(CreationCommandDescriptor o1, CreationCommandDescriptor o2) {
		    return o1.getLabel().compareTo(o2.getLabel());
		}
	    });
	    return result.toArray(new Object[result.size()]);
	}
	if (inputElement instanceof String) {
	    String diagramCategory = (String) inputElement;
	    List<CreationCommandDescriptor> result = getCreationCommands(diagramCategory);
	    result = filterCreationCommandRegistry(result);
	    return result.toArray(new Object[result.size()]);
	}
	return null;
    }

    private List<CreationCommandDescriptor> filterCreationCommandRegistry(List<CreationCommandDescriptor> descriptors) {
	List<CreationCommandDescriptor> result = new ArrayList<CreationCommandDescriptor>();
	List<String> diagramTypesAlreadyHere = getDiagramTypeAlreadyHere();
	if (diagramTypesAlreadyHere != null) {
	    for (CreationCommandDescriptor crea : descriptors) {
		try {
		    if (!diagramTypesAlreadyHere.contains(crea.getCommand().getCreatedDiagramType())) {
			result.add(crea);
		    }

		} catch (BackboneException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    return result;
	}
	return descriptors;
    }

    private List<String> getDiagramTypeAlreadyHere() {
	List<String> listTypes = new ArrayList<String>();
	Resource resource = DgtsGlobalPage.getResource();
	ToolsProvider toolsProvider = new ToolsProvider();
	if (resource != null) {
	    DiagramGlobalToolDefinition globalToolDef = toolsProvider.getDiagramGlobalToolDefinitionFromResource(resource);

	    List<DiagramDefinition> allDiagram = toolsProvider.getAllDiagrams(globalToolDef);
	    if (allDiagram != null) {
		for (DiagramDefinition diag : allDiagram) {
		    listTypes.add(diag.getDiagramType());
		}
		return listTypes;
	    }

	}

	return null;
    }

}
