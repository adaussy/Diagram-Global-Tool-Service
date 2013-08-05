package org.eclipse.papyrus.dgts.service.providers;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationOperation;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationService;

import DiagramGlobalToolService.DiagramGlobalToolDefinition;

public class DGTSFileServiceProvider {
	protected static Object content = null ;
	
	public static  DiagramGlobalToolDefinition getDiagramGlobalToolDefinition(){
		DGTSModelConfigurationOperation op = new DGTSModelConfigurationOperation(
				content, new ResourceSetImpl());
		Object object = DGTSModelConfigurationService.getInstance().getModelConfiguration(op);
		if(object instanceof DiagramGlobalToolDefinition){
			return (DiagramGlobalToolDefinition) object ;
		}
		return null ;
	}
	
		
	public static void setContent(Object obj){
		content = obj ;
	}
	
	

}
