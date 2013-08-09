/**
 */
package ElementRegistry.impl;

import ElementRegistry.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class ElementRegistryFactoryImpl extends EFactoryImpl implements ElementRegistryFactory {
        /**
         * Creates the default factory implementation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static ElementRegistryFactory init() {
                try {
                        ElementRegistryFactory theElementRegistryFactory = (ElementRegistryFactory)EPackage.Registry.INSTANCE.getEFactory(ElementRegistryPackage.eNS_URI);
                        if (theElementRegistryFactory != null) {
                                return theElementRegistryFactory;
                        }
                }
                catch (Exception exception) {
                        EcorePlugin.INSTANCE.log(exception);
                }
                return new ElementRegistryFactoryImpl();
        }

        /**
         * Creates an instance of the factory.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public ElementRegistryFactoryImpl() {
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
                        case ElementRegistryPackage.REGISTRY: return createRegistry();
                        case ElementRegistryPackage.DIAGRAM_DEFINITION: return createDiagramDefinition();
                        case ElementRegistryPackage.ECLASS_DEFINITION: return createEClassDefinition();
                        case ElementRegistryPackage.ELEMENT_TYPE: return createElementType();
                        default:
                                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
                }
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object createFromString(EDataType eDataType, String initialValue) {
                switch (eDataType.getClassifierID()) {
                        case ElementRegistryPackage.CONTEXT:
                                return createContextFromString(eDataType, initialValue);
                        default:
                                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
                }
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public String convertToString(EDataType eDataType, Object instanceValue) {
                switch (eDataType.getClassifierID()) {
                        case ElementRegistryPackage.CONTEXT:
                                return convertContextToString(eDataType, instanceValue);
                        default:
                                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
                }
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Registry createRegistry() {
                RegistryImpl registry = new RegistryImpl();
                return registry;
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
        public EClassDefinition createEClassDefinition() {
                EClassDefinitionImpl eClassDefinition = new EClassDefinitionImpl();
                return eClassDefinition;
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
        public Context createContextFromString(EDataType eDataType, String initialValue) {
                Context result = Context.get(initialValue);
                if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
                return result;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public String convertContextToString(EDataType eDataType, Object instanceValue) {
                return instanceValue == null ? null : instanceValue.toString();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public ElementRegistryPackage getElementRegistryPackage() {
                return (ElementRegistryPackage)getEPackage();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @deprecated
         * @generated
         */
        @Deprecated
        public static ElementRegistryPackage getPackage() {
                return ElementRegistryPackage.eINSTANCE;
        }

} //ElementRegistryFactoryImpl
