/**
 */
package DiagramGlobalToolService;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.Tool#getElementTypes <em>Element Types</em>}</li>
 *   <li>{@link DiagramGlobalToolService.Tool#isIsEdge <em>Is Edge</em>}</li>
 *   <li>{@link DiagramGlobalToolService.Tool#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getTool()
 * @model
 * @generated
 */
public interface Tool extends EObject {
        /**
	 * Returns the value of the '<em><b>Element Types</b></em>' containment reference list.
	 * The list contents are of type {@link DiagramGlobalToolService.ElementType}.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Element Types</em>' reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Types</em>' containment reference list.
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getTool_ElementTypes()
	 * @model containment="true"
	 * @generated
	 */
        EList<ElementType> getElementTypes();

								/**
	 * Returns the value of the '<em><b>Is Edge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Edge</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Edge</em>' attribute.
	 * @see #setIsEdge(boolean)
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getTool_IsEdge()
	 * @model
	 * @generated
	 */
	boolean isIsEdge();

								/**
	 * Sets the value of the '{@link DiagramGlobalToolService.Tool#isIsEdge <em>Is Edge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Edge</em>' attribute.
	 * @see #isIsEdge()
	 * @generated
	 */
	void setIsEdge(boolean value);

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
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getTool_Name()
	 * @model
	 * @generated
	 */
	String getName();

								/**
	 * Sets the value of the '{@link DiagramGlobalToolService.Tool#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Tool
