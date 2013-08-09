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
package org.eclipse.papyrus.dgts.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import DiagramGlobalToolService.DiagramGlobalToolDefinition;

public class DgtsResourceLoader {

    public static Resource LoadResource(IFile file) throws IOException {
	URI uri = URI.createFileURI(file.getFullPath().toString());
	ResourceSet resourceSet = new ResourceSetImpl();
	org.eclipse.emf.ecore.resource.Resource resource = resourceSet.getResource(uri, true);
	Map<Object, Object> options = new HashMap<Object, Object>();
	resource.load(options);
	return resource;
    }

    public static DiagramGlobalToolDefinition getDiagramGlobalToolDefinitionFromResource(Resource resource) {
	for (EObject object : resource.getContents()) {
	    if (object instanceof DiagramGlobalToolDefinition) {
		return (DiagramGlobalToolDefinition) object;
	    }
	}
	return null;

    }

}
