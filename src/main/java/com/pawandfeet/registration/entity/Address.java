package com.pawandfeet.registration.entity;

import com.pawandfeet.registration.dto.AddressDTO;
import com.pawandfeet.registration.dto.PersonDTO;
import jakarta.persistence.*;
import lombok.*;

@Data
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
                .id(this.id)
                .street(this.street)
                .city(this.city)
                .state(this.state)
                .country(this.country)
                .personId(this.personId)
                .build();
    }

}
