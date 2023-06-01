package com.pawandfeet.registration.entity;

import com.pawandfeet.registration.dto.DogDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Builder
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dog_id")
    private Long id;

    private String name;

    @Column(name = "birthdate")
    private LocalDate birthDate;

    private String breed;

    @Enumerated(EnumType.STRING)
    private SizeEnum size;

    @Enumerated(EnumType.STRING)
    private PersonalityEnum personality;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    private Long personId;

    public DogDTO toDogDTO() {
        return DogDTO.builder()
                .name(this.name)
                .birthDate(this.birthDate)
                .breed(this.breed)
                .size(this.size.toString())
                .personality(this.personality.toString())
                .gender(this.gender.toString())
                .build();
    }
}
