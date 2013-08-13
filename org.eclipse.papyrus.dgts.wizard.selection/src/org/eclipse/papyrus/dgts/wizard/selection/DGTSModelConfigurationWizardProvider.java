/*******************************************************************************
 * Copyright  2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Vincent Lartigaut (Atos) vincent.lartigaut@atos.net - Vincent Lartigaut - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.dgts.wizard.selection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.dgts.service.DgtsResourceLoader;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationOperation;
import org.eclipse.papyrus.dgts.service.model.configuration.IDGTSModelConfigurationProvider;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;


/** Provide a list of drawer definition from a model configuration which his url is present in diagram view EAnnotation
 * @author vlartiga
 *
 */
public class DGTSModelConfigurationWizardProvider implements
		IDGTSModelConfigurationProvider {
	protected ToolsProvider toolProvider = new ToolsProvider();

	public DGTSModelConfigurationWizardProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof DGTSModelConfigurationOperation){
			return true ;
		}
		return false;
	}

	@Override
	public void removeProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DrawerDefinition> provideModelConfiguration(
			Collection<EObject> content) {
		List<DrawerDefinition> listDrawer = new ArrayList<>() ;
		for (EObject object : content) {
			if (object instanceof Diagram) {
				Diagram diagram = (Diagram) object ;
					List<String> listPath = getPathFromAnnotation(((Diagram) object).getEAnnotations()) ;
					for(String path : listPath){
						DiagramGlobalToolDefinition global = DgtsResourceLoader.getDiagramToolDefinitionFromPath(path) ;
						DiagramDefinition diagramDefinition = toolProvider
								.getDiagram(diagram.getType(), global);
						listDrawer.addAll(toolProvider.getDrawers(diagramDefinition)) ;
					}
			}

		}
		return listDrawer;
	}

	protected List<String> getPathFromAnnotation(EList<EAnnotation> eAnnotations) {
		List<String> listPath = new ArrayList<>() ;
		for(EAnnotation eAnnot : eAnnotations ){
			String path = eAnnot.getSource() ;
					listPath.add(path);
		}
		return listPath;
	}

	protected List<DiagramDefinition> getDiagramFromEAnnotation(EList<EAnnotation> eAnnotations) {
		for(EAnnotation eAnnot : eAnnotations ){
			EList<EObject> contents = eAnnot.getContents();
			for(Object obj : contents ){
				if(obj instanceof String){
					getAllDrawerFromString((String) obj);
				}
			}
		}
		return null;
		
	}

	protected List<DiagramDefinition>getAllDrawerFromString(String path) {
		DiagramGlobalToolDefinition global = DgtsResourceLoader.getDiagramToolDefinitionFromPath(path) ;
		return  toolProvider.getAllDiagrams(global) ;

		
	}

}
