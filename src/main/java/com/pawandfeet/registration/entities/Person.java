package com.pawandfeet.registration.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private Long id;
    private String name;
    private Date birthDate;
    private String email;
    private String phone;
    //private Address idAddress;
    //private Dog idDog;
    @Enumerated(EnumType.STRING)
    private Enum gender;
}
