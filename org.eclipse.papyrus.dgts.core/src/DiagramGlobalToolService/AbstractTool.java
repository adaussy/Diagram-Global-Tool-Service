/**
 */
package DiagramGlobalToolService;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Tool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.AbstractTool#getName <em>Name</em>}</li>
 *   <li>{@link DiagramGlobalToolService.AbstractTool#isIsEdge <em>Is Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getAbstractTool()
 * @model
 * @generated
 */
public interface AbstractTool extends EObject {
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
         * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getAbstractTool_Name()
         * @model
         * @generated
         */
        String getName();

        /**
         * Sets the value of the '{@link DiagramGlobalToolService.AbstractTool#getName <em>Name</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Name</em>' attribute.
         * @see #getName()
         * @generated
         */
        void setName(String value);

        /**
         * Returns the value of the '<em><b>Is Edge</b></em>' attribute.
         * The default value is <code>"false"</code>.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Is Edge</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Is Edge</em>' attribute.
         * @see #setIsEdge(boolean)
         * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getAbstractTool_IsEdge()
         * @model default="false"
         * @generated
         */
        boolean isIsEdge();

        /**
         * Sets the value of the '{@link DiagramGlobalToolService.AbstractTool#isIsEdge <em>Is Edge</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Is Edge</em>' attribute.
         * @see #isIsEdge()
         * @generated
         */
        void setIsEdge(boolean value);

} // AbstractTool
