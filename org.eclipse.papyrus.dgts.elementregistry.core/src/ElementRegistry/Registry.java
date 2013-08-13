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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ElementRegistry.Registry#getRefDiagrams <em>Ref Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @see ElementRegistry.ElementRegistryPackage#getRegistry()
 * @model
 * @generated
 */
public interface Registry extends EObject {
        /**
         * Returns the value of the '<em><b>Ref Diagrams</b></em>' containment reference list.
         * The list contents are of type {@link ElementRegistry.DiagramDefinition}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Ref Diagrams</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Ref Diagrams</em>' containment reference list.
         * @see ElementRegistry.ElementRegistryPackage#getRegistry_RefDiagrams()
         * @model containment="true"
         * @generated
         */
        EList<DiagramDefinition> getRefDiagrams();

} // Registry
