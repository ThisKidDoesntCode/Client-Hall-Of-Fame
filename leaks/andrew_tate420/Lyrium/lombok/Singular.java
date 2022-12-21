// 
// Decompiled by Procyon v0.5.36
// 

package lombok;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.SOURCE)
public @interface Singular {
    String value() default "";
    
    boolean ignoreNullCollections() default false;
}
