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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.di.annotations.Execute;

public class ResourceLoadingStartup {

	@Execute
	public void execute() {
		loadResource();

	}

	protected void loadResource() {
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace()
				.getRoot();
		for (IProject project : myWorkspaceRoot.getProjects()) {
			if (project.isOpen()) {
				getFileInProject(project);

			}
		}

	}

	private void getFileInProject(IProject project) {

		try {
			for (IResource resource : project.members()) {
				if (resource instanceof IFile) {
					LoadModelCommandHandler.loadFileResource((IFile) resource);
				}

			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
