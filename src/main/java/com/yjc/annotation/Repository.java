package com.yjc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author IntelliYJC
 * @create 2022/7/31 16:22
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Repository {
    @AliasFor(
            annotation = Component.class
    )
    String value() default "";
}
