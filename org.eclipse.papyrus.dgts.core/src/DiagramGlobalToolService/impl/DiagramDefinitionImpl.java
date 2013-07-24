/**
 */
package DiagramGlobalToolService.impl;

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolServicePackage;
import DiagramGlobalToolService.DrawerDefinition;

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
 *   <li>{@link DiagramGlobalToolService.impl.DiagramDefinitionImpl#getDrawerDefinitionRef <em>Drawer Definition Ref</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.DiagramDefinitionImpl#getDiagramType <em>Diagram Type</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.DiagramDefinitionImpl#isSetPalette <em>Set Palette</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.DiagramDefinitionImpl#isSetPopup <em>Set Popup</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.DiagramDefinitionImpl#isSetMenu <em>Set Menu</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramDefinitionImpl extends MinimalEObjectImpl.Container implements DiagramDefinition {
        /**
	 * The cached value of the '{@link #getDrawerDefinitionRef() <em>Drawer Definition Ref</em>}' containment reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getDrawerDefinitionRef()
	 * @generated
	 * @ordered
	 */
        protected EList<DrawerDefinition> drawerDefinitionRef;

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
	 * The default value of the '{@link #isSetPalette() <em>Set Palette</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPalette()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SET_PALETTE_EDEFAULT = true;

								/**
	 * The cached value of the '{@link #isSetPalette() <em>Set Palette</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPalette()
	 * @generated
	 * @ordered
	 */
	protected boolean setPalette = SET_PALETTE_EDEFAULT;

								/**
	 * The default value of the '{@link #isSetPopup() <em>Set Popup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPopup()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SET_POPUP_EDEFAULT = true;

								/**
	 * The cached value of the '{@link #isSetPopup() <em>Set Popup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPopup()
	 * @generated
	 * @ordered
	 */
	protected boolean setPopup = SET_POPUP_EDEFAULT;

								/**
	 * The default value of the '{@link #isSetMenu() <em>Set Menu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMenu()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SET_MENU_EDEFAULT = true;

								/**
	 * The cached value of the '{@link #isSetMenu() <em>Set Menu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMenu()
	 * @generated
	 * @ordered
	 */
	protected boolean setMenu = SET_MENU_EDEFAULT;

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
		return DiagramGlobalToolServicePackage.Literals.DIAGRAM_DEFINITION;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<DrawerDefinition> getDrawerDefinitionRef() {
		if (drawerDefinitionRef == null) {
			drawerDefinitionRef = new EObjectContainmentEList<DrawerDefinition>(DrawerDefinition.class, this, DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__DRAWER_DEFINITION_REF);
		}
		return drawerDefinitionRef;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__DIAGRAM_TYPE, oldDiagramType, diagramType));
	}

        /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPalette() {
		return setPalette;
	}

								/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetPalette(boolean newSetPalette) {
		boolean oldSetPalette = setPalette;
		setPalette = newSetPalette;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_PALETTE, oldSetPalette, setPalette));
	}

								/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPopup() {
		return setPopup;
	}

								/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetPopup(boolean newSetPopup) {
		boolean oldSetPopup = setPopup;
		setPopup = newSetPopup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_POPUP, oldSetPopup, setPopup));
	}

								/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMenu() {
		return setMenu;
	}

								/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetMenu(boolean newSetMenu) {
		boolean oldSetMenu = setMenu;
		setMenu = newSetMenu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_MENU, oldSetMenu, setMenu));
	}

								/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__DRAWER_DEFINITION_REF:
				return ((InternalEList<?>)getDrawerDefinitionRef()).basicRemove(otherEnd, msgs);
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
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__DRAWER_DEFINITION_REF:
				return getDrawerDefinitionRef();
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__DIAGRAM_TYPE:
				return getDiagramType();
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_PALETTE:
				return isSetPalette();
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_POPUP:
				return isSetPopup();
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_MENU:
				return isSetMenu();
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
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__DRAWER_DEFINITION_REF:
				getDrawerDefinitionRef().clear();
				getDrawerDefinitionRef().addAll((Collection<? extends DrawerDefinition>)newValue);
				return;
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__DIAGRAM_TYPE:
				setDiagramType((String)newValue);
				return;
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_PALETTE:
				setSetPalette((Boolean)newValue);
				return;
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_POPUP:
				setSetPopup((Boolean)newValue);
				return;
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_MENU:
				setSetMenu((Boolean)newValue);
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
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__DRAWER_DEFINITION_REF:
				getDrawerDefinitionRef().clear();
				return;
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__DIAGRAM_TYPE:
				setDiagramType(DIAGRAM_TYPE_EDEFAULT);
				return;
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_PALETTE:
				setSetPalette(SET_PALETTE_EDEFAULT);
				return;
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_POPUP:
				setSetPopup(SET_POPUP_EDEFAULT);
				return;
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_MENU:
				setSetMenu(SET_MENU_EDEFAULT);
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
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__DRAWER_DEFINITION_REF:
				return drawerDefinitionRef != null && !drawerDefinitionRef.isEmpty();
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__DIAGRAM_TYPE:
				return DIAGRAM_TYPE_EDEFAULT == null ? diagramType != null : !DIAGRAM_TYPE_EDEFAULT.equals(diagramType);
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_PALETTE:
				return setPalette != SET_PALETTE_EDEFAULT;
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_POPUP:
				return setPopup != SET_POPUP_EDEFAULT;
			case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION__SET_MENU:
				return setMenu != SET_MENU_EDEFAULT;
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
		result.append(" (DiagramType: ");
		result.append(diagramType);
		result.append(", setPalette: ");
		result.append(setPalette);
		result.append(", setPopup: ");
		result.append(setPopup);
		result.append(", setMenu: ");
		result.append(setMenu);
		result.append(')');
		return result.toString();
	}

} //DiagramDefinitionImpl
