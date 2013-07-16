package org.eclipse.papyrus.dgts.commands;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.diagram.ui.DiagramUtil;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.papyrus.dgts.service.DgtsResourceLoader;
import org.eclipse.papyrus.dgts.service.ToolDefinitionResourceProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;

public class LoadModelCommandHandler extends AbstractHandler {
	protected static final String EXTENSION = "diagramglobaltoolservice";

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
					IFile file = (IFile) firstElement;
					if (IExtenstionPath.EXTENSION.equals(file
							.getFileExtension())) {
						try {
							Resource resource = DgtsResourceLoader
									.LoadResource(file);
							ToolDefinitionResourceProvider
									.setResource(resource);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
			}
		}
		return null;
	}

	protected void UpdatePalette() {
		PaletteRoot root = ToolDefinitionCustomPaletteProvider.getRoot();
		IEditorPart editor = ToolDefinitionCustomPaletteProvider.getEditor();
		Object content = ToolDefinitionCustomPaletteProvider.getContent();
		if (root != null && editor != null && content != null) {
			PaletteService.getInstance().updatePalette(root, editor, content);
		}

	}

}
