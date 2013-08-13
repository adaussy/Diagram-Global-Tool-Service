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

import ElementRegistry.Context;
import ElementRegistry.ElementRegistryPackage;
import ElementRegistry.ElementType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ElementRegistry.impl.ElementTypeImpl#getElementTypeID <em>Element Type ID</em>}</li>
 *   <li>{@link ElementRegistry.impl.ElementTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link ElementRegistry.impl.ElementTypeImpl#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementTypeImpl extends MinimalEObjectImpl.Container implements ElementType {
        /**
         * The default value of the '{@link #getElementTypeID() <em>Element Type ID</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getElementTypeID()
         * @generated
         * @ordered
         */
        protected static final String ELEMENT_TYPE_ID_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getElementTypeID() <em>Element Type ID</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getElementTypeID()
         * @generated
         * @ordered
         */
        protected String elementTypeID = ELEMENT_TYPE_ID_EDEFAULT;

        /**
         * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getDescription()
         * @generated
         * @ordered
         */
        protected static final String DESCRIPTION_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getDescription()
         * @generated
         * @ordered
         */
        protected String description = DESCRIPTION_EDEFAULT;

        /**
         * The default value of the '{@link #getContext() <em>Context</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getContext()
         * @generated
         * @ordered
         */
        protected static final Context CONTEXT_EDEFAULT = Context.DIAGRAM;

        /**
         * The cached value of the '{@link #getContext() <em>Context</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getContext()
         * @generated
         * @ordered
         */
        protected Context context = CONTEXT_EDEFAULT;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected ElementTypeImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return ElementRegistryPackage.Literals.ELEMENT_TYPE;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public String getElementTypeID() {
                return elementTypeID;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setElementTypeID(String newElementTypeID) {
                String oldElementTypeID = elementTypeID;
                elementTypeID = newElementTypeID;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, ElementRegistryPackage.ELEMENT_TYPE__ELEMENT_TYPE_ID, oldElementTypeID, elementTypeID));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public String getDescription() {
                return description;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setDescription(String newDescription) {
                String oldDescription = description;
                description = newDescription;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, ElementRegistryPackage.ELEMENT_TYPE__DESCRIPTION, oldDescription, description));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Context getContext() {
                return context;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setContext(Context newContext) {
                Context oldContext = context;
                context = newContext == null ? CONTEXT_EDEFAULT : newContext;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, ElementRegistryPackage.ELEMENT_TYPE__CONTEXT, oldContext, context));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case ElementRegistryPackage.ELEMENT_TYPE__ELEMENT_TYPE_ID:
                                return getElementTypeID();
                        case ElementRegistryPackage.ELEMENT_TYPE__DESCRIPTION:
                                return getDescription();
                        case ElementRegistryPackage.ELEMENT_TYPE__CONTEXT:
                                return getContext();
                }
                return super.eGet(featureID, resolve, coreType);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public void eSet(int featureID, Object newValue) {
                switch (featureID) {
                        case ElementRegistryPackage.ELEMENT_TYPE__ELEMENT_TYPE_ID:
                                setElementTypeID((String)newValue);
                                return;
                        case ElementRegistryPackage.ELEMENT_TYPE__DESCRIPTION:
                                setDescription((String)newValue);
                                return;
                        case ElementRegistryPackage.ELEMENT_TYPE__CONTEXT:
                                setContext((Context)newValue);
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
                        case ElementRegistryPackage.ELEMENT_TYPE__ELEMENT_TYPE_ID:
                                setElementTypeID(ELEMENT_TYPE_ID_EDEFAULT);
                                return;
                        case ElementRegistryPackage.ELEMENT_TYPE__DESCRIPTION:
                                setDescription(DESCRIPTION_EDEFAULT);
                                return;
                        case ElementRegistryPackage.ELEMENT_TYPE__CONTEXT:
                                setContext(CONTEXT_EDEFAULT);
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
                        case ElementRegistryPackage.ELEMENT_TYPE__ELEMENT_TYPE_ID:
                                return ELEMENT_TYPE_ID_EDEFAULT == null ? elementTypeID != null : !ELEMENT_TYPE_ID_EDEFAULT.equals(elementTypeID);
                        case ElementRegistryPackage.ELEMENT_TYPE__DESCRIPTION:
                                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
                        case ElementRegistryPackage.ELEMENT_TYPE__CONTEXT:
                                return context != CONTEXT_EDEFAULT;
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
                result.append(" (elementTypeID: ");
                result.append(elementTypeID);
                result.append(", description: ");
                result.append(description);
                result.append(", context: ");
                result.append(context);
                result.append(')');
                return result.toString();
        }

} //ElementTypeImpl
