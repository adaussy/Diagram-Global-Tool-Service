/**
 */
package DiagramGlobalToolService;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.DiagramDefinition#getDrawerDefinitionRef <em>Drawer Definition Ref</em>}</li>
 *   <li>{@link DiagramGlobalToolService.DiagramDefinition#getDiagramType <em>Diagram Type</em>}</li>
 *   <li>{@link DiagramGlobalToolService.DiagramDefinition#isSetPalette <em>Set Palette</em>}</li>
 *   <li>{@link DiagramGlobalToolService.DiagramDefinition#isSetPopup <em>Set Popup</em>}</li>
 *   <li>{@link DiagramGlobalToolService.DiagramDefinition#isSetMenu <em>Set Menu</em>}</li>
 * </ul>
 * </p>
 *
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDiagramDefinition()
 * @model
 * @generated
 */
public interface DiagramDefinition extends EObject {
        /**
	 * Returns the value of the '<em><b>Drawer Definition Ref</b></em>' containment reference list.
	 * The list contents are of type {@link DiagramGlobalToolService.DrawerDefinition}.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Drawer Definition Ref</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Drawer Definition Ref</em>' containment reference list.
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDiagramDefinition_DrawerDefinitionRef()
	 * @model containment="true"
	 * @generated
	 */
        EList<DrawerDefinition> getDrawerDefinitionRef();

        /**
	 * Returns the value of the '<em><b>Diagram Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Diagram Type</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Type</em>' attribute.
	 * @see #setDiagramType(String)
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDiagramDefinition_DiagramType()
	 * @model required="true"
	 * @generated
	 */
        String getDiagramType();

        /**
	 * Sets the value of the '{@link DiagramGlobalToolService.DiagramDefinition#getDiagramType <em>Diagram Type</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Type</em>' attribute.
	 * @see #getDiagramType()
	 * @generated
	 */
        void setDiagramType(String value);

								/**
	 * Returns the value of the '<em><b>Set Palette</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Palette</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Palette</em>' attribute.
	 * @see #setSetPalette(boolean)
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDiagramDefinition_SetPalette()
	 * @model default="true"
	 * @generated
	 */
	boolean isSetPalette();

								/**
	 * Sets the value of the '{@link DiagramGlobalToolService.DiagramDefinition#isSetPalette <em>Set Palette</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Palette</em>' attribute.
	 * @see #isSetPalette()
	 * @generated
	 */
	void setSetPalette(boolean value);

								/**
	 * Returns the value of the '<em><b>Set Popup</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Popup</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Popup</em>' attribute.
	 * @see #setSetPopup(boolean)
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDiagramDefinition_SetPopup()
	 * @model default="true"
	 * @generated
	 */
	boolean isSetPopup();

								/**
	 * Sets the value of the '{@link DiagramGlobalToolService.DiagramDefinition#isSetPopup <em>Set Popup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Popup</em>' attribute.
	 * @see #isSetPopup()
	 * @generated
	 */
	void setSetPopup(boolean value);

								/**
	 * Returns the value of the '<em><b>Set Menu</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Menu</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Menu</em>' attribute.
	 * @see #setSetMenu(boolean)
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDiagramDefinition_SetMenu()
	 * @model default="true"
	 * @generated
	 */
	boolean isSetMenu();

								/**
	 * Sets the value of the '{@link DiagramGlobalToolService.DiagramDefinition#isSetMenu <em>Set Menu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Menu</em>' attribute.
	 * @see #isSetMenu()
	 * @generated
	 */
	void setSetMenu(boolean value);

} // DiagramDefinition
