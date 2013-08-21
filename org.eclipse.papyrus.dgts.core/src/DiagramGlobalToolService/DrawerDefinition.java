/*******************************************************************************
 * Copyright  2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * Vincent Lartigaut (Atos) vincent.lartigaut@atos.net - Vincent Lartigaut - initial API and implementation
 * Guilhem Desq (Atos) guilhem.desq@atos.net -  Guilhem Desq - initial API and implementation
 ******************************************************************************/

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
 *   <li>{@link DiagramGlobalToolService.DrawerDefinition#getName <em>Name</em>}</li>
 *   <li>{@link DiagramGlobalToolService.DrawerDefinition#getToolRef <em>Tool Ref</em>}</li>
 *   <li>{@link DiagramGlobalToolService.DrawerDefinition#getIconReference <em>Icon Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDrawerDefinition()
 * @model
 * @generated
 */
public interface DrawerDefinition extends EObject {
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

	/**
	 * Returns the value of the '<em><b>Tool Ref</b></em>' containment reference list.
	 * The list contents are of type {@link DiagramGlobalToolService.Tool}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool Ref</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool Ref</em>' containment reference list.
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDrawerDefinition_ToolRef()
	 * @model containment="true"
	 * @generated
	 */
	EList<Tool> getToolRef();

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
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDrawerDefinition_IconReference()
	 * @model containment="true"
	 * @generated
	 */
	Icon getIconReference();

	/**
	 * Sets the value of the '{@link DiagramGlobalToolService.DrawerDefinition#getIconReference <em>Icon Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Reference</em>' containment reference.
	 * @see #getIconReference()
	 * @generated
	 */
	void setIconReference(Icon value);

} // DrawerDefinition
