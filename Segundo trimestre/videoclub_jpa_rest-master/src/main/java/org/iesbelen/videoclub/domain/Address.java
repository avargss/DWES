package org.iesbelen.videoclub.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Embeddable
public class Address {

    private int idAddress;

    private String street;

    private int houseNumber;

    private String city;

    private int zipCode;
}