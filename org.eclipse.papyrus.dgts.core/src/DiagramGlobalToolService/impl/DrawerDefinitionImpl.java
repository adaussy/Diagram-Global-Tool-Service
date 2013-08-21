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
import DiagramGlobalToolService.DrawerDefinition;
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
 * An implementation of the model object '<em><b>Drawer Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.impl.DrawerDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.DrawerDefinitionImpl#getToolRef <em>Tool Ref</em>}</li>
 *   <li>{@link DiagramGlobalToolService.impl.DrawerDefinitionImpl#getIconReference <em>Icon Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DrawerDefinitionImpl extends MinimalEObjectImpl.Container implements DrawerDefinition {
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
	 * The cached value of the '{@link #getToolRef() <em>Tool Ref</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToolRef()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> toolRef;

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
	protected DrawerDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramGlobalToolServicePackage.Literals.DRAWER_DEFINITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.DRAWER_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tool> getToolRef() {
		if (toolRef == null) {
			toolRef = new EObjectContainmentEList<Tool>(Tool.class, this, DiagramGlobalToolServicePackage.DRAWER_DEFINITION__TOOL_REF);
		}
		return toolRef;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.DRAWER_DEFINITION__ICON_REFERENCE, oldIconReference, newIconReference);
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
				msgs = ((InternalEObject)iconReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramGlobalToolServicePackage.DRAWER_DEFINITION__ICON_REFERENCE, null, msgs);
			if (newIconReference != null)
				msgs = ((InternalEObject)newIconReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramGlobalToolServicePackage.DRAWER_DEFINITION__ICON_REFERENCE, null, msgs);
			msgs = basicSetIconReference(newIconReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramGlobalToolServicePackage.DRAWER_DEFINITION__ICON_REFERENCE, newIconReference, newIconReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__TOOL_REF:
				return ((InternalEList<?>)getToolRef()).basicRemove(otherEnd, msgs);
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__ICON_REFERENCE:
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
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__NAME:
				return getName();
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__TOOL_REF:
				return getToolRef();
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__ICON_REFERENCE:
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
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__TOOL_REF:
				getToolRef().clear();
				getToolRef().addAll((Collection<? extends Tool>)newValue);
				return;
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__ICON_REFERENCE:
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
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__TOOL_REF:
				getToolRef().clear();
				return;
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__ICON_REFERENCE:
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
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__TOOL_REF:
				return toolRef != null && !toolRef.isEmpty();
			case DiagramGlobalToolServicePackage.DRAWER_DEFINITION__ICON_REFERENCE:
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
		result.append(" (Name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //DrawerDefinitionImpl
