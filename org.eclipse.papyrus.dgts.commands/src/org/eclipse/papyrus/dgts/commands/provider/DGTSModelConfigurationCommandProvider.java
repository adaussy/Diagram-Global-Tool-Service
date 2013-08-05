package org.eclipse.papyrus.dgts.commands.provider;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.papyrus.dgts.service.DgtsResourceLoader;
import org.eclipse.papyrus.dgts.service.ServiceStaticEventNotifier;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationOperation;
import org.eclipse.papyrus.dgts.service.model.configuration.IDGTSModelConfigurationProvider;

public class DGTSModelConfigurationCommandProvider implements
		IDGTSModelConfigurationProvider {
	public DGTSModelConfigurationCommandProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof DGTSModelConfigurationOperation) {
			return true;
		}
		return false;
	}

	@Override
	public void removeProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object provideModelConfiguration(Object content,
			ResourceSet resourceSet) {
		// TODO Auto-generated method stub
		Resource resource = null;

		if (content instanceof IFile) {
			try {
				resource = DgtsResourceLoader.loadResource((IFile) content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (resource != null) {
			return DgtsResourceLoader
					.getDiagramGlobalToolDefinitionFromResource(resource);
		}
		
		return null;

	}

}
