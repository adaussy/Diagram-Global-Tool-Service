package org.eclipse.papyrus.dgts.popupbar;


import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;


import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;

import org.eclipse.papyrus.uml.diagram.clazz.providers.*;



public class CustomModelingAssistantProvider extends ModelingAssistantProvider{


	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof DiagramEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			return types;
		}
		
		return Collections.EMPTY_LIST;
	}
	/*
	
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for (Iterator<EObject> it = diagram.getElement().eAllContents(); it
				.hasNext();) {
			EObject element = it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}


	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				UMLDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
	
	*/
}
