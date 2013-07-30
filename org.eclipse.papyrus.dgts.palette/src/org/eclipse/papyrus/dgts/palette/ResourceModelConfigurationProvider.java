package org.eclipse.papyrus.dgts.palette;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.papyrus.dgts.service.model.confguration.DGTSModelConfigurationOperation;
import org.eclipse.papyrus.dgts.service.model.confguration.IDGTSModelConfigurationProvider;

import DiagramGlobalToolService.DiagramGlobalToolDefinition;

public class ResourceModelConfigurationProvider implements
		IDGTSModelConfigurationProvider {

	public ResourceModelConfigurationProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean provides(IOperation operation) {
		// TODO Auto-generated method stub
		if(operation instanceof DGTSModelConfigurationOperation){
			return true ;
		}
		else{
			return false ;
		}
	}

	@Override
	public void removeProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void provideModelConfiguration(Object content, ResourceSet resourceSet,
			String path) {
		URI uri = URI.createFileURI(path);
		 Resource resource = resourceSet.getResource(uri, true) ;
		 Map<Object, Object> options = new HashMap<Object, Object>();
			try {
				resource.load(options);
			} catch (IOException e) {
				Activator.log(e.getMessage(), e);
			}
			for (EObject object : resource.getContents()) {
				if (object instanceof DiagramGlobalToolDefinition) {
					content = object ;
				}
			}
		}

}
