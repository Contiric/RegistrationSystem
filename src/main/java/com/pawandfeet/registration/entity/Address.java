package com.pawandfeet.registration.entity;

import com.pawandfeet.registration.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private Long personId;

    public AddressDTO toAddressDTO() {
        return AddressDTO.builder()
                .street(this.street)
                .city(this.city)
                .state(this.state)
                .country(this.country)
                .personId(this.personId)
                .build();
    }

}
