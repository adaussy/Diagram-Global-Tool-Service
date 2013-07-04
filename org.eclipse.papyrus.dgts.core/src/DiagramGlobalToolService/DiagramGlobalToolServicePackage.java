/**
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
	 * The feature id for the '<em><b>Tool Element Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION__TOOL_ELEMENT_REF = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION__NAME = 1;

	/**
	 * The number of structural features of the '<em>Drawer Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Drawer Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagramGlobalToolService.impl.ToolElementImpl <em>Tool Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagramGlobalToolService.impl.ToolElementImpl
	 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getToolElement()
	 * @generated
	 */
	int TOOL_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__TOOL = 0;

	/**
	 * The number of structural features of the '<em>Tool Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Tool Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the containment reference list '{@link DiagramGlobalToolService.DrawerDefinition#getToolElementRef <em>Tool Element Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tool Element Ref</em>'.
	 * @see DiagramGlobalToolService.DrawerDefinition#getToolElementRef()
	 * @see #getDrawerDefinition()
	 * @generated
	 */
	EReference getDrawerDefinition_ToolElementRef();

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
	 * Returns the meta object for class '{@link DiagramGlobalToolService.ToolElement <em>Tool Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool Element</em>'.
	 * @see DiagramGlobalToolService.ToolElement
	 * @generated
	 */
	EClass getToolElement();

	/**
	 * Returns the meta object for the attribute '{@link DiagramGlobalToolService.ToolElement#getTool <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tool</em>'.
	 * @see DiagramGlobalToolService.ToolElement#getTool()
	 * @see #getToolElement()
	 * @generated
	 */
	EAttribute getToolElement_Tool();

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
		 * The meta object literal for the '<em><b>Tool Element Ref</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRAWER_DEFINITION__TOOL_ELEMENT_REF = eINSTANCE.getDrawerDefinition_ToolElementRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAWER_DEFINITION__NAME = eINSTANCE.getDrawerDefinition_Name();

		/**
		 * The meta object literal for the '{@link DiagramGlobalToolService.impl.ToolElementImpl <em>Tool Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagramGlobalToolService.impl.ToolElementImpl
		 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getToolElement()
		 * @generated
		 */
		EClass TOOL_ELEMENT = eINSTANCE.getToolElement();

		/**
		 * The meta object literal for the '<em><b>Tool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL_ELEMENT__TOOL = eINSTANCE.getToolElement_Tool();

	}

} //DiagramGlobalToolServicePackage
