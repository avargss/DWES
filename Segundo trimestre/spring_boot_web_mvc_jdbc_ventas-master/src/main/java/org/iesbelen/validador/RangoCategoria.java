package org.iesbelen.validador;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = RangoCategoriaValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RangoCategoria {
    String message() default "La categoría debe ser 100, 200, 300, 400, 500, 600, 700, 800, 900 o 1000";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
