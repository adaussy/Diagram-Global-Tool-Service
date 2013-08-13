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
package org.eclipse.papyrus.dgts.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.wizards.pages.DgtsGlobalPage;
import org.eclipse.papyrus.dgts.wizards.pages.DgtsSelectDiagramCategoryPage;
import org.eclipse.papyrus.dgts.wizards.pages.DgtsSelectDiagramKindPage;
import org.eclipse.papyrus.dgts.wizards.pages.DgtsSelectDiagramKindPage.CategoryProvider;
import org.eclipse.papyrus.dgts.wizards.utility.SelectionHelper;
import org.eclipse.papyrus.uml.diagram.wizards.Activator;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DiagramGlobalToolServiceFactory;
import DiagramGlobalToolService.DiagramGlobalToolServicePackage;

public class AddDiagramWizard extends Wizard {
    public static final String NEW_DIAGRAM_SETTINGS = "AddDiagramToConfigurationWizard"; //$NON-NLS-1$
    private List<AddCommand> cmds = new ArrayList<AddCommand>();
    private EditingDomain domain;
    private DgtsSelectDiagramCategoryPage selectDiagramCategoryPage;
    private DgtsSelectDiagramKindPage selectDiagramKindPage;

    public AddDiagramWizard() {

	super();
	setNeedsProgressMonitor(true);

	IDialogSettings workbenchSettings = Activator.getDefault().getDialogSettings();
	IDialogSettings section = workbenchSettings.getSection(NEW_DIAGRAM_SETTINGS);
	if (section == null) {
	    section = workbenchSettings.addNewSection(NEW_DIAGRAM_SETTINGS);
	}
	setDialogSettings(section);

    }

    @Override
    public void addPages() {

	selectDiagramCategoryPage = createSelectDiagramCategoryPage();
	addPageIfNotNull(selectDiagramCategoryPage);

	selectDiagramKindPage = createSelectDiagramKindPage();
	addPageIfNotNull(selectDiagramKindPage);
    }

    protected DgtsSelectDiagramCategoryPage createSelectDiagramCategoryPage() {
	return new DgtsSelectDiagramCategoryPage();
    }

    protected DgtsSelectDiagramKindPage createSelectDiagramKindPage() {
	return new DgtsSelectDiagramKindPage(new CategoryProvider() {

	    public String[] getCurrentCategories() {
		return getDiagramCategoryIds();
	    }

	});
    }

    protected final void addPageIfNotNull(IWizardPage page) {
	if (page != null) {
	    addPage(page);
	}
    }

    /**
     * Gets the diagram category ids.
     * 
     * @return the diagram category ids
     */
    protected String[] getDiagramCategoryIds() {
	if (selectDiagramCategoryPage != null) {
	    return selectDiagramCategoryPage.getDiagramCategories();
	}
	return null;
    }

    @Override
    public boolean performFinish() {
	Resource resource = DgtsGlobalPage.getResource();
	DiagramGlobalToolDefinition globalDiagramConfiguration = null;
	ToolsProvider toolsProvider = new ToolsProvider();
	List<String> selectedDiagramKinds = selectDiagramKindPage.getSelectedDiagramKinds();
	
	    if (resource != null) {
		globalDiagramConfiguration = toolsProvider.getDiagramGlobalToolDefinitionFromResource(resource);
		if (globalDiagramConfiguration != null) {



			for (String diagramType : selectedDiagramKinds) {
			    if (diagramType != null) {

				DiagramDefinition diag = DiagramGlobalToolServiceFactory.eINSTANCE.createDiagramDefinition();
				diag.setDiagramType(diagramType);
				globalDiagramConfiguration.getDiagramDefinitionRef().add(diag);

			    }
			
		    }
		}
	    }

	

	return true;

    }

    
 
    
    
  
    public List<AddCommand> getCommands() {
	return cmds;
    }

    public EditingDomain getEditingDomain() {
	return domain;
    }

}
