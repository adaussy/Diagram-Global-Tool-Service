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

import DiagramGlobalToolService.DiagramDefinition;
import DiagramGlobalToolService.DiagramGlobalToolDefinition;
import DiagramGlobalToolService.DiagramGlobalToolServicePackage;

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
 * An implementation of the model object '<em><b>Diagram Global Tool Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.impl.DiagramGlobalToolDefinitionImpl#getDiagramDefinitionRef <em>Diagram Definition Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramGlobalToolDefinitionImpl extends MinimalEObjectImpl.Container implements DiagramGlobalToolDefinition {
	/**
	 * The cached value of the '{@link #getDiagramDefinitionRef() <em>Diagram Definition Ref</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramDefinitionRef()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagramDefinition> diagramDefinitionRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramGlobalToolDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramGlobalToolServicePackage.Literals.DIAGRAM_GLOBAL_TOOL_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiagramDefinition> getDiagramDefinitionRef() {
		if (diagramDefinitionRef == null) {
			diagramDefinitionRef = new EObjectContainmentEList<DiagramDefinition>(DiagramDefinition.class, this, DiagramGlobalToolServicePackage.DIAGRAM_GLOBAL_TOOL_DEFINITION__DIAGRAM_DEFINITION_REF);
		}
		return diagramDefinitionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramGlobalToolServicePackage.DIAGRAM_GLOBAL_TOOL_DEFINITION__DIAGRAM_DEFINITION_REF:
				return ((InternalEList<?>)getDiagramDefinitionRef()).basicRemove(otherEnd, msgs);
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
			case DiagramGlobalToolServicePackage.DIAGRAM_GLOBAL_TOOL_DEFINITION__DIAGRAM_DEFINITION_REF:
				return getDiagramDefinitionRef();
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
			case DiagramGlobalToolServicePackage.DIAGRAM_GLOBAL_TOOL_DEFINITION__DIAGRAM_DEFINITION_REF:
				getDiagramDefinitionRef().clear();
				getDiagramDefinitionRef().addAll((Collection<? extends DiagramDefinition>)newValue);
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
			case DiagramGlobalToolServicePackage.DIAGRAM_GLOBAL_TOOL_DEFINITION__DIAGRAM_DEFINITION_REF:
				getDiagramDefinitionRef().clear();
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
			case DiagramGlobalToolServicePackage.DIAGRAM_GLOBAL_TOOL_DEFINITION__DIAGRAM_DEFINITION_REF:
				return diagramDefinitionRef != null && !diagramDefinitionRef.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DiagramGlobalToolDefinitionImpl
