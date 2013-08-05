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

package org.eclipse.papyrus.dgts.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.dgts.service.IDGTSExtensionDefinition;
import org.eclipse.papyrus.dgts.service.ServiceStaticEventNotifier;
import org.eclipse.papyrus.dgts.service.providers.DGTSFileServiceProvider;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class LoadModelCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();

		Object selection = (activeWorkbenchWindow != null) ? activeWorkbenchWindow
				.getSelectionService().getSelection() : null;
		if (selection != null) {

			if (selection instanceof IStructuredSelection) {

				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				Object firstElement = structuredSelection.getFirstElement();
				if (firstElement instanceof IFile) {
					IFile file = (IFile) firstElement ;
					if(IDGTSExtensionDefinition.EXTENTION.equals(file.getFileExtension())){
						DGTSFileServiceProvider.setContent(firstElement);
						ServiceStaticEventNotifier.notifyObservers(null);
					}
					
					

				}
			}
		}
		return null;
	}

	

}
