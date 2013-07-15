/**
 */
package DiagramGlobalToolService;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage
 * @generated
 */
public interface DiagramGlobalToolServiceFactory extends EFactory {
	/**
         * The singleton instance of the factory.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	DiagramGlobalToolServiceFactory eINSTANCE = DiagramGlobalToolService.impl.DiagramGlobalToolServiceFactoryImpl.init();

	/**
         * Returns a new object of class '<em>Diagram Global Tool Definition</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return a new object of class '<em>Diagram Global Tool Definition</em>'.
         * @generated
         */
	DiagramGlobalToolDefinition createDiagramGlobalToolDefinition();

	/**
         * Returns a new object of class '<em>Diagram Definition</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return a new object of class '<em>Diagram Definition</em>'.
         * @generated
         */
	DiagramDefinition createDiagramDefinition();

	/**
         * Returns a new object of class '<em>Drawer Definition</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return a new object of class '<em>Drawer Definition</em>'.
         * @generated
         */
	DrawerDefinition createDrawerDefinition();

	/**
         * Returns a new object of class '<em>Tool Element</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return a new object of class '<em>Tool Element</em>'.
         * @generated
         */
	ToolElement createToolElement();

	/**
         * Returns the package supported by this factory.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return the package supported by this factory.
         * @generated
         */
	DiagramGlobalToolServicePackage getDiagramGlobalToolServicePackage();

} //DiagramGlobalToolServiceFactory
