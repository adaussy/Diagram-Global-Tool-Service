/**
 */
package DiagramGlobalToolService;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Drawer Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.DrawerDefinition#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link DiagramGlobalToolService.DrawerDefinition#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDrawerDefinition()
 * @model
 * @generated
 */
public interface DrawerDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>EReference0</b></em>' containment reference list.
	 * The list contents are of type {@link DiagramGlobalToolService.ToolElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference0</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference0</em>' containment reference list.
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDrawerDefinition_EReference0()
	 * @model containment="true"
	 * @generated
	 */
	EList<ToolElement> getEReference0();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDrawerDefinition_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link DiagramGlobalToolService.DrawerDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // DrawerDefinition
