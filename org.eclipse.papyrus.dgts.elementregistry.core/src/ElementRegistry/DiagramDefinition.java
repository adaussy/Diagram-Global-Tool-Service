/**
 */
package ElementRegistry;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ElementRegistry.DiagramDefinition#getRefEClass <em>Ref EClass</em>}</li>
 *   <li>{@link ElementRegistry.DiagramDefinition#getDiagramType <em>Diagram Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see ElementRegistry.ElementRegistryPackage#getDiagramDefinition()
 * @model
 * @generated
 */
public interface DiagramDefinition extends EObject {
        /**
         * Returns the value of the '<em><b>Ref EClass</b></em>' containment reference list.
         * The list contents are of type {@link ElementRegistry.EClassDefinition}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Ref EClass</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Ref EClass</em>' containment reference list.
         * @see ElementRegistry.ElementRegistryPackage#getDiagramDefinition_RefEClass()
         * @model containment="true"
         * @generated
         */
        EList<EClassDefinition> getRefEClass();

        /**
         * Returns the value of the '<em><b>Diagram Type</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Diagram Type</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Diagram Type</em>' attribute.
         * @see #setDiagramType(String)
         * @see ElementRegistry.ElementRegistryPackage#getDiagramDefinition_DiagramType()
         * @model
         * @generated
         */
        String getDiagramType();

        /**
         * Sets the value of the '{@link ElementRegistry.DiagramDefinition#getDiagramType <em>Diagram Type</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Diagram Type</em>' attribute.
         * @see #getDiagramType()
         * @generated
         */
        void setDiagramType(String value);

} // DiagramDefinition
