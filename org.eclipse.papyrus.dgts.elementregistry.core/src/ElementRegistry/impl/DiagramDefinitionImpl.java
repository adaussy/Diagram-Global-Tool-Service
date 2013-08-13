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
package ElementRegistry.impl;

import ElementRegistry.DiagramDefinition;
import ElementRegistry.EClassDefinition;
import ElementRegistry.ElementRegistryPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ElementRegistry.impl.DiagramDefinitionImpl#getRefEClass <em>Ref EClass</em>}</li>
 *   <li>{@link ElementRegistry.impl.DiagramDefinitionImpl#getDiagramType <em>Diagram Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramDefinitionImpl extends MinimalEObjectImpl.Container implements DiagramDefinition {
        /**
         * The cached value of the '{@link #getRefEClass() <em>Ref EClass</em>}' containment reference list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getRefEClass()
         * @generated
         * @ordered
         */
        protected EList<EClassDefinition> refEClass;

        /**
         * The default value of the '{@link #getDiagramType() <em>Diagram Type</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getDiagramType()
         * @generated
         * @ordered
         */
        protected static final String DIAGRAM_TYPE_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getDiagramType() <em>Diagram Type</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getDiagramType()
         * @generated
         * @ordered
         */
        protected String diagramType = DIAGRAM_TYPE_EDEFAULT;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected DiagramDefinitionImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return ElementRegistryPackage.Literals.DIAGRAM_DEFINITION;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EList<EClassDefinition> getRefEClass() {
                if (refEClass == null) {
                        refEClass = new EObjectContainmentEList<EClassDefinition>(EClassDefinition.class, this, ElementRegistryPackage.DIAGRAM_DEFINITION__REF_ECLASS);
                }
                return refEClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public String getDiagramType() {
                return diagramType;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setDiagramType(String newDiagramType) {
                String oldDiagramType = diagramType;
                diagramType = newDiagramType;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, ElementRegistryPackage.DIAGRAM_DEFINITION__DIAGRAM_TYPE, oldDiagramType, diagramType));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
                switch (featureID) {
                        case ElementRegistryPackage.DIAGRAM_DEFINITION__REF_ECLASS:
                                return ((InternalEList<?>)getRefEClass()).basicRemove(otherEnd, msgs);
                }
                return super.eInverseRemove(otherEnd, featureID, msgs);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case ElementRegistryPackage.DIAGRAM_DEFINITION__REF_ECLASS:
                                return getRefEClass();
                        case ElementRegistryPackage.DIAGRAM_DEFINITION__DIAGRAM_TYPE:
                                return getDiagramType();
                }
                return super.eGet(featureID, resolve, coreType);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("unchecked")
        @Override
        public void eSet(int featureID, Object newValue) {
                switch (featureID) {
                        case ElementRegistryPackage.DIAGRAM_DEFINITION__REF_ECLASS:
                                getRefEClass().clear();
                                getRefEClass().addAll((Collection<? extends EClassDefinition>)newValue);
                                return;
                        case ElementRegistryPackage.DIAGRAM_DEFINITION__DIAGRAM_TYPE:
                                setDiagramType((String)newValue);
                                return;
                }
                super.eSet(featureID, newValue);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public void eUnset(int featureID) {
                switch (featureID) {
                        case ElementRegistryPackage.DIAGRAM_DEFINITION__REF_ECLASS:
                                getRefEClass().clear();
                                return;
                        case ElementRegistryPackage.DIAGRAM_DEFINITION__DIAGRAM_TYPE:
                                setDiagramType(DIAGRAM_TYPE_EDEFAULT);
                                return;
                }
                super.eUnset(featureID);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public boolean eIsSet(int featureID) {
                switch (featureID) {
                        case ElementRegistryPackage.DIAGRAM_DEFINITION__REF_ECLASS:
                                return refEClass != null && !refEClass.isEmpty();
                        case ElementRegistryPackage.DIAGRAM_DEFINITION__DIAGRAM_TYPE:
                                return DIAGRAM_TYPE_EDEFAULT == null ? diagramType != null : !DIAGRAM_TYPE_EDEFAULT.equals(diagramType);
                }
                return super.eIsSet(featureID);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public String toString() {
                if (eIsProxy()) return super.toString();

                StringBuffer result = new StringBuffer(super.toString());
                result.append(" (diagramType: ");
                result.append(diagramType);
                result.append(')');
                return result.toString();
        }

} //DiagramDefinitionImpl
