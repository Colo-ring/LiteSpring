package com.yjc.annotation;

import java.lang.annotation.*;

/**
 * @author IntelliYJC
 * @create 2022/7/28 17:05
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String value() default "";
}