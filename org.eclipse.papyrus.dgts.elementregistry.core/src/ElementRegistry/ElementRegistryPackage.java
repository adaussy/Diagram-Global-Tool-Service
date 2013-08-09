/**
 */
package ElementRegistry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see ElementRegistry.ElementRegistryFactory
 * @model kind="package"
 * @generated
 */
public interface ElementRegistryPackage extends EPackage {
        /**
         * The package name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        String eNAME = "ElementRegistry";

        /**
         * The package namespace URI.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        String eNS_URI = "http://ElementRegistry/1.0";

        /**
         * The package namespace name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        String eNS_PREFIX = "ElementRegistry";

        /**
         * The singleton instance of the package.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        ElementRegistryPackage eINSTANCE = ElementRegistry.impl.ElementRegistryPackageImpl.init();

        /**
         * The meta object id for the '{@link ElementRegistry.impl.RegistryImpl <em>Registry</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see ElementRegistry.impl.RegistryImpl
         * @see ElementRegistry.impl.ElementRegistryPackageImpl#getRegistry()
         * @generated
         */
        int REGISTRY = 0;

        /**
         * The feature id for the '<em><b>Ref Diagrams</b></em>' containment reference list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int REGISTRY__REF_DIAGRAMS = 0;

        /**
         * The number of structural features of the '<em>Registry</em>' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int REGISTRY_FEATURE_COUNT = 1;

        /**
         * The number of operations of the '<em>Registry</em>' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int REGISTRY_OPERATION_COUNT = 0;

        /**
         * The meta object id for the '{@link ElementRegistry.impl.DiagramDefinitionImpl <em>Diagram Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see ElementRegistry.impl.DiagramDefinitionImpl
         * @see ElementRegistry.impl.ElementRegistryPackageImpl#getDiagramDefinition()
         * @generated
         */
        int DIAGRAM_DEFINITION = 1;

        /**
         * The feature id for the '<em><b>Ref EClass</b></em>' containment reference list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int DIAGRAM_DEFINITION__REF_ECLASS = 0;

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
         * The meta object id for the '{@link ElementRegistry.impl.EClassDefinitionImpl <em>EClass Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see ElementRegistry.impl.EClassDefinitionImpl
         * @see ElementRegistry.impl.ElementRegistryPackageImpl#getEClassDefinition()
         * @generated
         */
        int ECLASS_DEFINITION = 2;

        /**
         * The feature id for the '<em><b>Ref Element Types</b></em>' containment reference list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int ECLASS_DEFINITION__REF_ELEMENT_TYPES = 0;

        /**
         * The feature id for the '<em><b>EClass</b></em>' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int ECLASS_DEFINITION__ECLASS = 1;

        /**
         * The number of structural features of the '<em>EClass Definition</em>' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int ECLASS_DEFINITION_FEATURE_COUNT = 2;

        /**
         * The number of operations of the '<em>EClass Definition</em>' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int ECLASS_DEFINITION_OPERATION_COUNT = 0;

        /**
         * The meta object id for the '{@link ElementRegistry.impl.ElementTypeImpl <em>Element Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see ElementRegistry.impl.ElementTypeImpl
         * @see ElementRegistry.impl.ElementRegistryPackageImpl#getElementType()
         * @generated
         */
        int ELEMENT_TYPE = 3;

        /**
         * The feature id for the '<em><b>Element Type ID</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int ELEMENT_TYPE__ELEMENT_TYPE_ID = 0;

        /**
         * The feature id for the '<em><b>Description</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int ELEMENT_TYPE__DESCRIPTION = 1;

        /**
         * The feature id for the '<em><b>Context</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int ELEMENT_TYPE__CONTEXT = 2;

        /**
         * The number of structural features of the '<em>Element Type</em>' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int ELEMENT_TYPE_FEATURE_COUNT = 3;

        /**
         * The number of operations of the '<em>Element Type</em>' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         * @ordered
         */
        int ELEMENT_TYPE_OPERATION_COUNT = 0;

        /**
         * The meta object id for the '{@link ElementRegistry.Context <em>Context</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see ElementRegistry.Context
         * @see ElementRegistry.impl.ElementRegistryPackageImpl#getContext()
         * @generated
         */
        int CONTEXT = 4;


        /**
         * Returns the meta object for class '{@link ElementRegistry.Registry <em>Registry</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for class '<em>Registry</em>'.
         * @see ElementRegistry.Registry
         * @generated
         */
        EClass getRegistry();

        /**
         * Returns the meta object for the containment reference list '{@link ElementRegistry.Registry#getRefDiagrams <em>Ref Diagrams</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the containment reference list '<em>Ref Diagrams</em>'.
         * @see ElementRegistry.Registry#getRefDiagrams()
         * @see #getRegistry()
         * @generated
         */
        EReference getRegistry_RefDiagrams();

        /**
         * Returns the meta object for class '{@link ElementRegistry.DiagramDefinition <em>Diagram Definition</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for class '<em>Diagram Definition</em>'.
         * @see ElementRegistry.DiagramDefinition
         * @generated
         */
        EClass getDiagramDefinition();

        /**
         * Returns the meta object for the containment reference list '{@link ElementRegistry.DiagramDefinition#getRefEClass <em>Ref EClass</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the containment reference list '<em>Ref EClass</em>'.
         * @see ElementRegistry.DiagramDefinition#getRefEClass()
         * @see #getDiagramDefinition()
         * @generated
         */
        EReference getDiagramDefinition_RefEClass();

        /**
         * Returns the meta object for the attribute '{@link ElementRegistry.DiagramDefinition#getDiagramType <em>Diagram Type</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the attribute '<em>Diagram Type</em>'.
         * @see ElementRegistry.DiagramDefinition#getDiagramType()
         * @see #getDiagramDefinition()
         * @generated
         */
        EAttribute getDiagramDefinition_DiagramType();

        /**
         * Returns the meta object for class '{@link ElementRegistry.EClassDefinition <em>EClass Definition</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for class '<em>EClass Definition</em>'.
         * @see ElementRegistry.EClassDefinition
         * @generated
         */
        EClass getEClassDefinition();

        /**
         * Returns the meta object for the containment reference list '{@link ElementRegistry.EClassDefinition#getRefElementTypes <em>Ref Element Types</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the containment reference list '<em>Ref Element Types</em>'.
         * @see ElementRegistry.EClassDefinition#getRefElementTypes()
         * @see #getEClassDefinition()
         * @generated
         */
        EReference getEClassDefinition_RefElementTypes();

        /**
         * Returns the meta object for the reference '{@link ElementRegistry.EClassDefinition#getEClass <em>EClass</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the reference '<em>EClass</em>'.
         * @see ElementRegistry.EClassDefinition#getEClass()
         * @see #getEClassDefinition()
         * @generated
         */
        EReference getEClassDefinition_EClass();

        /**
         * Returns the meta object for class '{@link ElementRegistry.ElementType <em>Element Type</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for class '<em>Element Type</em>'.
         * @see ElementRegistry.ElementType
         * @generated
         */
        EClass getElementType();

        /**
         * Returns the meta object for the attribute '{@link ElementRegistry.ElementType#getElementTypeID <em>Element Type ID</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the attribute '<em>Element Type ID</em>'.
         * @see ElementRegistry.ElementType#getElementTypeID()
         * @see #getElementType()
         * @generated
         */
        EAttribute getElementType_ElementTypeID();

        /**
         * Returns the meta object for the attribute '{@link ElementRegistry.ElementType#getDescription <em>Description</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the attribute '<em>Description</em>'.
         * @see ElementRegistry.ElementType#getDescription()
         * @see #getElementType()
         * @generated
         */
        EAttribute getElementType_Description();

        /**
         * Returns the meta object for the attribute '{@link ElementRegistry.ElementType#getContext <em>Context</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for the attribute '<em>Context</em>'.
         * @see ElementRegistry.ElementType#getContext()
         * @see #getElementType()
         * @generated
         */
        EAttribute getElementType_Context();

        /**
         * Returns the meta object for enum '{@link ElementRegistry.Context <em>Context</em>}'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the meta object for enum '<em>Context</em>'.
         * @see ElementRegistry.Context
         * @generated
         */
        EEnum getContext();

        /**
         * Returns the factory that creates the instances of the model.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the factory that creates the instances of the model.
         * @generated
         */
        ElementRegistryFactory getElementRegistryFactory();

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
                 * The meta object literal for the '{@link ElementRegistry.impl.RegistryImpl <em>Registry</em>}' class.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see ElementRegistry.impl.RegistryImpl
                 * @see ElementRegistry.impl.ElementRegistryPackageImpl#getRegistry()
                 * @generated
                 */
                EClass REGISTRY = eINSTANCE.getRegistry();

                /**
                 * The meta object literal for the '<em><b>Ref Diagrams</b></em>' containment reference list feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EReference REGISTRY__REF_DIAGRAMS = eINSTANCE.getRegistry_RefDiagrams();

                /**
                 * The meta object literal for the '{@link ElementRegistry.impl.DiagramDefinitionImpl <em>Diagram Definition</em>}' class.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see ElementRegistry.impl.DiagramDefinitionImpl
                 * @see ElementRegistry.impl.ElementRegistryPackageImpl#getDiagramDefinition()
                 * @generated
                 */
                EClass DIAGRAM_DEFINITION = eINSTANCE.getDiagramDefinition();

                /**
                 * The meta object literal for the '<em><b>Ref EClass</b></em>' containment reference list feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EReference DIAGRAM_DEFINITION__REF_ECLASS = eINSTANCE.getDiagramDefinition_RefEClass();

                /**
                 * The meta object literal for the '<em><b>Diagram Type</b></em>' attribute feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EAttribute DIAGRAM_DEFINITION__DIAGRAM_TYPE = eINSTANCE.getDiagramDefinition_DiagramType();

                /**
                 * The meta object literal for the '{@link ElementRegistry.impl.EClassDefinitionImpl <em>EClass Definition</em>}' class.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see ElementRegistry.impl.EClassDefinitionImpl
                 * @see ElementRegistry.impl.ElementRegistryPackageImpl#getEClassDefinition()
                 * @generated
                 */
                EClass ECLASS_DEFINITION = eINSTANCE.getEClassDefinition();

                /**
                 * The meta object literal for the '<em><b>Ref Element Types</b></em>' containment reference list feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EReference ECLASS_DEFINITION__REF_ELEMENT_TYPES = eINSTANCE.getEClassDefinition_RefElementTypes();

                /**
                 * The meta object literal for the '<em><b>EClass</b></em>' reference feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EReference ECLASS_DEFINITION__ECLASS = eINSTANCE.getEClassDefinition_EClass();

                /**
                 * The meta object literal for the '{@link ElementRegistry.impl.ElementTypeImpl <em>Element Type</em>}' class.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see ElementRegistry.impl.ElementTypeImpl
                 * @see ElementRegistry.impl.ElementRegistryPackageImpl#getElementType()
                 * @generated
                 */
                EClass ELEMENT_TYPE = eINSTANCE.getElementType();

                /**
                 * The meta object literal for the '<em><b>Element Type ID</b></em>' attribute feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EAttribute ELEMENT_TYPE__ELEMENT_TYPE_ID = eINSTANCE.getElementType_ElementTypeID();

                /**
                 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EAttribute ELEMENT_TYPE__DESCRIPTION = eINSTANCE.getElementType_Description();

                /**
                 * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                EAttribute ELEMENT_TYPE__CONTEXT = eINSTANCE.getElementType_Context();

                /**
                 * The meta object literal for the '{@link ElementRegistry.Context <em>Context</em>}' enum.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see ElementRegistry.Context
                 * @see ElementRegistry.impl.ElementRegistryPackageImpl#getContext()
                 * @generated
                 */
                EEnum CONTEXT = eINSTANCE.getContext();

        }

} //ElementRegistryPackage
