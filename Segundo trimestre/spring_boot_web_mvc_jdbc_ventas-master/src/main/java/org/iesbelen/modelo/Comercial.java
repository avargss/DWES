package org.iesbelen.modelo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter

@AllArgsConstructor
public class Comercial {

    private int id;

    @NotBlank(message = "{error.nombre}")
    @Size(max = 30, message = "{error.nombre.size.max}")
    private String nombre;

    @NotBlank(message = "{error.nombre}")
    @Size(max = 30, message = "{error.apellido.size.max}")
    private String apellido1;
    private String apellido2;

    @NotNull(message = "{error.notNull}")
    @DecimalMax(value = "0.276", inclusive = true, message = "{error.comision}")
    @DecimalMin(value = "0.946", inclusive = true, message = "{error.comision}")
    private BigDecimal comision;

    public Comercial() {

    }

}