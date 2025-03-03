package org.iesbelen.videoclub.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tarjetas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Tarjeta {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private Long id;

    private Date caducidad;

    @OneToOne
    @JoinColumn(name = "id_tarjeta", foreignKey = @ForeignKey(name = "FK_SOCIO"))
    @MapsId
    @JsonIgnore
    @ToString.Exclude
    private Socio socio;
}
