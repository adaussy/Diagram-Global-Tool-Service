/**
 */
package DiagramGlobalToolService;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool Meta Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DiagramGlobalToolService.ToolMetaModel#getMetaModel <em>Meta Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getToolMetaModel()
 * @model
 * @generated
 */
public interface ToolMetaModel extends AbstractTool {
        /**
         * Returns the value of the '<em><b>Meta Model</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Meta Model</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Meta Model</em>' attribute.
         * @see #setMetaModel(String)
         * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage#getToolMetaModel_MetaModel()
         * @model
         * @generated
         */
        String getMetaModel();

        /**
         * Sets the value of the '{@link DiagramGlobalToolService.ToolMetaModel#getMetaModel <em>Meta Model</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Meta Model</em>' attribute.
         * @see #getMetaModel()
         * @generated
         */
        void setMetaModel(String value);

} // ToolMetaModel
