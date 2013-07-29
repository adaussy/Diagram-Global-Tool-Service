/**
 */
package DiagramGlobalToolService;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Icon</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.Icon#getIconPath <em>Icon Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getIcon()
 * @model
 * @generated
 */
public interface Icon extends EObject {
	/**
	 * Returns the value of the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Path</em>' attribute.
	 * @see #setIconPath(String)
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getIcon_IconPath()
	 * @model
	 * @generated
	 */
	String getIconPath();

	/**
	 * Sets the value of the '{@link DiagramGlobalToolService.Icon#getIconPath <em>Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Path</em>' attribute.
	 * @see #getIconPath()
	 * @generated
	 */
	void setIconPath(String value);

} // Icon
