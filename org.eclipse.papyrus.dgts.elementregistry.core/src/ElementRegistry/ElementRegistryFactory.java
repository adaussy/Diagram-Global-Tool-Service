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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ElementRegistry.ElementRegistryPackage
 * @generated
 */
public interface ElementRegistryFactory extends EFactory {
        /**
         * The singleton instance of the factory.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        ElementRegistryFactory eINSTANCE = ElementRegistry.impl.ElementRegistryFactoryImpl.init();

        /**
         * Returns a new object of class '<em>Registry</em>'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return a new object of class '<em>Registry</em>'.
         * @generated
         */
        Registry createRegistry();

        /**
         * Returns a new object of class '<em>Diagram Definition</em>'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return a new object of class '<em>Diagram Definition</em>'.
         * @generated
         */
        DiagramDefinition createDiagramDefinition();

        /**
         * Returns a new object of class '<em>EClass Definition</em>'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return a new object of class '<em>EClass Definition</em>'.
         * @generated
         */
        EClassDefinition createEClassDefinition();

        /**
         * Returns a new object of class '<em>Element Type</em>'.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return a new object of class '<em>Element Type</em>'.
         * @generated
         */
        ElementType createElementType();

        /**
         * Returns the package supported by this factory.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the package supported by this factory.
         * @generated
         */
        ElementRegistryPackage getElementRegistryPackage();

} //ElementRegistryFactory
