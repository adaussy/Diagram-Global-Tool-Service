/**
 */
package DiagramGlobalToolService;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see DiagramGlobalToolService.DiagramGlobalToolServiceFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramGlobalToolServicePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DiagramGlobalToolService";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://DiagramGlobalToolService/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "DiagramGlobalToolService";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramGlobalToolServicePackage eINSTANCE = DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl.init();

	/**
	 * The meta object id for the '{@link DiagramGlobalToolService.impl.DiagramDefinitionImpl <em>Diagram Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagramGlobalToolService.impl.DiagramDefinitionImpl
	 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getDiagramDefinition()
	 * @generated
	 */
	int DIAGRAM_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION__EREFERENCE0 = 0;

	/**
	 * The feature id for the '<em><b>Diagram Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION__DIAGRAM_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Diagram Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Diagram Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagramGlobalToolService.impl.DrawerDefinitionImpl <em>Drawer Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagramGlobalToolService.impl.DrawerDefinitionImpl
	 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getDrawerDefinition()
	 * @generated
	 */
	int DRAWER_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION__EREFERENCE0 = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION__NAME = 1;

	/**
	 * The number of structural features of the '<em>Drawer Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Drawer Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagramGlobalToolService.impl.ToolElementImpl <em>Tool Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagramGlobalToolService.impl.ToolElementImpl
	 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getToolElement()
	 * @generated
	 */
	int TOOL_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__EANNOTATIONS = UMLPackage.PACKAGE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__OWNED_COMMENT = UMLPackage.PACKAGE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__OWNED_ELEMENT = UMLPackage.PACKAGE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__OWNER = UMLPackage.PACKAGE__OWNER;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__CLIENT_DEPENDENCY = UMLPackage.PACKAGE__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__NAME = UMLPackage.PACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__NAME_EXPRESSION = UMLPackage.PACKAGE__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__NAMESPACE = UMLPackage.PACKAGE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__QUALIFIED_NAME = UMLPackage.PACKAGE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__VISIBILITY = UMLPackage.PACKAGE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__ELEMENT_IMPORT = UMLPackage.PACKAGE__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__PACKAGE_IMPORT = UMLPackage.PACKAGE__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__OWNED_RULE = UMLPackage.PACKAGE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__OWNED_MEMBER = UMLPackage.PACKAGE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__IMPORTED_MEMBER = UMLPackage.PACKAGE__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__MEMBER = UMLPackage.PACKAGE__MEMBER;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__OWNING_TEMPLATE_PARAMETER = UMLPackage.PACKAGE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__TEMPLATE_PARAMETER = UMLPackage.PACKAGE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__OWNED_TEMPLATE_SIGNATURE = UMLPackage.PACKAGE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__TEMPLATE_BINDING = UMLPackage.PACKAGE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__URI = UMLPackage.PACKAGE__URI;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__NESTED_PACKAGE = UMLPackage.PACKAGE__NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Nesting Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__NESTING_PACKAGE = UMLPackage.PACKAGE__NESTING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Owned Stereotype</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__OWNED_STEREOTYPE = UMLPackage.PACKAGE__OWNED_STEREOTYPE;

	/**
	 * The feature id for the '<em><b>Package Merge</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__PACKAGE_MERGE = UMLPackage.PACKAGE__PACKAGE_MERGE;

	/**
	 * The feature id for the '<em><b>Packaged Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__PACKAGED_ELEMENT = UMLPackage.PACKAGE__PACKAGED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Profile Application</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__PROFILE_APPLICATION = UMLPackage.PACKAGE__PROFILE_APPLICATION;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT__OWNED_TYPE = UMLPackage.PACKAGE__OWNED_TYPE;

	/**
	 * The number of structural features of the '<em>Tool Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT_FEATURE_COUNT = UMLPackage.PACKAGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_EANNOTATION__STRING = UMLPackage.PACKAGE___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Validate Has Owner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___VALIDATE_HAS_OWNER__DIAGNOSTICCHAIN_MAP = UMLPackage.PACKAGE___VALIDATE_HAS_OWNER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = UMLPackage.PACKAGE___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Add Keyword</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___ADD_KEYWORD__STRING = UMLPackage.PACKAGE___ADD_KEYWORD__STRING;

	/**
	 * The operation id for the '<em>Apply Stereotype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___APPLY_STEREOTYPE__STEREOTYPE = UMLPackage.PACKAGE___APPLY_STEREOTYPE__STEREOTYPE;

	/**
	 * The operation id for the '<em>Create EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___CREATE_EANNOTATION__STRING = UMLPackage.PACKAGE___CREATE_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Destroy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___DESTROY = UMLPackage.PACKAGE___DESTROY;

	/**
	 * The operation id for the '<em>Get Keywords</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_KEYWORDS = UMLPackage.PACKAGE___GET_KEYWORDS;

	/**
	 * The operation id for the '<em>Get Applicable Stereotype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_APPLICABLE_STEREOTYPE__STRING = UMLPackage.PACKAGE___GET_APPLICABLE_STEREOTYPE__STRING;

	/**
	 * The operation id for the '<em>Get Applicable Stereotypes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_APPLICABLE_STEREOTYPES = UMLPackage.PACKAGE___GET_APPLICABLE_STEREOTYPES;

	/**
	 * The operation id for the '<em>Get Applied Stereotype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_APPLIED_STEREOTYPE__STRING = UMLPackage.PACKAGE___GET_APPLIED_STEREOTYPE__STRING;

	/**
	 * The operation id for the '<em>Get Applied Stereotypes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_APPLIED_STEREOTYPES = UMLPackage.PACKAGE___GET_APPLIED_STEREOTYPES;

	/**
	 * The operation id for the '<em>Get Applied Substereotype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_APPLIED_SUBSTEREOTYPE__STEREOTYPE_STRING = UMLPackage.PACKAGE___GET_APPLIED_SUBSTEREOTYPE__STEREOTYPE_STRING;

	/**
	 * The operation id for the '<em>Get Applied Substereotypes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_APPLIED_SUBSTEREOTYPES__STEREOTYPE = UMLPackage.PACKAGE___GET_APPLIED_SUBSTEREOTYPES__STEREOTYPE;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_MODEL = UMLPackage.PACKAGE___GET_MODEL;

	/**
	 * The operation id for the '<em>Get Nearest Package</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_NEAREST_PACKAGE = UMLPackage.PACKAGE___GET_NEAREST_PACKAGE;

	/**
	 * The operation id for the '<em>Get Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_RELATIONSHIPS = UMLPackage.PACKAGE___GET_RELATIONSHIPS;

	/**
	 * The operation id for the '<em>Get Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_RELATIONSHIPS__ECLASS = UMLPackage.PACKAGE___GET_RELATIONSHIPS__ECLASS;

	/**
	 * The operation id for the '<em>Get Required Stereotype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_REQUIRED_STEREOTYPE__STRING = UMLPackage.PACKAGE___GET_REQUIRED_STEREOTYPE__STRING;

	/**
	 * The operation id for the '<em>Get Required Stereotypes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_REQUIRED_STEREOTYPES = UMLPackage.PACKAGE___GET_REQUIRED_STEREOTYPES;

	/**
	 * The operation id for the '<em>Get Source Directed Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_SOURCE_DIRECTED_RELATIONSHIPS = UMLPackage.PACKAGE___GET_SOURCE_DIRECTED_RELATIONSHIPS;

	/**
	 * The operation id for the '<em>Get Source Directed Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_SOURCE_DIRECTED_RELATIONSHIPS__ECLASS = UMLPackage.PACKAGE___GET_SOURCE_DIRECTED_RELATIONSHIPS__ECLASS;

	/**
	 * The operation id for the '<em>Get Stereotype Application</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_STEREOTYPE_APPLICATION__STEREOTYPE = UMLPackage.PACKAGE___GET_STEREOTYPE_APPLICATION__STEREOTYPE;

	/**
	 * The operation id for the '<em>Get Stereotype Applications</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_STEREOTYPE_APPLICATIONS = UMLPackage.PACKAGE___GET_STEREOTYPE_APPLICATIONS;

	/**
	 * The operation id for the '<em>Get Target Directed Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_TARGET_DIRECTED_RELATIONSHIPS = UMLPackage.PACKAGE___GET_TARGET_DIRECTED_RELATIONSHIPS;

	/**
	 * The operation id for the '<em>Get Target Directed Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_TARGET_DIRECTED_RELATIONSHIPS__ECLASS = UMLPackage.PACKAGE___GET_TARGET_DIRECTED_RELATIONSHIPS__ECLASS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_VALUE__STEREOTYPE_STRING = UMLPackage.PACKAGE___GET_VALUE__STEREOTYPE_STRING;

	/**
	 * The operation id for the '<em>Has Keyword</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___HAS_KEYWORD__STRING = UMLPackage.PACKAGE___HAS_KEYWORD__STRING;

	/**
	 * The operation id for the '<em>Has Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___HAS_VALUE__STEREOTYPE_STRING = UMLPackage.PACKAGE___HAS_VALUE__STEREOTYPE_STRING;

	/**
	 * The operation id for the '<em>Is Stereotype Applicable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___IS_STEREOTYPE_APPLICABLE__STEREOTYPE = UMLPackage.PACKAGE___IS_STEREOTYPE_APPLICABLE__STEREOTYPE;

	/**
	 * The operation id for the '<em>Is Stereotype Applied</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___IS_STEREOTYPE_APPLIED__STEREOTYPE = UMLPackage.PACKAGE___IS_STEREOTYPE_APPLIED__STEREOTYPE;

	/**
	 * The operation id for the '<em>Is Stereotype Required</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___IS_STEREOTYPE_REQUIRED__STEREOTYPE = UMLPackage.PACKAGE___IS_STEREOTYPE_REQUIRED__STEREOTYPE;

	/**
	 * The operation id for the '<em>Remove Keyword</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___REMOVE_KEYWORD__STRING = UMLPackage.PACKAGE___REMOVE_KEYWORD__STRING;

	/**
	 * The operation id for the '<em>Set Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___SET_VALUE__STEREOTYPE_STRING_OBJECT = UMLPackage.PACKAGE___SET_VALUE__STEREOTYPE_STRING_OBJECT;

	/**
	 * The operation id for the '<em>Unapply Stereotype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___UNAPPLY_STEREOTYPE__STEREOTYPE = UMLPackage.PACKAGE___UNAPPLY_STEREOTYPE__STEREOTYPE;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___ALL_OWNED_ELEMENTS = UMLPackage.PACKAGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Must Be Owned</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___MUST_BE_OWNED = UMLPackage.PACKAGE___MUST_BE_OWNED;

	/**
	 * The operation id for the '<em>Validate Has Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___VALIDATE_HAS_QUALIFIED_NAME__DIAGNOSTICCHAIN_MAP = UMLPackage.PACKAGE___VALIDATE_HAS_QUALIFIED_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Has No Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___VALIDATE_HAS_NO_QUALIFIED_NAME__DIAGNOSTICCHAIN_MAP = UMLPackage.PACKAGE___VALIDATE_HAS_NO_QUALIFIED_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Visibility Needs Ownership</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___VALIDATE_VISIBILITY_NEEDS_OWNERSHIP__DIAGNOSTICCHAIN_MAP = UMLPackage.PACKAGE___VALIDATE_VISIBILITY_NEEDS_OWNERSHIP__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Create Dependency</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___CREATE_DEPENDENCY__NAMEDELEMENT = UMLPackage.PACKAGE___CREATE_DEPENDENCY__NAMEDELEMENT;

	/**
	 * The operation id for the '<em>Create Usage</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___CREATE_USAGE__NAMEDELEMENT = UMLPackage.PACKAGE___CREATE_USAGE__NAMEDELEMENT;

	/**
	 * The operation id for the '<em>Get Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_LABEL = UMLPackage.PACKAGE___GET_LABEL;

	/**
	 * The operation id for the '<em>Get Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_LABEL__BOOLEAN = UMLPackage.PACKAGE___GET_LABEL__BOOLEAN;

	/**
	 * The operation id for the '<em>All Namespaces</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___ALL_NAMESPACES = UMLPackage.PACKAGE___ALL_NAMESPACES;

	/**
	 * The operation id for the '<em>All Owning Packages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___ALL_OWNING_PACKAGES = UMLPackage.PACKAGE___ALL_OWNING_PACKAGES;

	/**
	 * The operation id for the '<em>Is Distinguishable From</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___IS_DISTINGUISHABLE_FROM__NAMEDELEMENT_NAMESPACE = UMLPackage.PACKAGE___IS_DISTINGUISHABLE_FROM__NAMEDELEMENT_NAMESPACE;

	/**
	 * The operation id for the '<em>Get Namespace</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_NAMESPACE = UMLPackage.PACKAGE___GET_NAMESPACE;

	/**
	 * The operation id for the '<em>Get Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_QUALIFIED_NAME = UMLPackage.PACKAGE___GET_QUALIFIED_NAME;

	/**
	 * The operation id for the '<em>Separator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___SEPARATOR = UMLPackage.PACKAGE___SEPARATOR;

	/**
	 * The operation id for the '<em>Validate Members Distinguishable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___VALIDATE_MEMBERS_DISTINGUISHABLE__DIAGNOSTICCHAIN_MAP = UMLPackage.PACKAGE___VALIDATE_MEMBERS_DISTINGUISHABLE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Create Element Import</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___CREATE_ELEMENT_IMPORT__PACKAGEABLEELEMENT_VISIBILITYKIND = UMLPackage.PACKAGE___CREATE_ELEMENT_IMPORT__PACKAGEABLEELEMENT_VISIBILITYKIND;

	/**
	 * The operation id for the '<em>Create Package Import</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___CREATE_PACKAGE_IMPORT__PACKAGE_VISIBILITYKIND = UMLPackage.PACKAGE___CREATE_PACKAGE_IMPORT__PACKAGE_VISIBILITYKIND;

	/**
	 * The operation id for the '<em>Get Imported Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_IMPORTED_ELEMENTS = UMLPackage.PACKAGE___GET_IMPORTED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Imported Packages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_IMPORTED_PACKAGES = UMLPackage.PACKAGE___GET_IMPORTED_PACKAGES;

	/**
	 * The operation id for the '<em>Exclude Collisions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___EXCLUDE_COLLISIONS__ELIST = UMLPackage.PACKAGE___EXCLUDE_COLLISIONS__ELIST;

	/**
	 * The operation id for the '<em>Get Names Of Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_NAMES_OF_MEMBER__NAMEDELEMENT = UMLPackage.PACKAGE___GET_NAMES_OF_MEMBER__NAMEDELEMENT;

	/**
	 * The operation id for the '<em>Import Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___IMPORT_MEMBERS__ELIST = UMLPackage.PACKAGE___IMPORT_MEMBERS__ELIST;

	/**
	 * The operation id for the '<em>Get Imported Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_IMPORTED_MEMBERS = UMLPackage.PACKAGE___GET_IMPORTED_MEMBERS;

	/**
	 * The operation id for the '<em>Members Are Distinguishable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___MEMBERS_ARE_DISTINGUISHABLE = UMLPackage.PACKAGE___MEMBERS_ARE_DISTINGUISHABLE;

	/**
	 * The operation id for the '<em>Get Owned Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_OWNED_MEMBERS = UMLPackage.PACKAGE___GET_OWNED_MEMBERS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = UMLPackage.PACKAGE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___IS_TEMPLATE_PARAMETER = UMLPackage.PACKAGE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___IS_TEMPLATE = UMLPackage.PACKAGE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___PARAMETERABLE_ELEMENTS = UMLPackage.PACKAGE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Validate Elements Public Or Private</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___VALIDATE_ELEMENTS_PUBLIC_OR_PRIVATE__DIAGNOSTICCHAIN_MAP = UMLPackage.PACKAGE___VALIDATE_ELEMENTS_PUBLIC_OR_PRIVATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Apply Profile</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___APPLY_PROFILE__PROFILE = UMLPackage.PACKAGE___APPLY_PROFILE__PROFILE;

	/**
	 * The operation id for the '<em>Create Owned Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___CREATE_OWNED_CLASS__STRING_BOOLEAN = UMLPackage.PACKAGE___CREATE_OWNED_CLASS__STRING_BOOLEAN;

	/**
	 * The operation id for the '<em>Create Owned Enumeration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___CREATE_OWNED_ENUMERATION__STRING = UMLPackage.PACKAGE___CREATE_OWNED_ENUMERATION__STRING;

	/**
	 * The operation id for the '<em>Create Owned Interface</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___CREATE_OWNED_INTERFACE__STRING = UMLPackage.PACKAGE___CREATE_OWNED_INTERFACE__STRING;

	/**
	 * The operation id for the '<em>Create Owned Primitive Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___CREATE_OWNED_PRIMITIVE_TYPE__STRING = UMLPackage.PACKAGE___CREATE_OWNED_PRIMITIVE_TYPE__STRING;

	/**
	 * The operation id for the '<em>Create Owned Stereotype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___CREATE_OWNED_STEREOTYPE__STRING_BOOLEAN = UMLPackage.PACKAGE___CREATE_OWNED_STEREOTYPE__STRING_BOOLEAN;

	/**
	 * The operation id for the '<em>Get All Applied Profiles</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_ALL_APPLIED_PROFILES = UMLPackage.PACKAGE___GET_ALL_APPLIED_PROFILES;

	/**
	 * The operation id for the '<em>Get All Profile Applications</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_ALL_PROFILE_APPLICATIONS = UMLPackage.PACKAGE___GET_ALL_PROFILE_APPLICATIONS;

	/**
	 * The operation id for the '<em>Get Applied Profile</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_APPLIED_PROFILE__STRING = UMLPackage.PACKAGE___GET_APPLIED_PROFILE__STRING;

	/**
	 * The operation id for the '<em>Get Applied Profile</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_APPLIED_PROFILE__STRING_BOOLEAN = UMLPackage.PACKAGE___GET_APPLIED_PROFILE__STRING_BOOLEAN;

	/**
	 * The operation id for the '<em>Get Applied Profiles</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_APPLIED_PROFILES = UMLPackage.PACKAGE___GET_APPLIED_PROFILES;

	/**
	 * The operation id for the '<em>Get Profile Application</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_PROFILE_APPLICATION__PROFILE = UMLPackage.PACKAGE___GET_PROFILE_APPLICATION__PROFILE;

	/**
	 * The operation id for the '<em>Get Profile Application</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_PROFILE_APPLICATION__PROFILE_BOOLEAN = UMLPackage.PACKAGE___GET_PROFILE_APPLICATION__PROFILE_BOOLEAN;

	/**
	 * The operation id for the '<em>Is Model Library</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___IS_MODEL_LIBRARY = UMLPackage.PACKAGE___IS_MODEL_LIBRARY;

	/**
	 * The operation id for the '<em>Is Profile Applied</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___IS_PROFILE_APPLIED__PROFILE = UMLPackage.PACKAGE___IS_PROFILE_APPLIED__PROFILE;

	/**
	 * The operation id for the '<em>Unapply Profile</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___UNAPPLY_PROFILE__PROFILE = UMLPackage.PACKAGE___UNAPPLY_PROFILE__PROFILE;

	/**
	 * The operation id for the '<em>All Applicable Stereotypes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___ALL_APPLICABLE_STEREOTYPES = UMLPackage.PACKAGE___ALL_APPLICABLE_STEREOTYPES;

	/**
	 * The operation id for the '<em>Containing Profile</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___CONTAINING_PROFILE = UMLPackage.PACKAGE___CONTAINING_PROFILE;

	/**
	 * The operation id for the '<em>Makes Visible</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___MAKES_VISIBLE__NAMEDELEMENT = UMLPackage.PACKAGE___MAKES_VISIBLE__NAMEDELEMENT;

	/**
	 * The operation id for the '<em>Get Nested Packages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_NESTED_PACKAGES = UMLPackage.PACKAGE___GET_NESTED_PACKAGES;

	/**
	 * The operation id for the '<em>Get Owned Stereotypes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_OWNED_STEREOTYPES = UMLPackage.PACKAGE___GET_OWNED_STEREOTYPES;

	/**
	 * The operation id for the '<em>Get Owned Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___GET_OWNED_TYPES = UMLPackage.PACKAGE___GET_OWNED_TYPES;

	/**
	 * The operation id for the '<em>Visible Members</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT___VISIBLE_MEMBERS = UMLPackage.PACKAGE___VISIBLE_MEMBERS;

	/**
	 * The number of operations of the '<em>Tool Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ELEMENT_OPERATION_COUNT = UMLPackage.PACKAGE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link DiagramGlobalToolService.DiagramDefinition <em>Diagram Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Definition</em>'.
	 * @see DiagramGlobalToolService.DiagramDefinition
	 * @generated
	 */
	EClass getDiagramDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagramGlobalToolService.DiagramDefinition#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EReference0</em>'.
	 * @see DiagramGlobalToolService.DiagramDefinition#getEReference0()
	 * @see #getDiagramDefinition()
	 * @generated
	 */
	EReference getDiagramDefinition_EReference0();

	/**
	 * Returns the meta object for the attribute '{@link DiagramGlobalToolService.DiagramDefinition#getDiagramType <em>Diagram Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Type</em>'.
	 * @see DiagramGlobalToolService.DiagramDefinition#getDiagramType()
	 * @see #getDiagramDefinition()
	 * @generated
	 */
	EAttribute getDiagramDefinition_DiagramType();

	/**
	 * Returns the meta object for class '{@link DiagramGlobalToolService.DrawerDefinition <em>Drawer Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drawer Definition</em>'.
	 * @see DiagramGlobalToolService.DrawerDefinition
	 * @generated
	 */
	EClass getDrawerDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagramGlobalToolService.DrawerDefinition#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EReference0</em>'.
	 * @see DiagramGlobalToolService.DrawerDefinition#getEReference0()
	 * @see #getDrawerDefinition()
	 * @generated
	 */
	EReference getDrawerDefinition_EReference0();

	/**
	 * Returns the meta object for the attribute '{@link DiagramGlobalToolService.DrawerDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DiagramGlobalToolService.DrawerDefinition#getName()
	 * @see #getDrawerDefinition()
	 * @generated
	 */
	EAttribute getDrawerDefinition_Name();

	/**
	 * Returns the meta object for class '{@link DiagramGlobalToolService.ToolElement <em>Tool Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool Element</em>'.
	 * @see DiagramGlobalToolService.ToolElement
	 * @generated
	 */
	EClass getToolElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagramGlobalToolServiceFactory getDiagramGlobalToolServiceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link DiagramGlobalToolService.impl.DiagramDefinitionImpl <em>Diagram Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagramGlobalToolService.impl.DiagramDefinitionImpl
		 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getDiagramDefinition()
		 * @generated
		 */
		EClass DIAGRAM_DEFINITION = eINSTANCE.getDiagramDefinition();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_DEFINITION__EREFERENCE0 = eINSTANCE.getDiagramDefinition_EReference0();

		/**
		 * The meta object literal for the '<em><b>Diagram Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_DEFINITION__DIAGRAM_TYPE = eINSTANCE.getDiagramDefinition_DiagramType();

		/**
		 * The meta object literal for the '{@link DiagramGlobalToolService.impl.DrawerDefinitionImpl <em>Drawer Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagramGlobalToolService.impl.DrawerDefinitionImpl
		 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getDrawerDefinition()
		 * @generated
		 */
		EClass DRAWER_DEFINITION = eINSTANCE.getDrawerDefinition();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRAWER_DEFINITION__EREFERENCE0 = eINSTANCE.getDrawerDefinition_EReference0();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAWER_DEFINITION__NAME = eINSTANCE.getDrawerDefinition_Name();

		/**
		 * The meta object literal for the '{@link DiagramGlobalToolService.impl.ToolElementImpl <em>Tool Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagramGlobalToolService.impl.ToolElementImpl
		 * @see DiagramGlobalToolService.impl.DiagramGlobalToolServicePackageImpl#getToolElement()
		 * @generated
		 */
		EClass TOOL_ELEMENT = eINSTANCE.getToolElement();

	}

} //DiagramGlobalToolServicePackage
