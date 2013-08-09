/**
 */
package ElementRegistry;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EClass Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ElementRegistry.EClassDefinition#getRefElementTypes <em>Ref Element Types</em>}</li>
 *   <li>{@link ElementRegistry.EClassDefinition#getEClass <em>EClass</em>}</li>
 * </ul>
 * </p>
 *
 * @see ElementRegistry.ElementRegistryPackage#getEClassDefinition()
 * @model
 * @generated
 */
public interface EClassDefinition extends EObject {
        /**
         * Returns the value of the '<em><b>Ref Element Types</b></em>' containment reference list.
         * The list contents are of type {@link ElementRegistry.ElementType}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Ref Element Types</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Ref Element Types</em>' containment reference list.
         * @see ElementRegistry.ElementRegistryPackage#getEClassDefinition_RefElementTypes()
         * @model containment="true"
         * @generated
         */
        EList<ElementType> getRefElementTypes();

        /**
         * Returns the value of the '<em><b>EClass</b></em>' reference.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>EClass</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>EClass</em>' reference.
         * @see #setEClass(EClass)
         * @see ElementRegistry.ElementRegistryPackage#getEClassDefinition_EClass()
         * @model
         * @generated
         */
        EClass getEClass();

        /**
         * Sets the value of the '{@link ElementRegistry.EClassDefinition#getEClass <em>EClass</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>EClass</em>' reference.
         * @see #getEClass()
         * @generated
         */
        void setEClass(EClass value);

} // EClassDefinition
