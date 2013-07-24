package org.eclipse.papyrus.dgts.service;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.ecore.resource.Resource;

import DiagramGlobalToolService.DiagramGlobalToolDefinition;

public class ToolDefinitionResourceProvider {
	
	

	protected static Resource resource = null;
	protected static Observer observer ;

	private ToolDefinitionResourceProvider() {

	}

	public static Resource getResource() {
		return resource;
	}

	public static void setResource(Resource resource) {
		ToolDefinitionResourceProvider.resource = resource;
		ToolDefintionObservable.setChange();
		ToolDefintionObservable.notifyObserver(observer);
		
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
				observer = o ;
	}
	
	protected static class ToolDefintionObservable extends Observable{
		
		public static void setChange(){
			setChange();
		}
		
		public static void notifyObserver(Observer o ){
			notifyObserver(o);
		}
		
	
		
		
	}


}
