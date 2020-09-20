package com.wen.annotation;

public @interface Uniquess {
    Constraints constraints() default @Constraints(unique = true);
}
