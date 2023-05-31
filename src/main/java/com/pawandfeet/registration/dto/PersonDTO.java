package com.pawandfeet.registration.dto;

import com.pawandfeet.registration.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private String name;
    private Date birthdate;
    private String email;
    private String phone;

    public Person toPerson() {
        return Person.builder()
                .name(this.name)
                .birthdate(this.birthdate)
                .email(this.email)
                .phone(this.phone)
                .build();
    }
}
