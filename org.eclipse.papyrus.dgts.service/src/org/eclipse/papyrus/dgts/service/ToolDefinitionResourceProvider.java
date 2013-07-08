package org.eclipse.papyrus.dgts.service;

import org.eclipse.emf.ecore.resource.Resource;

import DiagramGlobalToolService.DiagramGlobalToolDefinition;

public class ToolDefinitionResourceProvider {

	protected static Resource resource = null;

	private ToolDefinitionResourceProvider() {

	}

	public static Resource getResource() {
		return resource;
	}

	public static void setResource(Resource resource) {
		ToolDefinitionResourceProvider.resource = resource;
	}

	public static boolean isAvailable() {
		return resource != null;
	}

	public static DiagramGlobalToolDefinition getDiagramGlobalToolDefinition() {
		// TODO Auto-generated method stub
		return DgtsResourceLoader
				.getDiagramGlobalToolDefinitionFromResource(resource);
	}

}
