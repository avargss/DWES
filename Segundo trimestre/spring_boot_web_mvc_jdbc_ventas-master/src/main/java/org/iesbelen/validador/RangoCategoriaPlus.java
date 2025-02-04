package org.iesbelen.validador;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RangoCategoriaPlusValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface RangoCategoriaPlus {

    int[] value();  // Permite recibir un array de valores válidos

    String message() default "{error.rango.categoria.plus}";  // Mensaje de error

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
