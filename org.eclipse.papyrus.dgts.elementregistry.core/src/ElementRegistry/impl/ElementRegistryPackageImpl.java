/**
 */
package ElementRegistry.impl;

import ElementRegistry.Context;
import ElementRegistry.DiagramDefinition;
import ElementRegistry.EClassDefinition;
import ElementRegistry.ElementRegistryFactory;
import ElementRegistry.ElementRegistryPackage;
import ElementRegistry.ElementType;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ElementRegistryPackageImpl extends EPackageImpl implements ElementRegistryPackage {
        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private EClass registryEClass = null;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private EClass diagramDefinitionEClass = null;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private EClass eClassDefinitionEClass = null;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private EClass elementTypeEClass = null;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private EEnum contextEEnum = null;

        /**
         * Creates an instance of the model <b>Package</b>, registered with
         * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
         * package URI value.
         * <p>Note: the correct way to create the package is via the static
         * factory method {@link #init init()}, which also performs
         * initialization of the package, or returns the registered package,
         * if one already exists.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.emf.ecore.EPackage.Registry
         * @see ElementRegistry.ElementRegistryPackage#eNS_URI
         * @see #init()
         * @generated
         */
        private ElementRegistryPackageImpl() {
                super(eNS_URI, ElementRegistryFactory.eINSTANCE);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private static boolean isInited = false;

        /**
         * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
         * 
         * <p>This method is used to initialize {@link ElementRegistryPackage#eINSTANCE} when that field is accessed.
         * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #eNS_URI
         * @see #createPackageContents()
         * @see #initializePackageContents()
         * @generated
         */
        public static ElementRegistryPackage init() {
                if (isInited) return (ElementRegistryPackage)EPackage.Registry.INSTANCE.getEPackage(ElementRegistryPackage.eNS_URI);

                // Obtain or create and register package
                ElementRegistryPackageImpl theElementRegistryPackage = (ElementRegistryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ElementRegistryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ElementRegistryPackageImpl());

                isInited = true;

                // Initialize simple dependencies
                EcorePackage.eINSTANCE.eClass();

                // Create package meta-data objects
                theElementRegistryPackage.createPackageContents();

                // Initialize created meta-data
                theElementRegistryPackage.initializePackageContents();

                // Mark meta-data to indicate it can't be changed
                theElementRegistryPackage.freeze();

  
                // Update the registry and return the package
                EPackage.Registry.INSTANCE.put(ElementRegistryPackage.eNS_URI, theElementRegistryPackage);
                return theElementRegistryPackage;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EClass getRegistry() {
                return registryEClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EReference getRegistry_RefDiagrams() {
                return (EReference)registryEClass.getEStructuralFeatures().get(0);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EClass getDiagramDefinition() {
                return diagramDefinitionEClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EReference getDiagramDefinition_RefEClass() {
                return (EReference)diagramDefinitionEClass.getEStructuralFeatures().get(0);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EAttribute getDiagramDefinition_DiagramType() {
                return (EAttribute)diagramDefinitionEClass.getEStructuralFeatures().get(1);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EClass getEClassDefinition() {
                return eClassDefinitionEClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EReference getEClassDefinition_RefElementTypes() {
                return (EReference)eClassDefinitionEClass.getEStructuralFeatures().get(0);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EReference getEClassDefinition_EClass() {
                return (EReference)eClassDefinitionEClass.getEStructuralFeatures().get(1);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EClass getElementType() {
                return elementTypeEClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EAttribute getElementType_ElementTypeID() {
                return (EAttribute)elementTypeEClass.getEStructuralFeatures().get(0);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EAttribute getElementType_Description() {
                return (EAttribute)elementTypeEClass.getEStructuralFeatures().get(1);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EAttribute getElementType_Context() {
                return (EAttribute)elementTypeEClass.getEStructuralFeatures().get(2);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EEnum getContext() {
                return contextEEnum;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public ElementRegistryFactory getElementRegistryFactory() {
                return (ElementRegistryFactory)getEFactoryInstance();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private boolean isCreated = false;

        /**
         * Creates the meta-model objects for the package.  This method is
         * guarded to have no affect on any invocation but its first.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void createPackageContents() {
                if (isCreated) return;
                isCreated = true;

                // Create classes and their features
                registryEClass = createEClass(REGISTRY);
                createEReference(registryEClass, REGISTRY__REF_DIAGRAMS);

                diagramDefinitionEClass = createEClass(DIAGRAM_DEFINITION);
                createEReference(diagramDefinitionEClass, DIAGRAM_DEFINITION__REF_ECLASS);
                createEAttribute(diagramDefinitionEClass, DIAGRAM_DEFINITION__DIAGRAM_TYPE);

                eClassDefinitionEClass = createEClass(ECLASS_DEFINITION);
                createEReference(eClassDefinitionEClass, ECLASS_DEFINITION__REF_ELEMENT_TYPES);
                createEReference(eClassDefinitionEClass, ECLASS_DEFINITION__ECLASS);

                elementTypeEClass = createEClass(ELEMENT_TYPE);
                createEAttribute(elementTypeEClass, ELEMENT_TYPE__ELEMENT_TYPE_ID);
                createEAttribute(elementTypeEClass, ELEMENT_TYPE__DESCRIPTION);
                createEAttribute(elementTypeEClass, ELEMENT_TYPE__CONTEXT);

                // Create enums
                contextEEnum = createEEnum(CONTEXT);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private boolean isInitialized = false;

        /**
         * Complete the initialization of the package and its meta-model.  This
         * method is guarded to have no affect on any invocation but its first.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void initializePackageContents() {
                if (isInitialized) return;
                isInitialized = true;

                // Initialize package
                setName(eNAME);
                setNsPrefix(eNS_PREFIX);
                setNsURI(eNS_URI);

                // Obtain other dependent packages
                EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

                // Create type parameters

                // Set bounds for type parameters

                // Add supertypes to classes

                // Initialize classes, features, and operations; add parameters
                initEClass(registryEClass, ElementRegistry.Registry.class, "Registry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEReference(getRegistry_RefDiagrams(), this.getDiagramDefinition(), null, "refDiagrams", null, 0, -1, ElementRegistry.Registry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                initEClass(diagramDefinitionEClass, DiagramDefinition.class, "DiagramDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEReference(getDiagramDefinition_RefEClass(), this.getEClassDefinition(), null, "refEClass", null, 0, -1, DiagramDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getDiagramDefinition_DiagramType(), ecorePackage.getEString(), "diagramType", null, 0, 1, DiagramDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                initEClass(eClassDefinitionEClass, EClassDefinition.class, "EClassDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEReference(getEClassDefinition_RefElementTypes(), this.getElementType(), null, "refElementTypes", null, 0, -1, EClassDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getEClassDefinition_EClass(), theEcorePackage.getEClass(), null, "eClass", null, 0, 1, EClassDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                initEClass(elementTypeEClass, ElementType.class, "ElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEAttribute(getElementType_ElementTypeID(), ecorePackage.getEString(), "elementTypeID", null, 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getElementType_Description(), ecorePackage.getEString(), "description", null, 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getElementType_Context(), this.getContext(), "context", null, 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                // Initialize enums and add enum literals
                initEEnum(contextEEnum, Context.class, "Context");
                addEEnumLiteral(contextEEnum, Context.DIAGRAM);
                addEEnumLiteral(contextEEnum, Context.MODEL_EXPLORER);
                addEEnumLiteral(contextEEnum, Context.DIAGRAM_AND_MODEL_EXPLORER);

                // Create resource
                createResource(eNS_URI);
        }

} //ElementRegistryPackageImpl
