/**
 * *****************************************************************************
 * Copyright  2013 Atos.
 *  All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  Vincent Lartigaut (Atos) vincent.lartigaut@atos.net - Vincent Lartigaut - initial API and implementation
 *  Guilhem Desq (Atos) guilhem.desq@atos.net -  Guilhem Desq - initial API and implementation
 * *****************************************************************************
 */
package DiagramGlobalToolService;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see DiagramGlobalToolService.DiagramGlobalToolServiceFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramGlobalToolServicePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DiagramGlobalToolService";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://DiagramGlobalToolService/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "DiagramGlobalToolService";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramGlobalToolServicePackage eINSTANCE = DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl.init();

	/**
	 * The meta object id for the '{@link DiagramGlobalToolService.impl.DiagramGlobalToolDefinitionImpl <em>Diagram Global Tool Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagramGlobalToolService.impl.DiagramGlobalToolDefinitionImpl
	 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getDiagramGlobalToolDefinition()
	 * @generated
	 */
	int DIAGRAM_GLOBAL_TOOL_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Diagram Definition Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_GLOBAL_TOOL_DEFINITION__DIAGRAM_DEFINITION_REF = 0;

	/**
	 * The number of structural features of the '<em>Diagram Global Tool Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_GLOBAL_TOOL_DEFINITION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Diagram Global Tool Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_GLOBAL_TOOL_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagramGlobalToolService.impl.DiagramDefinitionImpl <em>Diagram Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagramGlobalToolService.impl.DiagramDefinitionImpl
	 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getDiagramDefinition()
	 * @generated
	 */
	int DIAGRAM_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Drawer Definition Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION__DRAWER_DEFINITION_REF = 0;

	/**
	 * The feature id for the '<em><b>Diagram Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION__DIAGRAM_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Diagram Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Diagram Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagramGlobalToolService.impl.DrawerDefinitionImpl <em>Drawer Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagramGlobalToolService.impl.DrawerDefinitionImpl
	 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getDrawerDefinition()
	 * @generated
	 */
	int DRAWER_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Tool Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION__TOOL_REF = 1;

	/**
	 * The feature id for the '<em><b>Icon Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION__ICON_REFERENCE = 2;

	/**
	 * The number of structural features of the '<em>Drawer Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Drawer Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagramGlobalToolService.impl.ToolImpl <em>Tool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagramGlobalToolService.impl.ToolImpl
	 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getTool()
	 * @generated
	 */
	int TOOL = 3;

	/**
	 * The feature id for the '<em><b>Element Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL__ELEMENT_TYPES = 0;

	/**
	 * The feature id for the '<em><b>Is Edge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL__IS_EDGE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL__NAME = 2;

	/**
	 * The feature id for the '<em><b>Set Palette</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL__SET_PALETTE = 3;

	/**
	 * The feature id for the '<em><b>Set Popup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL__SET_POPUP = 4;

	/**
	 * The feature id for the '<em><b>Set Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL__SET_MENU = 5;

	/**
	 * The feature id for the '<em><b>Icon Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL__ICON_REFERENCE = 6;

	/**
	 * The number of structural features of the '<em>Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagramGlobalToolService.impl.ElementTypeImpl <em>Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagramGlobalToolService.impl.ElementTypeImpl
	 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getElementType()
	 * @generated
	 */
	int ELEMENT_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__ELEMENT_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagramGlobalToolService.impl.IconImpl <em>Icon</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagramGlobalToolService.impl.IconImpl
	 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getIcon()
	 * @generated
	 */
	int ICON = 5;

	/**
	 * The feature id for the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON__ICON_PATH = 0;

	/**
	 * The number of structural features of the '<em>Icon</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Icon</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link DiagramGlobalToolService.DiagramGlobalToolDefinition <em>Diagram Global Tool Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Global Tool Definition</em>'.
	 * @see DiagramGlobalToolService.DiagramGlobalToolDefinition
	 * @generated
	 */
	EClass getDiagramGlobalToolDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagramGlobalToolService.DiagramGlobalToolDefinition#getDiagramDefinitionRef <em>Diagram Definition Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagram Definition Ref</em>'.
	 * @see DiagramGlobalToolService.DiagramGlobalToolDefinition#getDiagramDefinitionRef()
	 * @see #getDiagramGlobalToolDefinition()
	 * @generated
	 */
	EReference getDiagramGlobalToolDefinition_DiagramDefinitionRef();

	/**
	 * Returns the meta object for class '{@link DiagramGlobalToolService.DiagramDefinition <em>Diagram Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Definition</em>'.
	 * @see DiagramGlobalToolService.DiagramDefinition
	 * @generated
	 */
	EClass getDiagramDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagramGlobalToolService.DiagramDefinition#getDrawerDefinitionRef <em>Drawer Definition Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Drawer Definition Ref</em>'.
	 * @see DiagramGlobalToolService.DiagramDefinition#getDrawerDefinitionRef()
	 * @see #getDiagramDefinition()
	 * @generated
	 */
	EReference getDiagramDefinition_DrawerDefinitionRef();

	/**
	 * Returns the meta object for the attribute '{@link DiagramGlobalToolService.DiagramDefinition#getDiagramType <em>Diagram Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Type</em>'.
	 * @see DiagramGlobalToolService.DiagramDefinition#getDiagramType()
	 * @see #getDiagramDefinition()
	 * @generated
	 */
	EAttribute getDiagramDefinition_DiagramType();

	/**
	 * Returns the meta object for class '{@link DiagramGlobalToolService.DrawerDefinition <em>Drawer Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drawer Definition</em>'.
	 * @see DiagramGlobalToolService.DrawerDefinition
	 * @generated
	 */
	EClass getDrawerDefinition();

	/**
	 * Returns the meta object for the attribute '{@link DiagramGlobalToolService.DrawerDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DiagramGlobalToolService.DrawerDefinition#getName()
	 * @see #getDrawerDefinition()
	 * @generated
	 */
	EAttribute getDrawerDefinition_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagramGlobalToolService.DrawerDefinition#getToolRef <em>Tool Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tool Ref</em>'.
	 * @see DiagramGlobalToolService.DrawerDefinition#getToolRef()
	 * @see #getDrawerDefinition()
	 * @generated
	 */
	EReference getDrawerDefinition_ToolRef();

	/**
	 * Returns the meta object for the containment reference '{@link DiagramGlobalToolService.DrawerDefinition#getIconReference <em>Icon Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icon Reference</em>'.
	 * @see DiagramGlobalToolService.DrawerDefinition#getIconReference()
	 * @see #getDrawerDefinition()
	 * @generated
	 */
	EReference getDrawerDefinition_IconReference();

	/**
	 * Returns the meta object for class '{@link DiagramGlobalToolService.Tool <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool</em>'.
	 * @see DiagramGlobalToolService.Tool
	 * @generated
	 */
	EClass getTool();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagramGlobalToolService.Tool#getElementTypes <em>Element Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element Types</em>'.
	 * @see DiagramGlobalToolService.Tool#getElementTypes()
	 * @see #getTool()
	 * @generated
	 */
	EReference getTool_ElementTypes();

	/**
	 * Returns the meta object for the attribute '{@link DiagramGlobalToolService.Tool#isIsEdge <em>Is Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Edge</em>'.
	 * @see DiagramGlobalToolService.Tool#isIsEdge()
	 * @see #getTool()
	 * @generated
	 */
	EAttribute getTool_IsEdge();

	/**
	 * Returns the meta object for the attribute '{@link DiagramGlobalToolService.Tool#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DiagramGlobalToolService.Tool#getName()
	 * @see #getTool()
	 * @generated
	 */
	EAttribute getTool_Name();

	/**
	 * Returns the meta object for the attribute '{@link DiagramGlobalToolService.Tool#isSetPalette <em>Set Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Set Palette</em>'.
	 * @see DiagramGlobalToolService.Tool#isSetPalette()
	 * @see #getTool()
	 * @generated
	 */
	EAttribute getTool_SetPalette();

	/**
	 * Returns the meta object for the attribute '{@link DiagramGlobalToolService.Tool#isSetPopup <em>Set Popup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Set Popup</em>'.
	 * @see DiagramGlobalToolService.Tool#isSetPopup()
	 * @see #getTool()
	 * @generated
	 */
	EAttribute getTool_SetPopup();

	/**
	 * Returns the meta object for the attribute '{@link DiagramGlobalToolService.Tool#isSetMenu <em>Set Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Set Menu</em>'.
	 * @see DiagramGlobalToolService.Tool#isSetMenu()
	 * @see #getTool()
	 * @generated
	 */
	EAttribute getTool_SetMenu();

	/**
	 * Returns the meta object for the containment reference '{@link DiagramGlobalToolService.Tool#getIconReference <em>Icon Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icon Reference</em>'.
	 * @see DiagramGlobalToolService.Tool#getIconReference()
	 * @see #getTool()
	 * @generated
	 */
	EReference getTool_IconReference();

	/**
	 * Returns the meta object for class '{@link DiagramGlobalToolService.ElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Type</em>'.
	 * @see DiagramGlobalToolService.ElementType
	 * @generated
	 */
	EClass getElementType();

	/**
	 * Returns the meta object for the attribute '{@link DiagramGlobalToolService.ElementType#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Type</em>'.
	 * @see DiagramGlobalToolService.ElementType#getElementType()
	 * @see #getElementType()
	 * @generated
	 */
	EAttribute getElementType_ElementType();

	/**
	 * Returns the meta object for class '{@link DiagramGlobalToolService.Icon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon</em>'.
	 * @see DiagramGlobalToolService.Icon
	 * @generated
	 */
	EClass getIcon();

	/**
	 * Returns the meta object for the attribute '{@link DiagramGlobalToolService.Icon#getIconPath <em>Icon Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Path</em>'.
	 * @see DiagramGlobalToolService.Icon#getIconPath()
	 * @see #getIcon()
	 * @generated
	 */
	EAttribute getIcon_IconPath();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagramGlobalToolServiceFactory getDiagramGlobalToolServiceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link DiagramGlobalToolService.impl.DiagramGlobalToolDefinitionImpl <em>Diagram Global Tool Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagramGlobalToolService.impl.DiagramGlobalToolDefinitionImpl
		 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getDiagramGlobalToolDefinition()
		 * @generated
		 */
		EClass DIAGRAM_GLOBAL_TOOL_DEFINITION = eINSTANCE.getDiagramGlobalToolDefinition();

		/**
		 * The meta object literal for the '<em><b>Diagram Definition Ref</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_GLOBAL_TOOL_DEFINITION__DIAGRAM_DEFINITION_REF = eINSTANCE.getDiagramGlobalToolDefinition_DiagramDefinitionRef();

		/**
		 * The meta object literal for the '{@link DiagramGlobalToolService.impl.DiagramDefinitionImpl <em>Diagram Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagramGlobalToolService.impl.DiagramDefinitionImpl
		 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getDiagramDefinition()
		 * @generated
		 */
		EClass DIAGRAM_DEFINITION = eINSTANCE.getDiagramDefinition();

		/**
		 * The meta object literal for the '<em><b>Drawer Definition Ref</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_DEFINITION__DRAWER_DEFINITION_REF = eINSTANCE.getDiagramDefinition_DrawerDefinitionRef();

		/**
		 * The meta object literal for the '<em><b>Diagram Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_DEFINITION__DIAGRAM_TYPE = eINSTANCE.getDiagramDefinition_DiagramType();

		/**
		 * The meta object literal for the '{@link DiagramGlobalToolService.impl.DrawerDefinitionImpl <em>Drawer Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagramGlobalToolService.impl.DrawerDefinitionImpl
		 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getDrawerDefinition()
		 * @generated
		 */
		EClass DRAWER_DEFINITION = eINSTANCE.getDrawerDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAWER_DEFINITION__NAME = eINSTANCE.getDrawerDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Tool Ref</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRAWER_DEFINITION__TOOL_REF = eINSTANCE.getDrawerDefinition_ToolRef();

		/**
		 * The meta object literal for the '<em><b>Icon Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRAWER_DEFINITION__ICON_REFERENCE = eINSTANCE.getDrawerDefinition_IconReference();

		/**
		 * The meta object literal for the '{@link DiagramGlobalToolService.impl.ToolImpl <em>Tool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagramGlobalToolService.impl.ToolImpl
		 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getTool()
		 * @generated
		 */
		EClass TOOL = eINSTANCE.getTool();

		/**
		 * The meta object literal for the '<em><b>Element Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOOL__ELEMENT_TYPES = eINSTANCE.getTool_ElementTypes();

		/**
		 * The meta object literal for the '<em><b>Is Edge</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL__IS_EDGE = eINSTANCE.getTool_IsEdge();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL__NAME = eINSTANCE.getTool_Name();

		/**
		 * The meta object literal for the '<em><b>Set Palette</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL__SET_PALETTE = eINSTANCE.getTool_SetPalette();

		/**
		 * The meta object literal for the '<em><b>Set Popup</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL__SET_POPUP = eINSTANCE.getTool_SetPopup();

		/**
		 * The meta object literal for the '<em><b>Set Menu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL__SET_MENU = eINSTANCE.getTool_SetMenu();

		/**
		 * The meta object literal for the '<em><b>Icon Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOOL__ICON_REFERENCE = eINSTANCE.getTool_IconReference();

		/**
		 * The meta object literal for the '{@link DiagramGlobalToolService.impl.ElementTypeImpl <em>Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagramGlobalToolService.impl.ElementTypeImpl
		 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getElementType()
		 * @generated
		 */
		EClass ELEMENT_TYPE = eINSTANCE.getElementType();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_TYPE__ELEMENT_TYPE = eINSTANCE.getElementType_ElementType();

		/**
		 * The meta object literal for the '{@link DiagramGlobalToolService.impl.IconImpl <em>Icon</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagramGlobalToolService.impl.IconImpl
		 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getIcon()
		 * @generated
		 */
		EClass ICON = eINSTANCE.getIcon();

		/**
		 * The meta object literal for the '<em><b>Icon Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICON__ICON_PATH = eINSTANCE.getIcon_IconPath();

	}

} //DiagramGlobalToolServicePackage
