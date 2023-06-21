package com.pawandfeet.registration.dto;

import com.pawandfeet.registration.entity.Address;
import com.pawandfeet.registration.entity.Dog;
import com.pawandfeet.registration.entity.GenderEnum;
import com.pawandfeet.registration.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private String name;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private GenderEnum gender;
    private List<DogDTO> dogsDTO;
    private AddressDTO addressDTO;
    public Person toPerson() {
        return Person.builder()
                .name(this.name)
                .birthDate(this.birthDate)
                .email(this.email)
                .phone(this.phone)
                .gender(this.gender)
                .build();
    }
}
