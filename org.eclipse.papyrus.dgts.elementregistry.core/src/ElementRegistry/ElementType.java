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
/**
 */
package ElementRegistry;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ElementRegistry.ElementType#getElementTypeID <em>Element Type ID</em>}</li>
 *   <li>{@link ElementRegistry.ElementType#getDescription <em>Description</em>}</li>
 *   <li>{@link ElementRegistry.ElementType#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see ElementRegistry.ElementRegistryPackage#getElementType()
 * @model
 * @generated
 */
public interface ElementType extends EObject {
        /**
         * Returns the value of the '<em><b>Element Type ID</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Element Type ID</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Element Type ID</em>' attribute.
         * @see #setElementTypeID(String)
         * @see ElementRegistry.ElementRegistryPackage#getElementType_ElementTypeID()
         * @model
         * @generated
         */
        String getElementTypeID();

        /**
         * Sets the value of the '{@link ElementRegistry.ElementType#getElementTypeID <em>Element Type ID</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Element Type ID</em>' attribute.
         * @see #getElementTypeID()
         * @generated
         */
        void setElementTypeID(String value);

        /**
         * Returns the value of the '<em><b>Description</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Description</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Description</em>' attribute.
         * @see #setDescription(String)
         * @see ElementRegistry.ElementRegistryPackage#getElementType_Description()
         * @model
         * @generated
         */
        String getDescription();

        /**
         * Sets the value of the '{@link ElementRegistry.ElementType#getDescription <em>Description</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Description</em>' attribute.
         * @see #getDescription()
         * @generated
         */
        void setDescription(String value);

        /**
         * Returns the value of the '<em><b>Context</b></em>' attribute.
         * The literals are from the enumeration {@link ElementRegistry.Context}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Context</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Context</em>' attribute.
         * @see ElementRegistry.Context
         * @see #setContext(Context)
         * @see ElementRegistry.ElementRegistryPackage#getElementType_Context()
         * @model
         * @generated
         */
        Context getContext();

        /**
         * Sets the value of the '{@link ElementRegistry.ElementType#getContext <em>Context</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Context</em>' attribute.
         * @see ElementRegistry.Context
         * @see #getContext()
         * @generated
         */
        void setContext(Context value);

} // ElementType
