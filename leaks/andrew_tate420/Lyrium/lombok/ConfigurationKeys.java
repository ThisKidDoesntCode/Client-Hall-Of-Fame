// 
// Decompiled by Procyon v0.5.36
// 

package lombok;

import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.configuration.TypeName;
import lombok.core.configuration.CapitalizationStrategy;
import java.util.List;
import lombok.core.configuration.LogDeclaration;
import lombok.core.configuration.IdentifierName;
import lombok.core.configuration.NullCheckExceptionType;
import lombok.core.configuration.CallSuperType;
import lombok.core.configuration.FlagUsageType;
import lombok.core.configuration.NullAnnotationLibrary;
import lombok.core.configuration.ConfigurationKey;

public class ConfigurationKeys
{
    public static final ConfigurationKey<Boolean> LOMBOK_DISABLE;
    @Deprecated
    public static final ConfigurationKey<Boolean> ADD_GENERATED_ANNOTATIONS;
    public static final ConfigurationKey<Boolean> ADD_JAVAX_GENERATED_ANNOTATIONS;
    public static final ConfigurationKey<Boolean> ADD_LOMBOK_GENERATED_ANNOTATIONS;
    public static final ConfigurationKey<Boolean> ADD_FINDBUGS_SUPPRESSWARNINGS_ANNOTATIONS;
    public static final ConfigurationKey<Boolean> ADD_SUPPRESSWARNINGS_ANNOTATIONS;
    public static final ConfigurationKey<NullAnnotationLibrary> ADD_NULL_ANNOTATIONS;
    public static final ConfigurationKey<FlagUsageType> ANY_CONSTRUCTOR_FLAG_USAGE;
    @Deprecated
    public static final ConfigurationKey<Boolean> ANY_CONSTRUCTOR_SUPPRESS_CONSTRUCTOR_PROPERTIES;
    public static final ConfigurationKey<Boolean> ANY_CONSTRUCTOR_ADD_CONSTRUCTOR_PROPERTIES;
    public static final ConfigurationKey<FlagUsageType> ALL_ARGS_CONSTRUCTOR_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> NO_ARGS_CONSTRUCTOR_FLAG_USAGE;
    public static final ConfigurationKey<Boolean> NO_ARGS_CONSTRUCTOR_EXTRA_PRIVATE;
    public static final ConfigurationKey<FlagUsageType> REQUIRED_ARGS_CONSTRUCTOR_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> DATA_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> VALUE_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> GETTER_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> GETTER_LAZY_FLAG_USAGE;
    public static final ConfigurationKey<Boolean> GETTER_CONSEQUENT_BOOLEAN;
    public static final ConfigurationKey<FlagUsageType> SETTER_FLAG_USAGE;
    public static final ConfigurationKey<Boolean> EQUALS_AND_HASH_CODE_DO_NOT_USE_GETTERS;
    public static final ConfigurationKey<CallSuperType> EQUALS_AND_HASH_CODE_CALL_SUPER;
    public static final ConfigurationKey<FlagUsageType> EQUALS_AND_HASH_CODE_FLAG_USAGE;
    public static final ConfigurationKey<Boolean> TO_STRING_DO_NOT_USE_GETTERS;
    public static final ConfigurationKey<CallSuperType> TO_STRING_CALL_SUPER;
    public static final ConfigurationKey<FlagUsageType> TO_STRING_FLAG_USAGE;
    public static final ConfigurationKey<Boolean> TO_STRING_INCLUDE_FIELD_NAMES;
    public static final ConfigurationKey<Boolean> TO_STRING_ONLY_EXPLICITLY_INCLUDED;
    public static final ConfigurationKey<String> BUILDER_CLASS_NAME;
    public static final ConfigurationKey<FlagUsageType> BUILDER_FLAG_USAGE;
    public static final ConfigurationKey<Boolean> SINGULAR_USE_GUAVA;
    public static final ConfigurationKey<Boolean> SINGULAR_AUTO;
    public static final ConfigurationKey<FlagUsageType> CLEANUP_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> DELEGATE_FLAG_USAGE;
    public static final ConfigurationKey<NullCheckExceptionType> NON_NULL_EXCEPTION_TYPE;
    public static final ConfigurationKey<FlagUsageType> NON_NULL_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> SNEAKY_THROWS_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> SYNCHRONIZED_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> VAL_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> VAR_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> WITH_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> LOG_ANY_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> LOG_COMMONS_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> LOG_JUL_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> LOG_LOG4J_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> LOG_LOG4J2_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> LOG_SLF4J_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> LOG_XSLF4J_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> LOG_JBOSSLOG_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> LOG_FLOGGER_FLAG_USAGE;
    public static final ConfigurationKey<IdentifierName> LOG_ANY_FIELD_NAME;
    public static final ConfigurationKey<Boolean> LOG_ANY_FIELD_IS_STATIC;
    public static final ConfigurationKey<FlagUsageType> LOG_CUSTOM_FLAG_USAGE;
    public static final ConfigurationKey<LogDeclaration> LOG_CUSTOM_DECLARATION;
    public static final ConfigurationKey<FlagUsageType> EXPERIMENTAL_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> ACCESSORS_FLAG_USAGE;
    public static final ConfigurationKey<List<String>> ACCESSORS_PREFIX;
    public static final ConfigurationKey<Boolean> ACCESSORS_CHAIN;
    public static final ConfigurationKey<Boolean> ACCESSORS_FLUENT;
    public static final ConfigurationKey<Boolean> ACCESSORS_MAKE_FINAL;
    public static final ConfigurationKey<CapitalizationStrategy> ACCESSORS_JAVA_BEANS_SPEC_CAPITALIZATION;
    public static final ConfigurationKey<FlagUsageType> EXTENSION_METHOD_FLAG_USAGE;
    public static final ConfigurationKey<Boolean> FIELD_DEFAULTS_PRIVATE_EVERYWHERE;
    public static final ConfigurationKey<Boolean> FIELD_DEFAULTS_FINAL_EVERYWHERE;
    public static final ConfigurationKey<FlagUsageType> FIELD_DEFAULTS_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> HELPER_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> ON_X_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> UTILITY_CLASS_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> FIELD_NAME_CONSTANTS_FLAG_USAGE;
    public static final ConfigurationKey<IdentifierName> FIELD_NAME_CONSTANTS_INNER_TYPE_NAME;
    public static final ConfigurationKey<Boolean> FIELD_NAME_CONSTANTS_UPPERCASE;
    public static final ConfigurationKey<FlagUsageType> SUPERBUILDER_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> WITHBY_FLAG_USAGE;
    public static final ConfigurationKey<FlagUsageType> JACKSONIZED_FLAG_USAGE;
    public static final ConfigurationKey<Boolean> STOP_BUBBLING;
    public static final ConfigurationKey<List<TypeName>> COPYABLE_ANNOTATIONS;
    public static final ConfigurationKey<CheckerFrameworkVersion> CHECKER_FRAMEWORK;
    public static final ConfigurationKey<FlagUsageType> STANDARD_EXCEPTION_FLAG_USAGE;
    
    static {
        LOMBOK_DISABLE = new ConfigurationKey<Boolean>("Disables lombok transformers. It does not flag any lombok mentions (so, @Cleanup silently does nothing), and does not disable patched operations in eclipse either. Don't use this unless you know what you're doing. (default: false).", true) {};
        ADD_GENERATED_ANNOTATIONS = new ConfigurationKey<Boolean>("Generate @javax.annotation.Generated on all generated code (default: false). Deprecated, use 'lombok.addJavaxGeneratedAnnotation' instead.") {};
        ADD_JAVAX_GENERATED_ANNOTATIONS = new ConfigurationKey<Boolean>("Generate @javax.annotation.Generated on all generated code (default: follow lombok.addGeneratedAnnotation).") {};
        ADD_LOMBOK_GENERATED_ANNOTATIONS = new ConfigurationKey<Boolean>("Generate @lombok.Generated on all generated code (default: false).") {};
        ADD_FINDBUGS_SUPPRESSWARNINGS_ANNOTATIONS = new ConfigurationKey<Boolean>("Generate @edu.umd.cs.findbugs.annotations.SuppressFBWarnings on all generated code (default: false).") {};
        ADD_SUPPRESSWARNINGS_ANNOTATIONS = new ConfigurationKey<Boolean>("Generate @java.lang.SuppressWarnings(\"all\") on all generated code (default: true).") {};
        ADD_NULL_ANNOTATIONS = new ConfigurationKey<NullAnnotationLibrary>("Generate some style of null annotation for generated code where this is relevant. (default: none).") {};
        ANY_CONSTRUCTOR_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if any of the XxxArgsConstructor annotations are used.") {};
        ANY_CONSTRUCTOR_SUPPRESS_CONSTRUCTOR_PROPERTIES = new ConfigurationKey<Boolean>("Suppress the generation of @ConstructorProperties for generated constructors (default: false).") {};
        ANY_CONSTRUCTOR_ADD_CONSTRUCTOR_PROPERTIES = new ConfigurationKey<Boolean>("Generate @ConstructorProperties for generated constructors (default: false).") {};
        ALL_ARGS_CONSTRUCTOR_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @AllArgsConstructor is used.") {};
        NO_ARGS_CONSTRUCTOR_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @NoArgsConstructor is used.") {};
        NO_ARGS_CONSTRUCTOR_EXTRA_PRIVATE = new ConfigurationKey<Boolean>("Generate a private no-args constructor for @Data and @Value (default: false).") {};
        REQUIRED_ARGS_CONSTRUCTOR_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @RequiredArgsConstructor is used.") {};
        DATA_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Data is used.") {};
        VALUE_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Value is used.") {};
        GETTER_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Getter is used.") {};
        GETTER_LAZY_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Getter(lazy=true) is used.") {};
        GETTER_CONSEQUENT_BOOLEAN = new ConfigurationKey<Boolean>("If true, generate and use getFieldName() for boolean getters instead of isFieldName().") {};
        SETTER_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Setter is used.") {};
        EQUALS_AND_HASH_CODE_DO_NOT_USE_GETTERS = new ConfigurationKey<Boolean>("Don't call the getters but use the fields directly in the generated equals and hashCode method (default = false).") {};
        EQUALS_AND_HASH_CODE_CALL_SUPER = new ConfigurationKey<CallSuperType>("When generating equals and hashCode for classes that extend something (other than Object), either automatically take into account superclass implementation (call), or don't (skip), or warn and don't (warn). (default = warn).") {};
        EQUALS_AND_HASH_CODE_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @EqualsAndHashCode is used.") {};
        TO_STRING_DO_NOT_USE_GETTERS = new ConfigurationKey<Boolean>("Don't call the getters but use the fields directly in the generated toString method (default = false).") {};
        TO_STRING_CALL_SUPER = new ConfigurationKey<CallSuperType>("When generating toString for classes that extend something (other than Object), either automatically take into account superclass implementation (call), or don't (skip), or warn and don't (warn). (default = skip).") {};
        TO_STRING_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @ToString is used.") {};
        TO_STRING_INCLUDE_FIELD_NAMES = new ConfigurationKey<Boolean>("Include the field names in the generated toString method (default = true).") {};
        TO_STRING_ONLY_EXPLICITLY_INCLUDED = new ConfigurationKey<Boolean>("Include only fields/methods explicitly marked with @ToString.Include. Otherwise, include all non-static, non-dollar-named fields (default = false).") {};
        BUILDER_CLASS_NAME = new ConfigurationKey<String>("Default name of the generated builder class. A * is replaced with the name of the relevant type (default = *Builder).") {};
        BUILDER_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Builder is used.") {};
        SINGULAR_USE_GUAVA = new ConfigurationKey<Boolean>("Generate backing immutable implementations for @Singular on java.util.* types by using guava's ImmutableList, etc. Normally java.util's mutable types are used and wrapped to make them immutable.") {};
        SINGULAR_AUTO = new ConfigurationKey<Boolean>("If true (default): Automatically singularize the assumed-to-be-plural name of your variable/parameter when using @Singular.") {};
        CLEANUP_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Cleanup is used.") {};
        DELEGATE_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Delegate is used.") {};
        NON_NULL_EXCEPTION_TYPE = new ConfigurationKey<NullCheckExceptionType>("The type of the exception to throw if a passed-in argument is null (Default: NullPointerException).") {};
        NON_NULL_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @NonNull is used.") {};
        SNEAKY_THROWS_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @SneakyThrows is used.") {};
        SYNCHRONIZED_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Synchronized is used.") {};
        VAL_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if 'val' is used.") {};
        VAR_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if 'var' is used.") {};
        WITH_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @With is used.") {};
        LOG_ANY_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if any of the log annotations is used.") {};
        LOG_COMMONS_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @CommonsLog is used.") {};
        LOG_JUL_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Log is used.") {};
        LOG_LOG4J_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Log4j is used.") {};
        LOG_LOG4J2_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Log4j2 is used.") {};
        LOG_SLF4J_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Slf4j is used.") {};
        LOG_XSLF4J_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @XSlf4j is used.") {};
        LOG_JBOSSLOG_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @JBossLog is used.") {};
        LOG_FLOGGER_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Flogger is used.") {};
        LOG_ANY_FIELD_NAME = new ConfigurationKey<IdentifierName>("Use this name for the generated logger fields (default: 'log').") {};
        LOG_ANY_FIELD_IS_STATIC = new ConfigurationKey<Boolean>("Make the generated logger fields static (default: true).") {};
        LOG_CUSTOM_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @CustomLog is used.") {};
        LOG_CUSTOM_DECLARATION = new ConfigurationKey<LogDeclaration>("Define the generated custom logger field.") {};
        EXPERIMENTAL_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if an experimental feature is used.") {};
        ACCESSORS_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Accessors is used.") {};
        ACCESSORS_PREFIX = new ConfigurationKey<List<String>>("Strip this field prefix, like 'f' or 'm_', from the names of generated getters, setters, and with-ers.") {};
        ACCESSORS_CHAIN = new ConfigurationKey<Boolean>("Generate setters that return 'this' instead of 'void' (default: false).") {};
        ACCESSORS_FLUENT = new ConfigurationKey<Boolean>("Generate getters and setters using only the field name (no get/set prefix) (default: false).") {};
        ACCESSORS_MAKE_FINAL = new ConfigurationKey<Boolean>("Generate getters, setters and with-ers with the 'final' modifier (default: false).") {};
        ACCESSORS_JAVA_BEANS_SPEC_CAPITALIZATION = new ConfigurationKey<CapitalizationStrategy>("Which capitalization strategy to use when converting field names to accessor names and vice versa (default: basic).") {};
        EXTENSION_METHOD_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @ExtensionMethod is used.") {};
        FIELD_DEFAULTS_PRIVATE_EVERYWHERE = new ConfigurationKey<Boolean>("If true, fields without any access modifier, in any file (lombok annotated or not) are marked as private. Use @PackagePrivate or an explicit modifier to override this.") {};
        FIELD_DEFAULTS_FINAL_EVERYWHERE = new ConfigurationKey<Boolean>("If true, fields, in any file (lombok annotated or not) are marked as final. Use @NonFinal to override this.") {};
        FIELD_DEFAULTS_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @FieldDefaults is used.") {};
        HELPER_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Helper is used.") {};
        ON_X_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if onX is used.") {};
        UTILITY_CLASS_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @UtilityClass is used.") {};
        FIELD_NAME_CONSTANTS_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @FieldNameConstants is used.") {};
        FIELD_NAME_CONSTANTS_INNER_TYPE_NAME = new ConfigurationKey<IdentifierName>("The default name of the inner type generated by @FieldNameConstants. (default: 'Fields').") {};
        FIELD_NAME_CONSTANTS_UPPERCASE = new ConfigurationKey<Boolean>("The default name of the constants inside the inner type generated by @FieldNameConstants follow the variable name precisely. If this config key is true, lombok will uppercase them as best it can. (default: false).") {};
        SUPERBUILDER_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @SuperBuilder is used.") {};
        WITHBY_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @WithBy is used.") {};
        JACKSONIZED_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @Jacksonized is used.") {};
        STOP_BUBBLING = new ConfigurationKey<Boolean>("Tell the configuration system it should stop looking for other configuration files (default: false).") {};
        COPYABLE_ANNOTATIONS = new ConfigurationKey<List<TypeName>>("Copy these annotations to getters, setters, with methods, builder-setters, etc.") {};
        CHECKER_FRAMEWORK = new ConfigurationKey<CheckerFrameworkVersion>("If set with the version of checkerframework.org (in major.minor, or just 'true' for the latest supported version), create relevant checkerframework.org annotations for code lombok generates (default: false).") {};
        STANDARD_EXCEPTION_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("Emit a warning or error if @StandardException is used.") {};
    }
    
    private ConfigurationKeys() {
    }
}
