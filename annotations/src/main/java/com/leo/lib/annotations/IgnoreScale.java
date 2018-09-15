package com.leo.lib.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * leobui 09/06/2018
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface IgnoreScale {
    boolean isIgnoreScale() default true;
}
