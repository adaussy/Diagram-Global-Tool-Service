/**
 * *****************************************************************************
 * Copyright  2013 Atos.
 *  All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  Vincent Lartigaut (Atos) vincent.lartigaut@atos.net - Vincent Lartigaut - initial API and implementation
 *  Guilhem Desq (Atos) guilhem.desq@atos.net -  Guilhem Desq - initial API and implementation
 * *****************************************************************************
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
 *   <li>{@link DiagramGlobalToolService.Tool#isSetPalette <em>Set Palette</em>}</li>
 *   <li>{@link DiagramGlobalToolService.Tool#isSetPopup <em>Set Popup</em>}</li>
 *   <li>{@link DiagramGlobalToolService.Tool#isSetMenu <em>Set Menu</em>}</li>
 *   <li>{@link DiagramGlobalToolService.Tool#getIconReference <em>Icon Reference</em>}</li>
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
	 * If the meaning of the '<em>Element Types</em>' containment reference list isn't clear,
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
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getTool_SetPalette()
	 * @model default="true"
	 * @generated
	 */
	boolean isSetPalette();

	/**
	 * Sets the value of the '{@link DiagramGlobalToolService.Tool#isSetPalette <em>Set Palette</em>}' attribute.
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
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getTool_SetPopup()
	 * @model default="true"
	 * @generated
	 */
	boolean isSetPopup();

	/**
	 * Sets the value of the '{@link DiagramGlobalToolService.Tool#isSetPopup <em>Set Popup</em>}' attribute.
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
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getTool_SetMenu()
	 * @model default="true"
	 * @generated
	 */
	boolean isSetMenu();

	/**
	 * Sets the value of the '{@link DiagramGlobalToolService.Tool#isSetMenu <em>Set Menu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Menu</em>' attribute.
	 * @see #isSetMenu()
	 * @generated
	 */
	void setSetMenu(boolean value);

	/**
	 * Returns the value of the '<em><b>Icon Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Reference</em>' containment reference.
	 * @see #setIconReference(Icon)
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getTool_IconReference()
	 * @model containment="true"
	 * @generated
	 */
	Icon getIconReference();

	/**
	 * Sets the value of the '{@link DiagramGlobalToolService.Tool#getIconReference <em>Icon Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Reference</em>' containment reference.
	 * @see #getIconReference()
	 * @generated
	 */
	void setIconReference(Icon value);

} // Tool
