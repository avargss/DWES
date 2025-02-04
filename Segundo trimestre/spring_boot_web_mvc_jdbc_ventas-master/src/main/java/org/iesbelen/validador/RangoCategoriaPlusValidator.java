package org.iesbelen.validador;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class RangoCategoriaPlusValidator implements ConstraintValidator<RangoCategoriaPlus, Integer> {

    private int[] valoresPermitidos;

    @Override
    public void initialize(RangoCategoriaPlus constraintAnnotation) {
        this.valoresPermitidos = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer categoria, ConstraintValidatorContext constraintValidatorContext) {
        if (categoria == null) {
            return true; // Si es null, otra validación como @NotNull se encargará de ello
        }
        return Arrays.stream(valoresPermitidos).anyMatch(valor -> valor == categoria);
    }
}
