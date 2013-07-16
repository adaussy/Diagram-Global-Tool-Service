/**
 */
package DiagramGlobalToolService.impl;

import DiagramGlobalToolService.AbstractTool;
import DiagramGlobalToolService.DiagramGlobalToolServicePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Tool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.impl.AbstractToolImpl#getName <em>Name</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.AbstractToolImpl#isIsEdge <em>Is Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractToolImpl extends MinimalEObjectImpl.Container implements AbstractTool {
        /**
         * The default value of the '{@link #getName() <em>Name</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getName()
         * @generated
         * @ordered
         */
        protected static final String NAME_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getName()
         * @generated
         * @ordered
         */
        protected String name = NAME_EDEFAULT;

        /**
         * The default value of the '{@link #isIsEdge() <em>Is Edge</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #isIsEdge()
         * @generated
         * @ordered
         */
        protected static final boolean IS_EDGE_EDEFAULT = false;

        /**
         * The cached value of the '{@link #isIsEdge() <em>Is Edge</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #isIsEdge()
         * @generated
         * @ordered
         */
        protected boolean isEdge = IS_EDGE_EDEFAULT;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected AbstractToolImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return DiagramGlobalToolServicePackage.Literals.ABSTRACT_TOOL;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public String getName() {
                return name;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setName(String newName) {
                String oldName = name;
                name = newName;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.ABSTRACT_TOOL__NAME, oldName, name));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public boolean isIsEdge() {
                return isEdge;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setIsEdge(boolean newIsEdge) {
                boolean oldIsEdge = isEdge;
                isEdge = newIsEdge;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.ABSTRACT_TOOL__IS_EDGE, oldIsEdge, isEdge));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case DiagramGlobalToolServicePackage.ABSTRACT_TOOL__NAME:
                                return getName();
                        case DiagramGlobalToolServicePackage.ABSTRACT_TOOL__IS_EDGE:
                                return isIsEdge();
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
                        case DiagramGlobalToolServicePackage.ABSTRACT_TOOL__NAME:
                                setName((String)newValue);
                                return;
                        case DiagramGlobalToolServicePackage.ABSTRACT_TOOL__IS_EDGE:
                                setIsEdge((Boolean)newValue);
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
                        case DiagramGlobalToolServicePackage.ABSTRACT_TOOL__NAME:
                                setName(NAME_EDEFAULT);
                                return;
                        case DiagramGlobalToolServicePackage.ABSTRACT_TOOL__IS_EDGE:
                                setIsEdge(IS_EDGE_EDEFAULT);
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
                        case DiagramGlobalToolServicePackage.ABSTRACT_TOOL__NAME:
                                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
                        case DiagramGlobalToolServicePackage.ABSTRACT_TOOL__IS_EDGE:
                                return isEdge != IS_EDGE_EDEFAULT;
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
                result.append(" (name: ");
                result.append(name);
                result.append(", isEdge: ");
                result.append(isEdge);
                result.append(')');
                return result.toString();
        }

} //AbstractToolImpl
