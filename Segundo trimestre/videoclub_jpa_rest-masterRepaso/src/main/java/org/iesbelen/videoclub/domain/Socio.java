package org.iesbelen.videoclub.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "socios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;

    private String nombre;

    private String apellidos;

    /*
    * Para que ElementCollection funcione, debe tener el atributo CollectionTable con el nombre de
    * la tabla con la información de la dirección en este caso, y debe indicar con JoinColumn la
    * tabla principal usando la id de la misma (aquí la principal es la tabla Socio)
    * */

    @ElementCollection
    @CollectionTable(name = "socio_addresses", joinColumns = @JoinColumn(name = "socio_id"))
    @AttributeOverrides({
            @AttributeOverride( name = "houseNumber", column = @Column(name = "house_number")),
            @AttributeOverride( name = "street", column = @Column(name = "street")),
            @AttributeOverride( name = "city", column = @Column(name = "city")),
            @AttributeOverride( name = "zipCode", column = @Column(name = "zip_code"))
    })
    private Set<Address> addresses = new HashSet<>();

    private Address address;

    @ElementCollection
    @CollectionTable(name = "socio_phone_numbers", joinColumns = @JoinColumn(name = "socio_id"))
    @Column(name = "phone_number")
    private Set<String> phoneNumbers;

    @OneToOne
    @JoinColumn(name = "id_tarjeta", referencedColumnName = "id")
    private Tarjeta tarjeta;
}
