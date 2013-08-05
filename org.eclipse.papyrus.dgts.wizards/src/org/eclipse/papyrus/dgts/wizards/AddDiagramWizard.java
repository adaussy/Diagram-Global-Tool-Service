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
import org.eclipse.papyrus.dgts.pages.DgtsSelectDiagramCategoryPage;
import org.eclipse.papyrus.dgts.pages.DgtsSelectDiagramKindPage;
import org.eclipse.papyrus.dgts.pages.DgtsSelectDiagramKindPage.CategoryProvider;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.utility.SelectionHelper;
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
	Resource resource = SelectionHelper.getResourceFromSelection();
	DiagramGlobalToolDefinition globalDiagramConfiguration = null;
	ToolsProvider toolsProvider = new ToolsProvider();
	List<String> selectedDiagramKinds = selectDiagramKindPage.getSelectedDiagramKinds();
	
	    if (resource != null) {
		globalDiagramConfiguration = toolsProvider.getDiagramGlobalToolDefinitionFromResource(resource);
		if (globalDiagramConfiguration != null) {

		    //We get the editdomain
		    Object editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(globalDiagramConfiguration);
		    if (editingDomain instanceof EditingDomain) {
			domain = (EditingDomain) editingDomain;

			for (String diagramType : selectedDiagramKinds) {
			    if (diagramType != null) {

				DiagramDefinition diag = DiagramGlobalToolServiceFactory.eINSTANCE.createDiagramDefinition();
				diag.setDiagramType(diagramType);
				AddCommand cmd = new AddCommand(domain, globalDiagramConfiguration, DiagramGlobalToolServicePackage.Literals.DIAGRAM_GLOBAL_TOOL_DEFINITION__DIAGRAM_DEFINITION_REF, diag);
				cmds.add(cmd);

			    }
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
