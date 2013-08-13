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

package org.eclipse.papyrus.dgts.wizards.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.commands.CreationCommandRegistry;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.wizards.utility.DgtsDiagramKindContentProvider;
import org.eclipse.papyrus.dgts.wizards.utility.SelectionHelper;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.uml.diagram.wizards.Messages;
import org.eclipse.papyrus.uml.diagram.wizards.kind.DiagramKindContentProvider;
import org.eclipse.papyrus.uml.diagram.wizards.kind.DiagramKindLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;

/**
 * This WizardPage to select the kind of Papyrus Diagram. List all kind of
 * diagrams registered with creationCommand attribute in PapyrusDiagram Eclipse
 * extension.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author Tatiana Fesenko
 */
public class DgtsSelectDiagramKindPage extends WizardPage {

    /** The Constant PAGE_ID. */
    public static final String PAGE_ID = "SelectDiagramKind"; //$NON-NLS-1$

    /** The diagram kind table viewer. */
    private CheckboxTableViewer diagramKindTableViewer;

    /** The my category provider. */
    private final CategoryProvider myCategoryProvider;

    /** The my creation command registry. */
    private final ICreationCommandRegistry myCreationCommandRegistry;

    /** The Constant DEFAULT_CREATION_COMMAND_REGISTRY. */
    public static final ICreationCommandRegistry DEFAULT_CREATION_COMMAND_REGISTRY = CreationCommandRegistry.getInstance(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);

    /**
     * Instantiates a new select diagram kind page.
     * 
     * @param categoryProvider
     *            the category provider
     */
    public DgtsSelectDiagramKindPage(CategoryProvider categoryProvider) {
	this(categoryProvider, DEFAULT_CREATION_COMMAND_REGISTRY);
    }

    /**
     * Instantiates a new select diagram kind page.
     * 
     * @param allowTemplates
     *            the allow templates
     * @param categoryProvider
     *            the category provider
     * @param creationCommandRegistry
     *            the creation command registry
     */
    public DgtsSelectDiagramKindPage(CategoryProvider categoryProvider, ICreationCommandRegistry creationCommandRegistry) {
	super(PAGE_ID);
	setTitle(Messages.SelectDiagramKindPage_page_title);
	setDescription(Messages.SelectDiagramKindPage_page_desc);
	myCategoryProvider = categoryProvider;
	myCreationCommandRegistry = creationCommandRegistry;
    }

    /**
     * Creates the control.
     * 
     * @param parent
     *            the parent {@inheritDoc}
     */
    public void createControl(Composite parent) {
	Composite plate = new Composite(parent, SWT.NONE);
	plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	GridLayout gridLayout = new GridLayout(1, false);
	gridLayout.marginWidth = 10;
	plate.setLayout(gridLayout);
	setControl(plate);

	String[] categories = getDiagramCategories();

	createDiagramKindForm(plate);
	diagramKindTableViewer.setInput(categories);

	fillInTables(categories);

    }

    /**
     * Sets the visible.
     * 
     * @param visible
     *            the new visible
     * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
     */
    @Override
    public void setVisible(boolean visible) {
	super.setVisible(visible);
	if (visible) {
	    fillInTables(getDiagramCategories());
	    validatePage();
	}
    }

    /**
     * Fill in tables.
     * 
     * @param categories
     *            the categories
     */
    private void fillInTables(String[] categories) {
	if (categories == null || categories.length == 0) {
	    return;
	}
	diagramKindTableViewer.setInput(categories);

    }

    /**
     * Gets the diagram category.
     * 
     * @return the diagram category
     */
    private String[] getDiagramCategories() {
	return myCategoryProvider.getCurrentCategories();
    }

    /**
     * Gets the creation commands.
     * 
     * @return the creation command
     */
    public List<ICreationCommand> getCreationCommands() {
	CreationCommandDescriptor[] selected = getSelectedDiagramKindDescriptors();
	List<ICreationCommand> commands = new ArrayList<ICreationCommand>();
	for (int i = 0; i < selected.length; i++) {

	    ICreationCommand command;
	    try {
		command = (selected[i]).getCommand();
		commands.add(command);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return commands;
    }

    /**
     * Gets the selected command descriptors.
     * 
     * @param categoryId
     *            the category id
     * @return the selected command descriptors
     */
    protected List<CreationCommandDescriptor> getSelectedCommandDescriptors(String categoryId) {
	CreationCommandDescriptor[] selected = getSelectedDiagramKindDescriptors();
	List<CreationCommandDescriptor> commands = new ArrayList<CreationCommandDescriptor>();
	for (int i = 0; i < selected.length; i++) {
	    if (selected[i].getLanguage().equals(categoryId)) {
		commands.add(selected[i]);
	    }
	}
	return commands;
    }

    /**
     * Creates the model template composite.
     * 
     * @param composite
     *            the composite
     */

    /**
     * Creates the diagram kind form.
     * 
     * @param composite
     *            the composite
     */
    private void createDiagramKindForm(Composite composite) {
	Group group = createGroup(composite, Messages.SelectDiagramKindPage_select_kind_group);
	GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
	group.setData(data);

	final Table diagramKindTable = new Table(group, SWT.NO_BACKGROUND | SWT.CHECK);
	diagramKindTable.setFont(group.getFont());
	diagramKindTable.setBackground(group.getBackground());

	GridLayout layout = new GridLayout(1, false);
	layout.marginHeight = 5;
	layout.marginWidth = 5;
	diagramKindTable.setLayout(layout);

	GridData data2 = new GridData(SWT.FILL, SWT.FILL, true, true);
	diagramKindTable.setLayoutData(data2);

	diagramKindTable.addSelectionListener(new SelectionListener() {

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetSelected(SelectionEvent e) {
		if (e.detail == SWT.CHECK) {
		    validatePage();
		}
	    }

	    /**
	     * {@inheritDoc}
	     */
	    public void widgetDefaultSelected(SelectionEvent e) {
		// does nothing
	    }
	});
	diagramKindTableViewer = new CheckboxTableViewer(diagramKindTable);

	diagramKindTableViewer.setContentProvider(new DgtsDiagramKindContentProvider(getCreationCommandRegistry()));

	diagramKindTableViewer.setLabelProvider(createDiagramKindLabelProvider());
    }

    /**
     * Creates the diagram kind label provider.
     * 
     * @return the i base label provider
     */
    protected IBaseLabelProvider createDiagramKindLabelProvider() {
	return new DiagramKindLabelProvider();
    }

    /**
     * Creates the group.
     * 
     * @param parent
     *            the parent
     * @param name
     *            the name
     * @return the group
     */
    private static Group createGroup(Composite parent, String name) {
	Group group = new Group(parent, SWT.NONE);
	group.setText(name);
	GridLayout layout = new GridLayout(1, false);
	layout.marginHeight = 5;
	layout.marginWidth = 5;
	group.setLayout(layout);
	GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
	group.setLayoutData(data);
	return group;
    }

    /**
     * Validate page.
     * 
     * @return true, if successful
     */
    private boolean validatePage() {

	if (getCreationCommands().isEmpty()) {
	    updateStatus("At least one diagram kind should be selected.");
	    return false;
	}
	updateStatus(null);
	return true;
    }

    /**
     * Update page status.
     * 
     * @param message
     *            is the error message.
     */
    private void updateStatus(String message) {
	setErrorMessage(message);
	setPageComplete(message == null);
    }

    /**
     * Gets the selected diagram kinds.
     * 
     * @param categoryId
     *            the category id
     * @return the selected diagram kinds
     */
    public List<String> getSelectedDiagramKinds() {
	List<String> result = new ArrayList<String>();
	for (String categoryId : myCategoryProvider.getCurrentCategories()) {

	    List<CreationCommandDescriptor> descriptors = getSelectedCommandDescriptors(categoryId);
	    for (CreationCommandDescriptor desc : descriptors) {
		
		try {
		    result.add(desc.getCommand().getCreatedDiagramType());
		} catch (BackboneException e) {
		    e.printStackTrace();
		}
	    }
	}

	return result;
    }

    /**
     * Gets the selected diagram kind descriptors.
     * 
     * @return the selected diagram kind descriptors
     */
    protected CreationCommandDescriptor[] getSelectedDiagramKindDescriptors() {
	Object[] checked = diagramKindTableViewer.getCheckedElements();
	// as Object is not a subclass of String we cannot cast Object[] to
	// String[]
	CreationCommandDescriptor[] result = Arrays.asList(checked).toArray(new CreationCommandDescriptor[checked.length]);
	return result;
    }

    /**
     * Select default diagram kinds.
     * 
     * @param categories
     *            the categories
     */

    /**
     * Gets the creation command registry.
     * 
     * @return the creation command registry
     */
    protected final ICreationCommandRegistry getCreationCommandRegistry() {

	return myCreationCommandRegistry;

    }

   

    /**
     * The Interface CategoryProvider.
     */
    public static interface CategoryProvider {

	/**
	 * Gets the current categories.
	 * 
	 * @return the current categories
	 */
	String[] getCurrentCategories();
    }

}
