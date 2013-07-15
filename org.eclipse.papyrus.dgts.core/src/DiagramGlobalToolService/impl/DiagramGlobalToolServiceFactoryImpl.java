/**
 */
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
                        case DiagramGlobalToolServicePackage.TOOL_ELEMENT: return createToolElement();
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
	public ToolElement createToolElement() {
                ToolElementImpl toolElement = new ToolElementImpl();
                return toolElement;
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
