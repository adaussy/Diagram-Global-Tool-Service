/**
 */
package DiagramGlobalToolService;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.ElementType#getElementType <em>Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getElementType()
 * @model
 * @generated
 */
public interface ElementType extends EObject {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' attribute.
	 * @see #setElementType(String)
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getElementType_ElementType()
	 * @model default=""
	 * @generated
	 */
	String getElementType();

	/**
	 * Sets the value of the '{@link DiagramGlobalToolService.ElementType#getElementType <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' attribute.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(String value);

} // ElementType
