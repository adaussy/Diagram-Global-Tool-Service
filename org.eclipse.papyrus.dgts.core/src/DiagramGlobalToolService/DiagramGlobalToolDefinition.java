/**
 */
package DiagramGlobalToolService;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Global Tool Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.DiagramGlobalToolDefinition#getDiagramDefinitionRef <em>Diagram Definition Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDiagramGlobalToolDefinition()
 * @model
 * @generated
 */
public interface DiagramGlobalToolDefinition extends EObject {
        /**
	 * Returns the value of the '<em><b>Diagram Definition Ref</b></em>' containment reference list.
	 * The list contents are of type {@link DiagramGlobalToolService.DiagramDefinition}.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Diagram Definition Ref</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Definition Ref</em>' containment reference list.
	 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getDiagramGlobalToolDefinition_DiagramDefinitionRef()
	 * @model containment="true"
	 * @generated
	 */
        EList<DiagramDefinition> getDiagramDefinitionRef();

} // DiagramGlobalToolDefinition
