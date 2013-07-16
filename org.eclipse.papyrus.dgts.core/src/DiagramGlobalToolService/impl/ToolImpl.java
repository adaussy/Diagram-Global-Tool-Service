/**
 */
package DiagramGlobalToolService.impl;

import DiagramGlobalToolService.DiagramGlobalToolServicePackage;
import DiagramGlobalToolService.ElementType;
import DiagramGlobalToolService.Tool;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.impl.ToolImpl#getElementTypes <em>Element Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToolImpl extends AbstractToolImpl implements Tool {
        /**
         * The cached value of the '{@link #getElementTypes() <em>Element Types</em>}' reference list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getElementTypes()
         * @generated
         * @ordered
         */
        protected EList<ElementType> elementTypes;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected ToolImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return DiagramGlobalToolServicePackage.Literals.TOOL;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EList<ElementType> getElementTypes() {
                if (elementTypes == null) {
                        elementTypes = new EObjectResolvingEList<ElementType>(ElementType.class, this, DiagramGlobalToolServicePackage.TOOL__ELEMENT_TYPES);
                }
                return elementTypes;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case DiagramGlobalToolServicePackage.TOOL__ELEMENT_TYPES:
                                return getElementTypes();
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
                        case DiagramGlobalToolServicePackage.TOOL__ELEMENT_TYPES:
                                getElementTypes().clear();
                                getElementTypes().addAll((Collection<? extends ElementType>)newValue);
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
                        case DiagramGlobalToolServicePackage.TOOL__ELEMENT_TYPES:
                                getElementTypes().clear();
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
                        case DiagramGlobalToolServicePackage.TOOL__ELEMENT_TYPES:
                                return elementTypes != null && !elementTypes.isEmpty();
                }
                return super.eIsSet(featureID);
        }

} //ToolImpl
