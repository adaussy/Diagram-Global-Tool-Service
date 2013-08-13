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
package org.eclipse.papyrus.dgts.preferences.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.View;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.dgts.preferences.DGTSWorkbenchPreference;
import org.eclipse.papyrus.dgts.service.DgtsResourceLoader;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationOperation;
import org.eclipse.papyrus.dgts.service.model.configuration.IDGTSModelConfigurationProvider;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DrawerDefinition;

public class DGTSPreferenceProvider implements IDGTSModelConfigurationProvider {
	protected ToolsProvider toolProvider = new ToolsProvider();

	public DGTSPreferenceProvider() {
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
	public List<DrawerDefinition> provideModelConfiguration(
			Collection<EObject> content) {
		if ("".equals(DGTSWorkbenchPreference.getDGTSPreference())) {
			return null;
		}
		List<DrawerDefinition> listDrawer = new ArrayList<>();
		DiagramGlobalToolDefinition global = getDiagramGlobalToolDefinitionFromPreferences();

		for (EObject object : content) {
			if (object instanceof Diagram) {
				if (global != null) {
					Diagram diagram = (Diagram) object;
					DiagramDefinition diagramDefinition = toolProvider
							.getDiagram(diagram.getType(), global);
					listDrawer.addAll(toolProvider
							.getDrawers(diagramDefinition));

				}

			}

		}
		return listDrawer;
	}

	private DiagramGlobalToolDefinition getDiagramGlobalToolDefinitionFromPreferences() {
		URI uri = URI
				.createFileURI(DGTSWorkbenchPreference.getDGTSPreference());
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		Map<Object, Object> options = new HashMap<Object, Object>();
		try {
			resource.load(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DiagramGlobalToolDefinition global = null;
		for (Object object : resource.getContents()) {
			if (object instanceof DiagramGlobalToolDefinition) {
				global = (DiagramGlobalToolDefinition) object;
			}
		}
		return global;
	}

}
