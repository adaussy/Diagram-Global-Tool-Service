/**
 */
package ElementRegistry.impl;

import ElementRegistry.EClassDefinition;
import ElementRegistry.ElementRegistryPackage;
import ElementRegistry.ElementType;

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
 * An implementation of the model object '<em><b>EClass Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ElementRegistry.impl.EClassDefinitionImpl#getRefElementTypes <em>Ref Element Types</em>}</li>
 *   <li>{@link ElementRegistry.impl.EClassDefinitionImpl#getEClass <em>EClass</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EClassDefinitionImpl extends MinimalEObjectImpl.Container implements EClassDefinition {
        /**
         * The cached value of the '{@link #getRefElementTypes() <em>Ref Element Types</em>}' containment reference list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getRefElementTypes()
         * @generated
         * @ordered
         */
        protected EList<ElementType> refElementTypes;

        /**
         * The cached value of the '{@link #getEClass() <em>EClass</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getEClass()
         * @generated
         * @ordered
         */
        protected EClass eClass;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected EClassDefinitionImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return ElementRegistryPackage.Literals.ECLASS_DEFINITION;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EList<ElementType> getRefElementTypes() {
                if (refElementTypes == null) {
                        refElementTypes = new EObjectContainmentEList<ElementType>(ElementType.class, this, ElementRegistryPackage.ECLASS_DEFINITION__REF_ELEMENT_TYPES);
                }
                return refElementTypes;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EClass getEClass() {
                if (eClass != null && eClass.eIsProxy()) {
                        InternalEObject oldEClass = (InternalEObject)eClass;
                        eClass = (EClass)eResolveProxy(oldEClass);
                        if (eClass != oldEClass) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementRegistryPackage.ECLASS_DEFINITION__ECLASS, oldEClass, eClass));
                        }
                }
                return eClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EClass basicGetEClass() {
                return eClass;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setEClass(EClass newEClass) {
                EClass oldEClass = eClass;
                eClass = newEClass;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, ElementRegistryPackage.ECLASS_DEFINITION__ECLASS, oldEClass, eClass));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
                switch (featureID) {
                        case ElementRegistryPackage.ECLASS_DEFINITION__REF_ELEMENT_TYPES:
                                return ((InternalEList<?>)getRefElementTypes()).basicRemove(otherEnd, msgs);
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
                        case ElementRegistryPackage.ECLASS_DEFINITION__REF_ELEMENT_TYPES:
                                return getRefElementTypes();
                        case ElementRegistryPackage.ECLASS_DEFINITION__ECLASS:
                                if (resolve) return getEClass();
                                return basicGetEClass();
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
                        case ElementRegistryPackage.ECLASS_DEFINITION__REF_ELEMENT_TYPES:
                                getRefElementTypes().clear();
                                getRefElementTypes().addAll((Collection<? extends ElementType>)newValue);
                                return;
                        case ElementRegistryPackage.ECLASS_DEFINITION__ECLASS:
                                setEClass((EClass)newValue);
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
                        case ElementRegistryPackage.ECLASS_DEFINITION__REF_ELEMENT_TYPES:
                                getRefElementTypes().clear();
                                return;
                        case ElementRegistryPackage.ECLASS_DEFINITION__ECLASS:
                                setEClass((EClass)null);
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
                        case ElementRegistryPackage.ECLASS_DEFINITION__REF_ELEMENT_TYPES:
                                return refElementTypes != null && !refElementTypes.isEmpty();
                        case ElementRegistryPackage.ECLASS_DEFINITION__ECLASS:
                                return eClass != null;
                }
                return super.eIsSet(featureID);
        }

} //EClassDefinitionImpl
