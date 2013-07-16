/**
 */
package DiagramGlobalToolService.impl;

import DiagramGlobalToolService.DiagramGlobalToolServicePackage;
import DiagramGlobalToolService.ToolMetaModel;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tool Meta Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.impl.ToolMetaModelImpl#getMetaModel <em>Meta Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToolMetaModelImpl extends AbstractToolImpl implements ToolMetaModel {
        /**
         * The default value of the '{@link #getMetaModel() <em>Meta Model</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getMetaModel()
         * @generated
         * @ordered
         */
        protected static final String META_MODEL_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getMetaModel() <em>Meta Model</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getMetaModel()
         * @generated
         * @ordered
         */
        protected String metaModel = META_MODEL_EDEFAULT;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected ToolMetaModelImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return DiagramGlobalToolServicePackage.Literals.TOOL_META_MODEL;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public String getMetaModel() {
                return metaModel;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setMetaModel(String newMetaModel) {
                String oldMetaModel = metaModel;
                metaModel = newMetaModel;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.TOOL_META_MODEL__META_MODEL, oldMetaModel, metaModel));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case DiagramGlobalToolServicePackage.TOOL_META_MODEL__META_MODEL:
                                return getMetaModel();
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
                        case DiagramGlobalToolServicePackage.TOOL_META_MODEL__META_MODEL:
                                setMetaModel((String)newValue);
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
                        case DiagramGlobalToolServicePackage.TOOL_META_MODEL__META_MODEL:
                                setMetaModel(META_MODEL_EDEFAULT);
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
                        case DiagramGlobalToolServicePackage.TOOL_META_MODEL__META_MODEL:
                                return META_MODEL_EDEFAULT == null ? metaModel != null : !META_MODEL_EDEFAULT.equals(metaModel);
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
                result.append(" (metaModel: ");
                result.append(metaModel);
                result.append(')');
                return result.toString();
        }

} //ToolMetaModelImpl
