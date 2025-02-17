package org.iesbelen.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pelicula {

    private int id_pelicula;

    @NotBlank(message = "{error.titulo}")
    @Size(min = 2, message = "{error.titulo.size.min}")
    private String titulo;

    @Size(max = 300, message = "{error.descripcion.size.max}")
    private String descripcion;

    @Range(min = 1896, message = "{error.anyo.range.min}")
    private int anyo_lanzamiento;
    private int id_idioma;

    @Range(min = 1, message = "{error.duracion.range.min}")
    private int duracion;
}
