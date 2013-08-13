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
package org.eclipse.papyrus.dgts.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.osgi.framework.Bundle;

import ElementRegistry.Context;
import ElementRegistry.DiagramDefinition;
import ElementRegistry.EClassDefinition;
import ElementRegistry.ElementRegistryFactory;
import ElementRegistry.ElementType;
import ElementRegistry.Registry;


/**
 * @author gdesq
 * This registry contains all IElementtypes from the resource default.elementregistry, they are classed by Diagram and by EClass
 * The function initElementRegistry can be called to generate a new default elementregistry.
 * The resource default.elementregistry can be modified to offer a better choice matching to the user.
 */
public class DgtsElementTypeRegistry {

	private Registry registry;

	public Registry getRegistry() {
		return registry;
	}

	protected void setRegistry(Registry registry) {
		this.registry = registry;
	}

	private HashMap<String, String> mapDiagrams = new HashMap<>();

	private HashMap<IElementType, String> mapDescriptions = new HashMap<>();

	protected void addDiagram(String context, String diagram) {
		mapDiagrams.put(context, diagram);
	}

	protected void removeDiagram(String context) {
		mapDiagrams.remove(context);
	}

	protected void addDescription(IElementType type, String desc) {
		mapDescriptions.put(type, desc);
	}

	protected void removeDescription(IElementType type) {
		mapDescriptions.remove(type);
	}

	public DgtsElementTypeRegistry() {


		Bundle bundle = Platform.getBundle("org.eclipse.papyrus.dgts.service");
		URL fileURL = bundle.getEntry("resources/default.elementregistry");
		File file = null;
		try {
			file = new File(FileLocator.resolve(fileURL).toURI());
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		URI uri = URI.createFileURI(file.getPath().toString());

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		Map<Object, Object> options = new HashMap<Object, Object>();
		try {
			resource.load(options);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(resource != null) {
			for(EObject object : resource.getContents()) {
				if(object instanceof Registry) {
					registry = (Registry)object;
				}
			}
		}
	}

	private final static DgtsElementTypeRegistry elementTypeRegistry = new DgtsElementTypeRegistry();

	public static DgtsElementTypeRegistry getInstance() {
		return elementTypeRegistry;
	}

	public List<EClassDefinition> getAllEclassFromDiagram(String diagramType) {
		DiagramDefinition diagram = getDiagram(diagramType);
		if(diagram != null) {
			return diagram.getRefEClass();
		}
		return null;
	}

	protected IElementType idToIElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	protected void initDescriptionMap() {

	}

	protected void initDiagramMap() {

		/*
		 * 
		 * ICreationCommandRegistry DEFAULT_CREATION_COMMAND_REGISTRY =
		 * CreationCommandRegistry
		 * .getInstance(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID); for
		 * (CreationCommandDescriptor cmd :
		 * DEFAULT_CREATION_COMMAND_REGISTRY.getCommandDescriptors()){ try {
		 * cmd.getCommand().getCreatedDiagramType();
		 * System.out.println(cmd.getCommandId()); } catch (BackboneException e)
		 * { e.printStackTrace(); } }
		 */

		// UML
		mapDiagrams.put("org.eclipse.papyrus.uml.diagram.deployment.TypeContext", "PapyrusUMLDeploymentDiagram");
		mapDiagrams.put("org.eclipse.papyrus.uml.diagram.sequence.TypeContext", "PapyrusUMLSequenceDiagram");
		mapDiagrams.put("org.eclipse.papyrus.uml.diagram.composite.TypeContext", "CompositeStructure");
		mapDiagrams.put("org.eclipse.papyrus.uml.diagram.activity.TypeContext", "PapyrusUMLActivityDiagram");
		mapDiagrams.put("org.eclipse.papyrus.uml.diagram.component.TypeContext", "PapyrusUMLComponentDiagram");
		mapDiagrams.put("org.eclipse.papyrus.uml.diagram.communication.TypeContext", "PapyrusUMLCommunicationDiagram");
		mapDiagrams.put("org.eclipse.papyrus.uml.diagram.usecase.TypeContext", "UseCase");
		mapDiagrams.put("org.eclipse.papyrus.uml.diagram.profile.TypeContext", "PapyrusUMLProfileDiagram");
		mapDiagrams.put("org.eclipse.papyrus.uml.diagram.statemachine.TypeContext", "PapyrusUMLStateMachineDiagram");
		mapDiagrams.put("org.eclipse.papyrus.uml.diagram.timing.TypeContext", "PapyrusUMLTimingDiagram");
		mapDiagrams.put("org.eclipse.papyrus.uml.diagram.clazz.TypeContext", "PapyrusUMLClassDiagram");

		// TODO add les trucs pour sysml
		/*
		 * Package InternalBlock RequirementDiagram BlockDefinition
		 * org.eclipse.emf.ecoretools.diagram.TypeContext
		 */

	}

	// This function is used to create a default elementregistry
	public void initElementRegistry() {
		List<IElementType> typesToAddInTheEnd = new ArrayList<IElementType>();
		Path path = new Path("papy/My.elementregistry");
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		Resource resource;
		Registry elementRegistry = null;
		try {
			resource = DgtsResourceLoader.loadResource(file);
			System.out.println("file loaded");
		} catch (IOException e) {
			resource = null;
			e.printStackTrace();
		}
		if(resource != null) {
			for(EObject object : resource.getContents()) {
				if(object instanceof Registry) {
					elementRegistry = (Registry)object;
				}
			}

		}
		initDiagramMap();
		Set<?> clientContexts = ClientContextManager.getInstance().getClientContexts();
		if(elementRegistry != null) {

			for(Object object : clientContexts) {
				if(object instanceof IClientContext) {

					// System.out.println(object);
					IClientContext context = (IClientContext)object;

					// Global stored elements:
					if(context.getId().equals("org.eclipse.emf.ecoretools.diagram.TypeContext")) {

					}

					else if(context.getId().equals("org.eclipse.papyrus.infra.services.edit.TypeContext")) {
						IElementType[] types = ElementTypeRegistry.getInstance().getElementTypes(context);
						for(int i = 0; i < types.length; i++) {
							// sysml

							if(types[i].getId().startsWith("org.eclipse.papyrus.sysml")) {
								DiagramDefinition[] diagrams = { addDiagram("InternalBlock", elementRegistry), addDiagram("RequirementDiagram", elementRegistry), addDiagram("BlockDefinition", elementRegistry) };

								for(int j = 0; j < diagrams.length; j++) {
									EClassDefinition eclass = addEclass(types[i].getEClass(), diagrams[j]);
									ElementType element = ElementRegistryFactory.eINSTANCE.createElementType();
									element.setElementTypeID(types[i].getId());
									element.setContext(Context.DIAGRAM_AND_MODEL_EXPLORER);
									eclass.getRefElementTypes().add(element);

								}

							} else if(types[i].getId().startsWith("org.eclipse.papyrus.uml.diagram.activity")) {
								DiagramDefinition diagram = addDiagram("PapyrusUMLActivityDiagram", elementRegistry);
								EClassDefinition eclass = addEclass(types[i].getEClass(), diagram);
								ElementType element = ElementRegistryFactory.eINSTANCE.createElementType();
								element.setElementTypeID(types[i].getId());
								element.setContext(Context.DIAGRAM_AND_MODEL_EXPLORER);
								eclass.getRefElementTypes().add(element);

							} else {
								// types used for the menu : keep them and add
								// them at the end to the corresponding eclasses
								// :
								typesToAddInTheEnd.add(types[i]);

							}

						}

					}

					// Specific elements for each diagrams
					else {
						if(mapDiagrams.containsKey(context.getId())) {
							String diagramType = mapDiagrams.get(context.getId());

							DiagramDefinition diagram = addDiagram(diagramType, elementRegistry);
							IElementType[] types = ElementTypeRegistry.getInstance().getElementTypes(context);
							for(int i = 0; i < types.length; i++) {
								EClassDefinition eclass = addEclass(types[i].getEClass(), diagram);

								ElementType element = ElementRegistryFactory.eINSTANCE.createElementType();
								element.setElementTypeID(types[i].getId());
								element.setContext(Context.DIAGRAM);
								eclass.getRefElementTypes().add(element);

							}
						}
					}

				}
			}
			for(IElementType type : typesToAddInTheEnd) {
				boolean ok = false;
				for(DiagramDefinition diagram : elementRegistry.getRefDiagrams()) {
					for(EClassDefinition eclass : diagram.getRefEClass()) {
						if(eclass.getEClass() == type.getEClass()) {
							ok = true;
							ElementType element = ElementRegistryFactory.eINSTANCE.createElementType();
							element.setElementTypeID(type.getId());
							element.setContext(Context.MODEL_EXPLORER);
							eclass.getRefElementTypes().add(element);
						}

					}
				}

				if(ok == false) {
					DiagramDefinition diag = addDiagram("Others", elementRegistry);
					EClassDefinition eclass = addEclass(type.getEClass(), diag);
					ElementType element = ElementRegistryFactory.eINSTANCE.createElementType();
					element.setElementTypeID(type.getId());
					element.setContext(Context.MODEL_EXPLORER);
					eclass.getRefElementTypes().add(element);
				}
			}
			try {
				resource.save(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private DiagramDefinition addDiagram(String diagramType, Registry registry) {
		for(DiagramDefinition diagram : registry.getRefDiagrams()) {
			if(diagram.getDiagramType().equals(diagramType)) {
				return diagram;
			}
		}
		ElementRegistry.DiagramDefinition diagram = ElementRegistryFactory.eINSTANCE.createDiagramDefinition();
		diagram.setDiagramType(diagramType);
		registry.getRefDiagrams().add(diagram);
		return diagram;
	}

	public DiagramDefinition getDiagram(String diagramType) {
		for(DiagramDefinition diagram : registry.getRefDiagrams()) {
			if(diagram.getDiagramType().equals(diagramType)) {
				return diagram;
			}
		}
		return null;

	}

	private EClassDefinition addEclass(EClass eclass, DiagramDefinition diagram) {
		for(EClassDefinition eclassDef : diagram.getRefEClass()) {
			if(eclassDef.getEClass() == eclass) {
				return eclassDef;
			}
		}
		EClassDefinition eclassDef = ElementRegistryFactory.eINSTANCE.createEClassDefinition();
		eclassDef.setEClass(eclass);
		diagram.getRefEClass().add(eclassDef);
		return eclassDef;
	}

}
