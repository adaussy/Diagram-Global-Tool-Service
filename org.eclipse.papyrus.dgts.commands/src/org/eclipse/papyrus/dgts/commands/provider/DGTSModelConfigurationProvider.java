package org.eclipse.papyrus.dgts.commands.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationOperation;
import org.eclipse.papyrus.dgts.service.model.configuration.IDGTSModelConfigurationProvider;

import DiagramGlobalToolService.DrawerDefinition;

public class DGTSModelConfigurationProvider implements
		IDGTSModelConfigurationProvider {

	public DGTSModelConfigurationProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof DGTSModelConfigurationOperation){
			DGTSModelConfigurationOperation op = (DGTSModelConfigurationOperation) operation ;
			if(op.getContext() instanceof EModelElement){
				EModelElement model = (EModelElement) op.getContext() ;
				if( ! model.getEAnnotations().equals(Collections.emptyList())){
					return true ;
				}
			}
			return true ;
		}
		return false;
	}

	@Override
	public void removeProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DrawerDefinition> provideModelConfiguration(Collection<EObject> context) {
			for(EObject obj : context){
				EList<EAnnotation> listAnotation = ((EModelElement) obj).getEAnnotations();
			}
			
			return null;
	}



}
