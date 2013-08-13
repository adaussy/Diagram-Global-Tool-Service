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
package org.eclipse.papyrus.dgts.wizards.editor;

import java.net.URI;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MInputPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.FileEditorInput;

public class DgtsEditor {

    @Execute
    public void open(FileEditorInput input, MApplication application, EModelService modelService, EPartService partService) {
	URI uri = input.getURI();
	// assuming that all editors should open in the stack with the
	// ID "org.eclipse.e4.primaryDataStack"

	MPartStack stack = (MPartStack) modelService.find("org.eclipse.e4.primaryDataStack", application);

	MInputPart part = MBasicFactory.INSTANCE.createInputPart();
	// Pointing to the contributing class
	part.setContributionURI("bundleclass://org.eclipse.papyrus.dgts.wizards/org.eclipse.papyrus.dgts.wizards.pages.DgtsGlobalPage");
	part.setInputURI(input.getURI().toString());
//	part.setIconURI("platform:/plugin/de.vogella.rcp.e4.todo/icons/sample.gif");
	part.setLabel(input.getName());
	part.setCloseable(true);
	stack.getChildren().add(part);
	partService.showPart(part, PartState.ACTIVATE);
    }
    
    @PostConstruct
    public void createContent(Composite parent){
	
    }

}
