package com.pawandfeet.registration.dto;

import com.pawandfeet.registration.entity.Address;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private String street;
    private String city;
    private String state;
    private String country;
    private Long personId;

    public Address toAddress(){
        return Address.builder()
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
