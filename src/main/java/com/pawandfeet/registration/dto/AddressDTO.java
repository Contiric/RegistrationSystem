package com.pawandfeet.registration.dto;

import com.pawandfeet.registration.entity.Address;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {

    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private Long personId;

    public Address toAddress(){
        return Address.builder()
                .id(this.id)
                .state(this.street)
                .city(this.city)
                .state(this.state)
                .country(this.country)
                .personId(this.personId)
                .build();
    }

    public AddressDTO addPerson(Long personId) {
        this.setPersonId(personId);
        return this;
    }
}
