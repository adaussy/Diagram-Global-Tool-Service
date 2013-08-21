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

package DiagramGlobalToolService.impl;

import DiagramGlobalToolService.DiagramGlobalToolServicePackage;
import DiagramGlobalToolService.ElementType;
import DiagramGlobalToolService.Icon;
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
 *   <li>{@link DiagramGlobalToolService.impl.ToolImpl#isSetPalette <em>Set Palette</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.ToolImpl#isSetPopup <em>Set Popup</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.ToolImpl#isSetMenu <em>Set Menu</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.ToolImpl#getIconReference <em>Icon Reference</em>}</li>
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
	 * The cached value of the '{@link #getIconReference() <em>Icon Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconReference()
	 * @generated
	 * @ordered
	 */
	protected Icon iconReference;

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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.TOOL__SET_PALETTE, oldSetPalette, setPalette));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.TOOL__SET_POPUP, oldSetPopup, setPopup));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.TOOL__SET_MENU, oldSetMenu, setMenu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Icon getIconReference() {
		return iconReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIconReference(Icon newIconReference, NotificationChain msgs) {
		Icon oldIconReference = iconReference;
		iconReference = newIconReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.TOOL__ICON_REFERENCE, oldIconReference, newIconReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconReference(Icon newIconReference) {
		if (newIconReference != iconReference) {
			NotificationChain msgs = null;
			if (iconReference != null)
				msgs = ((InternalEObject)iconReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramGlobalToolServicePackage.TOOL__ICON_REFERENCE, null, msgs);
			if (newIconReference != null)
				msgs = ((InternalEObject)newIconReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramGlobalToolServicePackage.TOOL__ICON_REFERENCE, null, msgs);
			msgs = basicSetIconReference(newIconReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.TOOL__ICON_REFERENCE, newIconReference, newIconReference));
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
			case DiagramGlobalToolServicePackage.TOOL__ICON_REFERENCE:
				return basicSetIconReference(null, msgs);
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
			case DiagramGlobalToolServicePackage.TOOL__SET_PALETTE:
				return isSetPalette();
			case DiagramGlobalToolServicePackage.TOOL__SET_POPUP:
				return isSetPopup();
			case DiagramGlobalToolServicePackage.TOOL__SET_MENU:
				return isSetMenu();
			case DiagramGlobalToolServicePackage.TOOL__ICON_REFERENCE:
				return getIconReference();
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
			case DiagramGlobalToolServicePackage.TOOL__SET_PALETTE:
				setSetPalette((Boolean)newValue);
				return;
			case DiagramGlobalToolServicePackage.TOOL__SET_POPUP:
				setSetPopup((Boolean)newValue);
				return;
			case DiagramGlobalToolServicePackage.TOOL__SET_MENU:
				setSetMenu((Boolean)newValue);
				return;
			case DiagramGlobalToolServicePackage.TOOL__ICON_REFERENCE:
				setIconReference((Icon)newValue);
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
			case DiagramGlobalToolServicePackage.TOOL__SET_PALETTE:
				setSetPalette(SET_PALETTE_EDEFAULT);
				return;
			case DiagramGlobalToolServicePackage.TOOL__SET_POPUP:
				setSetPopup(SET_POPUP_EDEFAULT);
				return;
			case DiagramGlobalToolServicePackage.TOOL__SET_MENU:
				setSetMenu(SET_MENU_EDEFAULT);
				return;
			case DiagramGlobalToolServicePackage.TOOL__ICON_REFERENCE:
				setIconReference((Icon)null);
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
			case DiagramGlobalToolServicePackage.TOOL__SET_PALETTE:
				return setPalette != SET_PALETTE_EDEFAULT;
			case DiagramGlobalToolServicePackage.TOOL__SET_POPUP:
				return setPopup != SET_POPUP_EDEFAULT;
			case DiagramGlobalToolServicePackage.TOOL__SET_MENU:
				return setMenu != SET_MENU_EDEFAULT;
			case DiagramGlobalToolServicePackage.TOOL__ICON_REFERENCE:
				return iconReference != null;
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
		result.append(", setPalette: ");
		result.append(setPalette);
		result.append(", setPopup: ");
		result.append(setPopup);
		result.append(", setMenu: ");
		result.append(setMenu);
		result.append(')');
		return result.toString();
	}

} //ToolImpl
