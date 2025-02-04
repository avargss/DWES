package org.iesbelen.validador;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class RangoCategoriaValidator implements ConstraintValidator<RangoCategoria, Integer> {

    // Lista de valores permitidos
    private final List<Integer> valoresPermitidos = Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000);

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return valoresPermitidos.contains(value);
    }

    @Override
    public void initialize(RangoCategoria constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
