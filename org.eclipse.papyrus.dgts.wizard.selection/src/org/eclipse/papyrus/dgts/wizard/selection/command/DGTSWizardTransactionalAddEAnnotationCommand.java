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
package org.eclipse.papyrus.dgts.wizard.selection.command;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.dgts.wizard.selection.DgtsCustomPage;

/** Command to add EAnnotation with the model configuration url to a diagram view.
 * @author vlartiga
 *
 */
public class DGTSWizardTransactionalAddEAnnotationCommand extends
		AbstractTransactionalCommand {

	private Diagram diagramView;
	private DgtsCustomPage mainPage;

	public DGTSWizardTransactionalAddEAnnotationCommand(TransactionalEditingDomain domain,
			String label, @SuppressWarnings("rawtypes") List affectedFiles) {
		super(domain, label, affectedFiles);
	}

	public DGTSWizardTransactionalAddEAnnotationCommand(Diagram diagramView, String description,DgtsCustomPage mainPage){
		super(TransactionUtil.getEditingDomain(diagramView), description, Collections.singletonList(WorkspaceSynchronizer.getFile(diagramView.eResource())));
		this.diagramView = diagramView ;
		this.mainPage = mainPage ;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		List<String> listPath = mainPage.getAllModelConfigurationPath() ;
		diagramView.getEAnnotations().clear();
		for(String path : listPath ){
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(path);
			EList<EAnnotation> anot = diagramView.getEAnnotations() ;
			anot.add(eAnnotation);
			
		}
		return CommandResult.newOKCommandResult();
	}

}
