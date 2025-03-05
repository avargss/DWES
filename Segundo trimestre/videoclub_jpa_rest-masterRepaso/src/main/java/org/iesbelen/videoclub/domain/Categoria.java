package org.iesbelen.videoclub.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

// Si quiero que la colección Set<Categoria> funcione en Pelicula debo tener esto
@EqualsAndHashCode(of = "nombre")

public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private long id;

    @NaturalId
    private String nombre; // EqualsAndHashCode pilla el campo nombre

    /*
     * Relación ManyToMany con la entidad Pelicula.
     * La anotación JoinTable se utiliza para definir la tabla intermedia que contiene las claves foráneas
     * de las dos entidades que participan en la relación ManyToMany.
     */
    @ManyToMany(
            mappedBy = "categorias")
    @ToString.Exclude
    @JsonIgnore
    // Una de las dos entidades relacionadas debe tener la anotación JsonIgnore para evitar bucles infinitos en postman
    Set<Pelicula> peliculas = new HashSet<>();
}