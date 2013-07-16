/**
 */
package DiagramGlobalToolService.impl;

import DiagramGlobalToolService.DiagramGlobalToolServicePackage;
import DiagramGlobalToolService.ToolElement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tool Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.impl.ToolElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.ToolElementImpl#getIElementType <em>IElement Type</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.ToolElementImpl#isEdge <em>Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToolElementImpl extends MinimalEObjectImpl.Container implements ToolElement {
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
	 * The default value of the '{@link #getIElementType() <em>IElement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getIElementType()
	 * @generated
	 * @ordered
	 */
        protected static final String IELEMENT_TYPE_EDEFAULT = "";
        /**
	 * The cached value of the '{@link #getIElementType() <em>IElement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getIElementType()
	 * @generated
	 * @ordered
	 */
        protected String iElementType = IELEMENT_TYPE_EDEFAULT;
        /**
	 * The default value of the '{@link #isEdge() <em>Edge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEdge()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EDGE_EDEFAULT = false;
								/**
	 * The cached value of the '{@link #isEdge() <em>Edge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEdge()
	 * @generated
	 * @ordered
	 */
	protected boolean edge = EDGE_EDEFAULT;
								/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramGlobalToolServicePackage.Literals.TOOL_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.TOOL_ELEMENT__NAME, oldName, name));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getIElementType() {
		return iElementType;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setIElementType(String newIElementType) {
		String oldIElementType = iElementType;
		iElementType = newIElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.TOOL_ELEMENT__IELEMENT_TYPE, oldIElementType, iElementType));
	}

        /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEdge() {
		return edge;
	}

								/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdge(boolean newEdge) {
		boolean oldEdge = edge;
		edge = newEdge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.TOOL_ELEMENT__EDGE, oldEdge, edge));
	}

								/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramGlobalToolServicePackage.TOOL_ELEMENT__NAME:
				return getName();
			case DiagramGlobalToolServicePackage.TOOL_ELEMENT__IELEMENT_TYPE:
				return getIElementType();
			case DiagramGlobalToolServicePackage.TOOL_ELEMENT__EDGE:
				return isEdge();
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
			case DiagramGlobalToolServicePackage.TOOL_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case DiagramGlobalToolServicePackage.TOOL_ELEMENT__IELEMENT_TYPE:
				setIElementType((String)newValue);
				return;
			case DiagramGlobalToolServicePackage.TOOL_ELEMENT__EDGE:
				setEdge((Boolean)newValue);
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
			case DiagramGlobalToolServicePackage.TOOL_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagramGlobalToolServicePackage.TOOL_ELEMENT__IELEMENT_TYPE:
				setIElementType(IELEMENT_TYPE_EDEFAULT);
				return;
			case DiagramGlobalToolServicePackage.TOOL_ELEMENT__EDGE:
				setEdge(EDGE_EDEFAULT);
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
			case DiagramGlobalToolServicePackage.TOOL_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagramGlobalToolServicePackage.TOOL_ELEMENT__IELEMENT_TYPE:
				return IELEMENT_TYPE_EDEFAULT == null ? iElementType != null : !IELEMENT_TYPE_EDEFAULT.equals(iElementType);
			case DiagramGlobalToolServicePackage.TOOL_ELEMENT__EDGE:
				return edge != EDGE_EDEFAULT;
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
		result.append(" (Name: ");
		result.append(name);
		result.append(", IElementType: ");
		result.append(iElementType);
		result.append(", Edge: ");
		result.append(edge);
		result.append(')');
		return result.toString();
	}

} //ToolElementImpl
