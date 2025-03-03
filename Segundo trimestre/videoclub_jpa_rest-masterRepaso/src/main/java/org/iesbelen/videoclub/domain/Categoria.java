package org.iesbelen.videoclub.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private long id;
    private String nombre;

    /*
     * Relación ManyToMany con la entidad Pelicula.
     * La anotación JoinTable se utiliza para definir la tabla intermedia que contiene las claves foráneas
     * de las dos entidades que participan en la relación ManyToMany.
     */
    @ManyToMany(
            mappedBy = "categorias")
    @JsonIgnore
    Set<Pelicula> peliculas = new HashSet<>();
}