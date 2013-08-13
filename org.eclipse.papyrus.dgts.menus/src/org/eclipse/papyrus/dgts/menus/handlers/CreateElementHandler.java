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
package org.eclipse.papyrus.dgts.menus.handlers;

import javax.inject.Named;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.service.provider.FillRequestOperation;
import org.eclipse.papyrus.dgts.service.provider.FillRequestService;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.modelexplorer.util.ModelExplorerUtils;
import org.eclipse.papyrus.uml.service.types.filter.ICommandFilter;
import org.eclipse.papyrus.uml.service.types.filter.UmlElementCommandFilter;
import org.eclipse.papyrus.uml.service.types.handlers.AbstractCreateCommandHandler;
import org.eclipse.papyrus.uml.service.types.utils.ICommandContext;


/** Handler called when the user select an element to create in the model explorer
 * @author vlartiga
 *
 */
@SuppressWarnings("restriction")
public class CreateElementHandler extends AbstractCreateCommandHandler {

	private IElementType elemenType;
	protected ToolsProvider toolProvider = new ToolsProvider();

	/**
	 * @param ElementTypeID
	 * @param selection
	 * @return
	 * @throws ExecutionException
	 */
	@Execute
	public Object execute(
			@Named("org.eclipse.papyrus.dgts.menus.command.commandParameter") String ElementTypeID,
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Object selection)
			throws ExecutionException {
		this.elemenType = DGTSElementTypeCreator.getIElementType(ElementTypeID);
		return super.execute(new ExecutionEvent());

	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.uml.service.types.handlers.AbstractCreateCommandHandler#buildCommand()
	 */
	
	protected Command buildCommand() {

		if (getCommandContext() == null) {
			return UnexecutableCommand.INSTANCE;
		}

		EObject container = getCommandContext().getContainer();
		EReference reference = getCommandContext().getReference();

		IElementEditService provider = ElementEditServiceUtils
				.getCommandProvider(container);
		if (provider == null) {
			return UnexecutableCommand.INSTANCE;
		}

		CreateElementRequest createRequest = null;
		if (reference == null) {
			createRequest = new CreateElementRequest(container,
					getElementTypeToCreate());
		} else {
			createRequest = new CreateElementRequest(container,
					getElementTypeToCreate(), reference);
		}
		FillRequestOperation op = new FillRequestOperation(createRequest,
				elemenType);
		FillRequestService.getInstance().execute(op);
		ICommand createGMFCommand = provider.getEditCommand(createRequest);
		if (createGMFCommand != null) {
			Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);
			return emfCommand;
		}
		return UnexecutableCommand.INSTANCE;

	}

	/**
	 * @param selection
	 * @param part
	 * @return
	 */
	@CanExecute
	
	public boolean canExecute(
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) ISelection selection,
			@Named(IServiceConstants.ACTIVE_PART) MPart part) {

		if (selection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) selection)
					.getFirstElement();
			if (firstElement instanceof ModelElementItem) {
				return true;
			}
		}
		return false;
	}

	
	public boolean canExecute(IElementType elementType) {
			this.elemenType = elementType ;
			if(buildCommand().canExecute()){
				return true ;
			}
			return false ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.uml.service.types.handlers.AbstractCreateCommandHandler#getElementTypeToCreate()
	 */
	@Override
	
	protected IElementType getElementTypeToCreate() {
		return elemenType;

	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.uml.service.types.handlers.AbstractCreateCommandHandler#getCommandFilter()
	 */
	@Override
	
	public ICommandFilter getCommandFilter() {
		return UmlElementCommandFilter.INSTANCE;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.uml.service.types.handlers.AbstractCommandHandler#getCommandContext()
	 */
	@Override
	
	protected ICommandContext getCommandContext() {
		return ModelExplorerUtils.getSelectionCommandContext();
	}

}
