package org.iesbelen.videoclub.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

// Para que funcione la colección Set<Categoria> en Pelicula
@EqualsAndHashCode(of = "nombre")

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private long idCategoria;

    @NaturalId
    private String nombre;

    @ManyToMany(
            mappedBy = "categorias")
    @ToString.Exclude
    @JsonIgnore
    Set<Pelicula> peliculas = new HashSet<>();
}