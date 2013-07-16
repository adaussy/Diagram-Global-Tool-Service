/**
 */
package DiagramGlobalToolService.util;

import DiagramGlobalToolService.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see DiagramGlobalToolService.DiagramGlobalToolServicePackage
 * @generated
 */
public class DiagramGlobalToolServiceSwitch<T> extends Switch<T> {
        /**
         * The cached model package
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected static DiagramGlobalToolServicePackage modelPackage;

        /**
         * Creates an instance of the switch.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public DiagramGlobalToolServiceSwitch() {
                if (modelPackage == null) {
                        modelPackage = DiagramGlobalToolServicePackage.eINSTANCE;
                }
        }

        /**
         * Checks whether this is a switch for the given package.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @parameter ePackage the package in question.
         * @return whether this is a switch for the given package.
         * @generated
         */
        @Override
        protected boolean isSwitchFor(EPackage ePackage) {
                return ePackage == modelPackage;
        }

        /**
         * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the first non-null result returned by a <code>caseXXX</code> call.
         * @generated
         */
        @Override
        protected T doSwitch(int classifierID, EObject theEObject) {
                switch (classifierID) {
                        case DiagramGlobalToolServicePackage.DIAGRAM_GLOBAL_TOOL_DEFINITION: {
                                DiagramGlobalToolDefinition diagramGlobalToolDefinition = (DiagramGlobalToolDefinition)theEObject;
                                T result = caseDiagramGlobalToolDefinition(diagramGlobalToolDefinition);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case DiagramGlobalToolServicePackage.DIAGRAM_DEFINITION: {
                                DiagramDefinition diagramDefinition = (DiagramDefinition)theEObject;
                                T result = caseDiagramDefinition(diagramDefinition);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case DiagramGlobalToolServicePackage.DRAWER_DEFINITION: {
                                DrawerDefinition drawerDefinition = (DrawerDefinition)theEObject;
                                T result = caseDrawerDefinition(drawerDefinition);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case DiagramGlobalToolServicePackage.ABSTRACT_TOOL: {
                                AbstractTool abstractTool = (AbstractTool)theEObject;
                                T result = caseAbstractTool(abstractTool);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case DiagramGlobalToolServicePackage.TOOL: {
                                Tool tool = (Tool)theEObject;
                                T result = caseTool(tool);
                                if (result == null) result = caseAbstractTool(tool);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case DiagramGlobalToolServicePackage.ELEMENT_TYPE: {
                                ElementType elementType = (ElementType)theEObject;
                                T result = caseElementType(elementType);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case DiagramGlobalToolServicePackage.TOOL_META_MODEL: {
                                ToolMetaModel toolMetaModel = (ToolMetaModel)theEObject;
                                T result = caseToolMetaModel(toolMetaModel);
                                if (result == null) result = caseAbstractTool(toolMetaModel);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        default: return defaultCase(theEObject);
                }
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Diagram Global Tool Definition</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Diagram Global Tool Definition</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseDiagramGlobalToolDefinition(DiagramGlobalToolDefinition object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Diagram Definition</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Diagram Definition</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseDiagramDefinition(DiagramDefinition object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Drawer Definition</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Drawer Definition</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseDrawerDefinition(DrawerDefinition object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Abstract Tool</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Abstract Tool</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseAbstractTool(AbstractTool object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Tool</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Tool</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseTool(Tool object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Element Type</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Element Type</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseElementType(ElementType object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Tool Meta Model</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Tool Meta Model</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseToolMetaModel(ToolMetaModel object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch, but this is the last case anyway.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject)
         * @generated
         */
        @Override
        public T defaultCase(EObject object) {
                return null;
        }

} //DiagramGlobalToolServiceSwitch
