/**
 */
package ElementRegistry;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Context</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see ElementRegistry.ElementRegistryPackage#getContext()
 * @model
 * @generated
 */
public enum Context implements Enumerator {
        /**
         * The '<em><b>Diagram</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #DIAGRAM_VALUE
         * @generated
         * @ordered
         */
        DIAGRAM(0, "Diagram", "Diagram"),

        /**
         * The '<em><b>Model Explorer</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #MODEL_EXPLORER_VALUE
         * @generated
         * @ordered
         */
        MODEL_EXPLORER(1, "ModelExplorer", "ModelExplorer"), /**
         * The '<em><b>Diagram And Model Explorer</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #DIAGRAM_AND_MODEL_EXPLORER_VALUE
         * @generated
         * @ordered
         */
        DIAGRAM_AND_MODEL_EXPLORER(2, "DiagramAndModelExplorer", "DiagramAndModelExplorer");

        /**
         * The '<em><b>Diagram</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Diagram</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #DIAGRAM
         * @model name="Diagram"
         * @generated
         * @ordered
         */
        public static final int DIAGRAM_VALUE = 0;

        /**
         * The '<em><b>Model Explorer</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Model Explorer</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #MODEL_EXPLORER
         * @model name="ModelExplorer"
         * @generated
         * @ordered
         */
        public static final int MODEL_EXPLORER_VALUE = 1;

        /**
         * The '<em><b>Diagram And Model Explorer</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Diagram And Model Explorer</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #DIAGRAM_AND_MODEL_EXPLORER
         * @model name="DiagramAndModelExplorer"
         * @generated
         * @ordered
         */
        public static final int DIAGRAM_AND_MODEL_EXPLORER_VALUE = 2;

        /**
         * An array of all the '<em><b>Context</b></em>' enumerators.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private static final Context[] VALUES_ARRAY =
                new Context[] {
                        DIAGRAM,
                        MODEL_EXPLORER,
                        DIAGRAM_AND_MODEL_EXPLORER,
                };

        /**
         * A public read-only list of all the '<em><b>Context</b></em>' enumerators.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static final List<Context> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

        /**
         * Returns the '<em><b>Context</b></em>' literal with the specified literal value.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static Context get(String literal) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        Context result = VALUES_ARRAY[i];
                        if (result.toString().equals(literal)) {
                                return result;
                        }
                }
                return null;
        }

        /**
         * Returns the '<em><b>Context</b></em>' literal with the specified name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static Context getByName(String name) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        Context result = VALUES_ARRAY[i];
                        if (result.getName().equals(name)) {
                                return result;
                        }
                }
                return null;
        }

        /**
         * Returns the '<em><b>Context</b></em>' literal with the specified integer value.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static Context get(int value) {
                switch (value) {
                        case DIAGRAM_VALUE: return DIAGRAM;
                        case MODEL_EXPLORER_VALUE: return MODEL_EXPLORER;
                        case DIAGRAM_AND_MODEL_EXPLORER_VALUE: return DIAGRAM_AND_MODEL_EXPLORER;
                }
                return null;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private final int value;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private final String name;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private final String literal;

        /**
         * Only this class can construct instances.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private Context(int value, String name, String literal) {
                this.value = value;
                this.name = name;
                this.literal = literal;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public int getValue() {
          return value;
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
        public String getLiteral() {
          return literal;
        }

        /**
         * Returns the literal value of the enumerator, which is its string representation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public String toString() {
                return literal;
        }
        
} //Context
