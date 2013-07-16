/**
 */
package DiagramGlobalToolService.impl;

import DiagramGlobalToolService.AbstractTool;
import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DiagramGlobalToolServiceFactory;
import DiagramGlobalToolService.DiagramGlobalToolServicePackage;
import DiagramGlobalToolService.DrawerDefinition;
import DiagramGlobalToolService.ElementType;
import DiagramGlobalToolService.Tool;
import DiagramGlobalToolService.ToolMetaModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
public class DiagramGlobalToolServicePackageImpl extends EPackageImpl implements DiagramGlobalToolServicePackage {
        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private EClass diagramGlobalToolDefinitionEClass = null;

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
        private EClass drawerDefinitionEClass = null;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private EClass abstractToolEClass = null;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private EClass toolEClass = null;

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
        private EClass toolMetaModelEClass = null;

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
         * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#eNS_URI
         * @see #init()
         * @generated
         */
        private DiagramGlobalToolServicePackageImpl() {
                super(eNS_URI, DiagramGlobalToolServiceFactory.eINSTANCE);
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
         * <p>This method is used to initialize {@link DiagramGlobalToolServicePackage#eINSTANCE} when that field is accessed.
         * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #eNS_URI
         * @see #createPackageContents()
         * @see #initializePackageContents()
         * @generated
         */
        public static DiagramGlobalToolServicePackage init() {
                if (isInited) return (DiagramGlobalToolServicePackage)EPackage.Registry.INSTANCE.getEPackage(DiagramGlobalToolServicePackage.eNS_URI);

                // Obtain or create and register package
                DiagramGlobalToolServicePackageImpl theDiagramGlobalToolServicePackage = (DiagramGlobalToolServicePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DiagramGlobalToolServicePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DiagramGlobalToolServicePackageImpl());

                isInited = true;

                // Initialize simple dependencies
                EcorePackage.eINSTANCE.eClass();

                // Create package meta-data objects
                theDiagramGlobalToolServicePackage.createPackageContents();

                // Initialize created meta-data
                theDiagramGlobalToolServicePackage.initializePackageContents();

                // Mark meta-data to indicate it can't be changed
                theDiagramGlobalToolServicePackage.freeze();

  
                // Update the registry and return the package
                EPackage.Registry.INSTANCE.put(DiagramGlobalToolServicePackage.eNS_URI, theDiagramGlobalToolServicePackage);
                return theDiagramGlobalToolServicePackage;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EClass getDiagramGlobalToolDefinition() {
                return diagramGlobalToolDefinitionEClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EReference getDiagramGlobalToolDefinition_DiagramDefinitionRef() {
                return (EReference)diagramGlobalToolDefinitionEClass.getEStructuralFeatures().get(0);
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
        public EReference getDiagramDefinition_DrawerDefinitionRef() {
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
        public EClass getDrawerDefinition() {
                return drawerDefinitionEClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EReference getDrawerDefinition_AbstractToolRef() {
                return (EReference)drawerDefinitionEClass.getEStructuralFeatures().get(0);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EAttribute getDrawerDefinition_Name() {
                return (EAttribute)drawerDefinitionEClass.getEStructuralFeatures().get(1);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EClass getAbstractTool() {
                return abstractToolEClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EAttribute getAbstractTool_Name() {
                return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(0);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EAttribute getAbstractTool_IsEdge() {
                return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(1);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EClass getTool() {
                return toolEClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EReference getTool_ElementTypes() {
                return (EReference)toolEClass.getEStructuralFeatures().get(0);
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
        public EAttribute getElementType_ElementType() {
                return (EAttribute)elementTypeEClass.getEStructuralFeatures().get(0);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EClass getToolMetaModel() {
                return toolMetaModelEClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EAttribute getToolMetaModel_MetaModel() {
                return (EAttribute)toolMetaModelEClass.getEStructuralFeatures().get(0);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public DiagramGlobalToolServiceFactory getDiagramGlobalToolServiceFactory() {
                return (DiagramGlobalToolServiceFactory)getEFactoryInstance();
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
                diagramGlobalToolDefinitionEClass = createEClass(DIAGRAM_GLOBAL_TOOL_DEFINITION);
                createEReference(diagramGlobalToolDefinitionEClass, DIAGRAM_GLOBAL_TOOL_DEFINITION__DIAGRAM_DEFINITION_REF);

                diagramDefinitionEClass = createEClass(DIAGRAM_DEFINITION);
                createEReference(diagramDefinitionEClass, DIAGRAM_DEFINITION__DRAWER_DEFINITION_REF);
                createEAttribute(diagramDefinitionEClass, DIAGRAM_DEFINITION__DIAGRAM_TYPE);

                drawerDefinitionEClass = createEClass(DRAWER_DEFINITION);
                createEReference(drawerDefinitionEClass, DRAWER_DEFINITION__ABSTRACT_TOOL_REF);
                createEAttribute(drawerDefinitionEClass, DRAWER_DEFINITION__NAME);

                abstractToolEClass = createEClass(ABSTRACT_TOOL);
                createEAttribute(abstractToolEClass, ABSTRACT_TOOL__NAME);
                createEAttribute(abstractToolEClass, ABSTRACT_TOOL__IS_EDGE);

                toolEClass = createEClass(TOOL);
                createEReference(toolEClass, TOOL__ELEMENT_TYPES);

                elementTypeEClass = createEClass(ELEMENT_TYPE);
                createEAttribute(elementTypeEClass, ELEMENT_TYPE__ELEMENT_TYPE);

                toolMetaModelEClass = createEClass(TOOL_META_MODEL);
                createEAttribute(toolMetaModelEClass, TOOL_META_MODEL__META_MODEL);
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
                toolEClass.getESuperTypes().add(this.getAbstractTool());
                toolMetaModelEClass.getESuperTypes().add(this.getAbstractTool());

                // Initialize classes, features, and operations; add parameters
                initEClass(diagramGlobalToolDefinitionEClass, DiagramGlobalToolDefinition.class, "DiagramGlobalToolDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEReference(getDiagramGlobalToolDefinition_DiagramDefinitionRef(), this.getDiagramDefinition(), null, "DiagramDefinitionRef", null, 0, -1, DiagramGlobalToolDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                initEClass(diagramDefinitionEClass, DiagramDefinition.class, "DiagramDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEReference(getDiagramDefinition_DrawerDefinitionRef(), this.getDrawerDefinition(), null, "DrawerDefinitionRef", null, 0, -1, DiagramDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getDiagramDefinition_DiagramType(), theEcorePackage.getEString(), "DiagramType", null, 1, 1, DiagramDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                initEClass(drawerDefinitionEClass, DrawerDefinition.class, "DrawerDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEReference(getDrawerDefinition_AbstractToolRef(), this.getAbstractTool(), null, "AbstractToolRef", null, 0, -1, DrawerDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getDrawerDefinition_Name(), theEcorePackage.getEString(), "Name", null, 0, 1, DrawerDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                initEClass(abstractToolEClass, AbstractTool.class, "AbstractTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEAttribute(getAbstractTool_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getAbstractTool_IsEdge(), theEcorePackage.getEBoolean(), "isEdge", "false", 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                initEClass(toolEClass, Tool.class, "Tool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEReference(getTool_ElementTypes(), this.getElementType(), null, "elementTypes", null, 0, -1, Tool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                initEClass(elementTypeEClass, ElementType.class, "ElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEAttribute(getElementType_ElementType(), theEcorePackage.getEString(), "elementType", "", 0, 1, ElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                initEClass(toolMetaModelEClass, ToolMetaModel.class, "ToolMetaModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEAttribute(getToolMetaModel_MetaModel(), theEcorePackage.getEString(), "metaModel", null, 0, 1, ToolMetaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                // Create resource
                createResource(eNS_URI);
        }

} //DiagramGlobalToolServicePackageImpl
