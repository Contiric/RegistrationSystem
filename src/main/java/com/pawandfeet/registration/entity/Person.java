package com.pawandfeet.registration.entity;

import com.pawandfeet.registration.dto.PersonDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_Id")
    private Long id;

    private String name;

    private Date birthDate;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    public PersonDTO toPersonDTO() {
        return PersonDTO.builder()
                .name(this.name)
                .birthDate(this.birthDate)
                .email(this.email)
                .phone(this.phone)
                .build();
    }

    public void updatePerson(PersonDTO personDTO) {
        if (!personDTO.getName().isBlank()){this.name = personDTO.getName();}
        if (!personDTO.getName().isBlank()){this.birthDate = personDTO.getBirthDate();}
        if (!personDTO.getName().isBlank()){this.email = personDTO.getEmail();}
        if (!personDTO.getName().isBlank()){this.phone = personDTO.getPhone();}
    }
}
