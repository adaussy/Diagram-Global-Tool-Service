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

package DiagramGlobalToolService.impl;

import DiagramGlobalToolService.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramGlobalToolServiceFactoryImpl extends EFactoryImpl implements DiagramGlobalToolServiceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagramGlobalToolServiceFactory init() {
		try {
			DiagramGlobalToolServiceFactory theDiagramGlobalToolServiceFactory = (DiagramGlobalToolServiceFactory)EPackage.Registry.INSTANCE.getEFactory(DiagramGlobalToolServicePackage.eNS_URI);
			if (theDiagramGlobalToolServiceFactory != null) {
				return theDiagramGlobalToolServiceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DiagramGlobalToolServiceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramGlobalToolServiceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DiagramGlobalToolServicePackage.DIAGRAM_GLOBAL_TOOL_DEFINITION: return createDiagramGlobalToolDefinition();
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION: return createDiagramDefinition();
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION: return createDrawerDefinition();
			case DiagramGlobalToolServicePackage.TOOL: return createTool();
			case DiagramGlobalToolServicePackage.ELEMENT_TYPE: return createElementType();
			case DiagramGlobalToolServicePackage.ICON: return createIcon();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramGlobalToolDefinition createDiagramGlobalToolDefinition() {
		DiagramGlobalToolDefinitionImpl diagramGlobalToolDefinition = new DiagramGlobalToolDefinitionImpl();
		return diagramGlobalToolDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramDefinition createDiagramDefinition() {
		DiagramDefinitionImpl diagramDefinition = new DiagramDefinitionImpl();
		return diagramDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DrawerDefinition createDrawerDefinition() {
		DrawerDefinitionImpl drawerDefinition = new DrawerDefinitionImpl();
		return drawerDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tool createTool() {
		ToolImpl tool = new ToolImpl();
		return tool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementType createElementType() {
		ElementTypeImpl elementType = new ElementTypeImpl();
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Icon createIcon() {
		IconImpl icon = new IconImpl();
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramGlobalToolServicePackage getDiagramGlobalToolServicePackage() {
		return (DiagramGlobalToolServicePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DiagramGlobalToolServicePackage getPackage() {
		return DiagramGlobalToolServicePackage.eINSTANCE;
	}

} //DiagramGlobalToolServiceFactoryImpl
