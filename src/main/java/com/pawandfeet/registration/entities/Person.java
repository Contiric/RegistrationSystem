package com.pawandfeet.registration.entities;

import com.pawandfeet.registration.dto.PersonDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long id;
    private String name;
    private Date birthdate;
    private String email;
    private String phone;

    //private Address idAddress;
    //private Dog idDog;
//    @Enumerated(EnumType.STRING)
//    private Enum gender;

    public PersonDTO toPersonDTO() {
        return PersonDTO.builder()
                .name(this.name)
                .birthdate(this.birthdate)
                .email(this.email)
                .phone(this.phone)
                .build();
    }

    public void updatePerson(PersonDTO personDTO) {
        if (!personDTO.getName().isBlank()){this.name = personDTO.getName();}
        if (!personDTO.getName().isBlank()){this.birthdate = personDTO.getBirthdate();}
        if (!personDTO.getName().isBlank()){this.email = personDTO.getEmail();}
        if (!personDTO.getName().isBlank()){this.phone = personDTO.getPhone();}
    }
}
