package com.pawandfeet.registration.dto;

import com.pawandfeet.registration.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private String name;
    private Date birthDate;
    private String email;
    private String phone;
    private String gender;
    private List<DogDTO> dogsDTO;

    public Person toPerson() {
        return Person.builder()
                .name(this.name)
                .birthDate(this.birthDate)
                .email(this.email)
                .phone(this.phone)
                .build();
    }
}
