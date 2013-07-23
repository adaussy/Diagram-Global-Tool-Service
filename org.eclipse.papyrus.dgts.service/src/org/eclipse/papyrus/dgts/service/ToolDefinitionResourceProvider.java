package org.eclipse.papyrus.dgts.service;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.ecore.resource.Resource;

import DiagramGlobalToolService.DiagramGlobalToolDefinition;

public class ToolDefinitionResourceProvider {
	
	

	protected static Resource resource = null;
	protected static ToolDefintionObservable  listener = new ToolDefintionObservable();

	private ToolDefinitionResourceProvider() {

	}

	public static Resource getResource() {
		return resource;
	}

	public static void setResource(Resource resource) {
		ToolDefinitionResourceProvider.resource = resource;
		notifyObserver();
	}

	public static void notifyObserver() {
		if(isAvailable()){
			listener.setChange();
			listener.notifyObservers(resource);
		}

	}

	public static boolean isAvailable() {
		return resource != null;
	}

	public static DiagramGlobalToolDefinition getDiagramGlobalToolDefinition() {
		// TODO Auto-generated method stub
		return DgtsResourceLoader
				.getDiagramGlobalToolDefinitionFromResource(resource);
	}

	public static void addObserver(Observer o) {
		listener.addObserver(o);
	}
	
	protected static class ToolDefintionObservable extends Observable{
		
		public  void setChange(){
			setChanged();
		}
		
	
		
		
	}


}
