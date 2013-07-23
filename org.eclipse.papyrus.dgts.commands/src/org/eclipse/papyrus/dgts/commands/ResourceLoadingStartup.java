package org.eclipse.papyrus.dgts.commands;

import java.util.List;

import org.eclipse.core.commands.CommandManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.papyrus.dgts.palette.ToolDefinitionCustomPaletteProvider;
import org.eclipse.papyrus.uml.diagram.common.part.IPaletteDescription;
import org.eclipse.papyrus.uml.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class ResourceLoadingStartup  {

	@Execute
	public void execute(){
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
		//ToolDefinitionCustomPaletteProvider.hideDefaultPalette();
		
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
