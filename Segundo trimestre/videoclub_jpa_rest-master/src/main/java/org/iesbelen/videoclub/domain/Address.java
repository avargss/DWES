package org.iesbelen.videoclub.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Embeddable
public class Address {

    @Column(name = "address_id")
    private int id;

    private String street;

    private int houseNumber;

    private String city;

    private int zipCode;
}