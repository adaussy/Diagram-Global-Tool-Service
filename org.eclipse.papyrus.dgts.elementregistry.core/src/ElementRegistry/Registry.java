/**
 */
package ElementRegistry;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ElementRegistry.Registry#getRefDiagrams <em>Ref Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @see ElementRegistry.ElementRegistryPackage#getRegistry()
 * @model
 * @generated
 */
public interface Registry extends EObject {
        /**
         * Returns the value of the '<em><b>Ref Diagrams</b></em>' containment reference list.
         * The list contents are of type {@link ElementRegistry.DiagramDefinition}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Ref Diagrams</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Ref Diagrams</em>' containment reference list.
         * @see ElementRegistry.ElementRegistryPackage#getRegistry_RefDiagrams()
         * @model containment="true"
         * @generated
         */
        EList<DiagramDefinition> getRefDiagrams();

} // Registry
