package com.spring.demo01.domain.DemoEnum;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;


@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD})
public @interface DemoEnum1 {
    String value() default "";
}
