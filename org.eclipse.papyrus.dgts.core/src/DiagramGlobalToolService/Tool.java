/**
 */
package DiagramGlobalToolService;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.Tool#getElementTypes <em>Element Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getTool()
 * @model
 * @generated
 */
public interface Tool extends AbstractTool {
        /**
         * Returns the value of the '<em><b>Element Types</b></em>' containment reference list.
         * The list contents are of type {@link DiagramGlobalToolService.ElementType}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Element Types</em>' reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Element Types</em>' containment reference list.
         * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getTool_ElementTypes()
         * @model containment="true"
         * @generated
         */
        EList<ElementType> getElementTypes();

} // Tool
