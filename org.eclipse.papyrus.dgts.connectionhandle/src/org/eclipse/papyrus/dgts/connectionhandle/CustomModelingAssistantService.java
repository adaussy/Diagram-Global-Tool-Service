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
package org.eclipse.papyrus.dgts.connectionhandle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.internal.MslUIPlugin;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.dgts.service.ToolsProvider;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationOperation;
import org.eclipse.papyrus.dgts.service.model.configuration.DGTSModelConfigurationService;

import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.Tool;





/**
 * @author gdesq
 *         This is a service used by the connection handle edit policy to get the possibles connections type
 */
public class CustomModelingAssistantService extends ModelingAssistantService {

	/** The singleton instance of the modeling assistant service. */
	private final static CustomModelingAssistantService service = new CustomModelingAssistantService();

	static {
		service.configureProviders(MslUIPlugin.getPluginId(), "modelingAssistantProviders"); //$NON-NLS-1$
	}

	/**
	 * Retrieves the singleton instance of the custom modeling assistant
	 * service.
	 * 
	 * @return The custom modeling assistant service singleton.
	 */

	public static CustomModelingAssistantService getInstance() {
		return service;
	}

	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		if(source.getAdapter(IGraphicalEditPart.class) instanceof IGraphicalEditPart) {

			List<IElementType> types = new ArrayList<IElementType>();
			List<IElementType> possibleTypes = getPossibleRelTypes(source);
			if(possibleTypes != null) {
				for(IElementType type : possibleTypes) {

					// if (isValidRelationForSource(typeEClass, sourceEClass)) {
					types.add(type);
					// }
				}
				return types;
			}
		}
		return Collections.emptyList();

	}

	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		if(target.getAdapter(IGraphicalEditPart.class) instanceof IGraphicalEditPart) {

			List<IElementType> types = new ArrayList<IElementType>();
			List<IElementType> possibleTypes = getPossibleRelTypes(target);
			if(possibleTypes != null) {
				for(IElementType type : possibleTypes) {

					// if (isValidRelationForTarget(typeEClass, sourceEClass)) {
					types.add(type);
					// }
				}
				return types;
			}
		}
		return Collections.emptyList();

	}

	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		if((source.getAdapter(IGraphicalEditPart.class) instanceof IGraphicalEditPart) && (target.getAdapter(IGraphicalEditPart.class) instanceof IGraphicalEditPart)) {

			IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
			IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
			List<IElementType> types = new ArrayList<IElementType>();
			List<IElementType> possibleTypes = getPossibleRelTypes(source);
			if(possibleTypes != null) {
				for(IElementType type : possibleTypes) {

					if(isValidRelationForSourceAndTarget(type, sourceEditPart, targetEditPart)) {

						types.add(type);
					}

				}
				return types;
			}
		}
		return Collections.emptyList();

	}

	public List<IElementType> getTypesForSourceAndContainer(IAdaptable target, IElementType relationshipType, IGraphicalEditPart container) {

		List<IElementType> types = new ArrayList<IElementType>();
		List<IElementType> possibleTypes = getPossibleElementTypes(container);

		EClass relationEClass = relationshipType.getEClass();
		if(possibleTypes != null) {
			for(IElementType type : possibleTypes) {

				EClass targetEClass = type.getEClass();
				if(isValidSource(relationEClass, targetEClass)) {

					// check if we can create the element at this place
					if(isValidType(type, container)) {
						types.add(type);

					}
				}

			}
			return types;
		}

		return Collections.emptyList();

	}

	public List<IElementType> getTypesForTargetAndContainer(IAdaptable source, IElementType relationshipType, IGraphicalEditPart container) {

		List<IElementType> types = new ArrayList<IElementType>();
		List<IElementType> possibleTypes = getPossibleElementTypes(container);

		EClass relationEClass = relationshipType.getEClass();
		if(possibleTypes != null) {
			for(IElementType type : possibleTypes) {

				EClass targetEClass = type.getEClass();
				if(isValidTarget(relationEClass, targetEClass)) {

					// check if we can create the element at this place
					if(isValidType(type, container)) {

						types.add(type);

					}

				}

			}
			return types;
		}

		return null;
	}

	private List<IElementType> getPossibleElementTypes(IAdaptable element) {
		IGraphicalEditPart editPart = (IGraphicalEditPart)element.getAdapter(IGraphicalEditPart.class);

		// type du diagrame courant
		DiagramEditPart diagramPart = (DiagramEditPart)editPart.getRoot().getChildren().get(0);

		// declaration
		List<IElementType> types = new ArrayList<IElementType>(1);
		ToolsProvider toolsProvider = new ToolsProvider();

		// recupere le container
		// View containerview = editPart.getNotationView();


		// recupere le globalDiagramConfiguration actif
		DGTSModelConfigurationOperation operation = new DGTSModelConfigurationOperation(Collections.singleton((View)diagramPart.getModel()));
		List<DrawerDefinition> listOfDrawers = DGTSModelConfigurationService.getInstance().getModelConfiguration(operation);
		// recupere la liste des tools correspondant au diagrame
		List<Tool> listOfTools = new ArrayList<Tool>();
		listOfTools = toolsProvider.getTools(listOfDrawers);

		// traitement de chaque tool
		if(listOfTools != null) {
			for(Tool tool : listOfTools) {
				if(tool.isSetPopup()) {

					if(!(tool.isIsEdge())) {

						List<IElementType> possibleTypes = new ArrayList<IElementType>(1);

						possibleTypes = toolsProvider.getIElementTypesFromTool((Tool)tool);

						if(possibleTypes != null) {
							for(IElementType type : possibleTypes) {
								// check if its a visual type or not :
								if(type != null) {

									if(!(types.contains(type))) {
										types.add(type);
									}

								}
							}
						}
					}
				}
			}

			return types;
		}
		return null;
	}

	private List<IElementType> getPossibleRelTypes(IAdaptable element) {
		IGraphicalEditPart editPart = (IGraphicalEditPart)element.getAdapter(IGraphicalEditPart.class);

		// type du diagrame courant
		DiagramEditPart diagramPart = (DiagramEditPart)editPart.getRoot().getChildren().get(0);

		// declaration
		List<IElementType> types = new ArrayList<IElementType>(1);
		ToolsProvider toolsProvider = new ToolsProvider();

		// recupere le container
		// View containerview = editPart.getNotationView();

		// recupere le globalDiagramConfiguration actif
		DGTSModelConfigurationOperation operation = new DGTSModelConfigurationOperation(Collections.singleton((View)diagramPart.getModel()));
		List<DrawerDefinition> listOfDrawers = DGTSModelConfigurationService.getInstance().getModelConfiguration(operation);
		// recupere la liste des tools correspondant au diagrame
		List<Tool> listOfTools = new ArrayList<Tool>();
		listOfTools = toolsProvider.getTools(listOfDrawers);

		// traitement de chaque tool
		if(listOfTools != null) {
			for(Tool tool : listOfTools) {
				if(tool.isSetPopup()) {

					if(tool.isIsEdge()) {

						List<IElementType> possibleTypes = new ArrayList<IElementType>(1);

						possibleTypes = toolsProvider.getIElementTypesFromTool((Tool)tool);

						if(possibleTypes != null) {
							for(IElementType type : possibleTypes) {
								// check if its a visual type or not :
								if(type != null) {
									if(!(types.contains(type))) {
										types.add(type);
									}

								}
							}
						}
					}
				}
			}

			return types;

		}
		return null;

	}

	private boolean isValidSource(EClass relation, EClass source) {
		return hasReferenceTo(relation, source);

	}

	private boolean isValidTarget(EClass relation, EClass target) {

		return hasReferenceTo(relation, target);
	}

	private boolean isValidRelationForSource(EClass relation, EClass source) {

		return hasReferenceTo(source, relation);
	}

	private boolean isValidRelationForTarget(EClass relation, EClass source) {

		return hasReferenceTo(source, relation);
	}

	private boolean isValidRelationForSourceAndTarget(IElementType relationType, EditPart sourceEditPart, EditPart targetEditPart) {

		CreateConnectionViewAndElementRequest request = new CreateConnectionViewAndElementRequest(relationType, null);
		if(sourceEditPart != null && targetEditPart != null) {
			Command cmd = CreateConnectionViewAndElementRequest.getCreateCommand(request, sourceEditPart, targetEditPart);
			if(cmd != null && cmd.canExecute()) {
				return true;
			}
		}
		return false;
	}

	private boolean isValidType(IElementType elementType, IGraphicalEditPart host) {
		CreateViewAndElementRequest request = new CreateViewAndElementRequest(elementType, null);
		Command cmd = host.getCommand(request);
		if(cmd != null && cmd.canExecute()) {

			return true;
		}
		return false;
	}

	private boolean hasReferenceTo(EClass eClass, EClass eClassReferenced) {

		for(EReference eRef : eClass.getEAllReferences()) {
			if(!eRef.isContainment() && !eRef.isDerived() && !eRef.isUnsettable()) {
				EClassifier typeEC = eRef.getEType();
				if(typeEC instanceof EClass) {
					EClass typeEClass = (EClass)typeEC;
					if(typeEClass.isSuperTypeOf(eClassReferenced)) {

						return true;
					}
				}
			}
		}
		return false;
	}

}
