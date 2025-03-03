package org.iesbelen.videoclub.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Embeddable
/*
* Embedabble permite que esta clase pueda ser usada en otro modelo mediante la
* anotación ElementCollection para acceder a sus datos usando AttributeOverrides.
* Esta clase ahora es Embebible, NO es una entidad.
* */

public class Address {

    private int id;

    private String street;

    private int houseNumber;

    private String city;

    private int zipCode;
}
