/**
 */
package DiagramGlobalToolService.impl;

import DiagramGlobalToolService.DiagramGlobalToolServicePackage;
import DiagramGlobalToolService.ElementType;
import DiagramGlobalToolService.Tool;
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
 * An implementation of the model object '<em><b>Tool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.impl.ToolImpl#getElementTypes <em>Element Types</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.ToolImpl#isIsEdge <em>Is Edge</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.ToolImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToolImpl extends MinimalEObjectImpl.Container implements Tool {
        /**
	 * The cached value of the '{@link #getElementTypes() <em>Element Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getElementTypes()
	 * @generated
	 * @ordered
	 */
        protected EList<ElementType> elementTypes;

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
			elementTypes = new EObjectContainmentEList<ElementType>(ElementType.class, this, DiagramGlobalToolServicePackage.TOOL__ELEMENT_TYPES);
		}
		return elementTypes;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.TOOL__IS_EDGE, oldIsEdge, isEdge));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.TOOL__NAME, oldName, name));
	}

								/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramGlobalToolServicePackage.TOOL__ELEMENT_TYPES:
				return ((InternalEList<?>)getElementTypes()).basicRemove(otherEnd, msgs);
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
			case DiagramGlobalToolServicePackage.TOOL__ELEMENT_TYPES:
				return getElementTypes();
			case DiagramGlobalToolServicePackage.TOOL__IS_EDGE:
				return isIsEdge();
			case DiagramGlobalToolServicePackage.TOOL__NAME:
				return getName();
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
			case DiagramGlobalToolServicePackage.TOOL__IS_EDGE:
				setIsEdge((Boolean)newValue);
				return;
			case DiagramGlobalToolServicePackage.TOOL__NAME:
				setName((String)newValue);
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
			case DiagramGlobalToolServicePackage.TOOL__IS_EDGE:
				setIsEdge(IS_EDGE_EDEFAULT);
				return;
			case DiagramGlobalToolServicePackage.TOOL__NAME:
				setName(NAME_EDEFAULT);
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
			case DiagramGlobalToolServicePackage.TOOL__IS_EDGE:
				return isEdge != IS_EDGE_EDEFAULT;
			case DiagramGlobalToolServicePackage.TOOL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (isEdge: ");
		result.append(isEdge);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ToolImpl
