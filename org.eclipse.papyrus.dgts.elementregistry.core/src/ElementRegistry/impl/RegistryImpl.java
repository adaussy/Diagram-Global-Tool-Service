/**
 */
package ElementRegistry.impl;

import ElementRegistry.DiagramDefinition;
import ElementRegistry.ElementRegistryPackage;
import ElementRegistry.Registry;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ElementRegistry.impl.RegistryImpl#getRefDiagrams <em>Ref Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegistryImpl extends MinimalEObjectImpl.Container implements Registry {
        /**
         * The cached value of the '{@link #getRefDiagrams() <em>Ref Diagrams</em>}' containment reference list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getRefDiagrams()
         * @generated
         * @ordered
         */
        protected EList<DiagramDefinition> refDiagrams;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected RegistryImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return ElementRegistryPackage.Literals.REGISTRY;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EList<DiagramDefinition> getRefDiagrams() {
                if (refDiagrams == null) {
                        refDiagrams = new EObjectContainmentEList<DiagramDefinition>(DiagramDefinition.class, this, ElementRegistryPackage.REGISTRY__REF_DIAGRAMS);
                }
                return refDiagrams;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
                switch (featureID) {
                        case ElementRegistryPackage.REGISTRY__REF_DIAGRAMS:
                                return ((InternalEList<?>)getRefDiagrams()).basicRemove(otherEnd, msgs);
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
                        case ElementRegistryPackage.REGISTRY__REF_DIAGRAMS:
                                return getRefDiagrams();
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
                        case ElementRegistryPackage.REGISTRY__REF_DIAGRAMS:
                                getRefDiagrams().clear();
                                getRefDiagrams().addAll((Collection<? extends DiagramDefinition>)newValue);
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
                        case ElementRegistryPackage.REGISTRY__REF_DIAGRAMS:
                                getRefDiagrams().clear();
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
                        case ElementRegistryPackage.REGISTRY__REF_DIAGRAMS:
                                return refDiagrams != null && !refDiagrams.isEmpty();
                }
                return super.eIsSet(featureID);
        }

} //RegistryImpl
