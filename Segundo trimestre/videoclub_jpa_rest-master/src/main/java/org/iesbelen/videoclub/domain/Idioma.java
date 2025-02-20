package org.iesbelen.videoclub.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "idioma")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Si utilizo @OneToMany(FetchType.LAZY) además debo usar
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_idioma")
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "idioma")
    @ToString.Exclude
    @JsonIgnore
    private List<Pelicula> peliculasIdioma;

    @OneToMany(mappedBy = "idiomaOriginal")
    @JsonIgnore
    @ToString.Exclude
    private List<Pelicula> peliculasIdiomaOriginal;
}
