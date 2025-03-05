package org.iesbelen.videoclub.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

// Para que funcione la colección Set<Actor> en Pelicula
@EqualsAndHashCode(of = "idActor")

@Entity
@Table(name = "actores")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actor")
    private Long idActor;

    private String nombre;
    private String apellidos;

    @ManyToMany(
            mappedBy = "actores")
    @JsonIgnore
    Set<Pelicula> peliculas = new HashSet<>();
}
