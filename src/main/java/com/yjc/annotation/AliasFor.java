package com.yjc.annotation;

import java.lang.annotation.*;

/**
 * @author IntelliYJC
 * @create 2022/7/31 16:06
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AliasFor {
    @AliasFor("attribute")
    String value() default "";

    @AliasFor("value")
    String attribute() default "";

    Class<? extends Annotation> annotation() default Annotation.class;
}
