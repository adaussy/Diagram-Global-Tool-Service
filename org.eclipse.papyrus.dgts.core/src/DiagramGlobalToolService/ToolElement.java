/**
 */
package DiagramGlobalToolService;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.ToolElement#getName <em>Name</em>}</li>
 *   <li>{@link DiagramGlobalToolService.ToolElement#getIElementType <em>IElement Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getToolElement()
 * @model
 * @generated
 */
public interface ToolElement extends EObject {

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
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getToolElement_Name()
	 * @model
	 * @generated
	 */
        String getName();

        /**
	 * Sets the value of the '{@link DiagramGlobalToolService.ToolElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
        void setName(String value);

        /**
	 * Returns the value of the '<em><b>IElement Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>IElement Type</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>IElement Type</em>' attribute.
	 * @see #setIElementType(String)
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getToolElement_IElementType()
	 * @model
	 * @generated
	 */
        String getIElementType();

        /**
	 * Sets the value of the '{@link DiagramGlobalToolService.ToolElement#getIElementType <em>IElement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IElement Type</em>' attribute.
	 * @see #getIElementType()
	 * @generated
	 */
        void setIElementType(String value);
} // ToolElement
