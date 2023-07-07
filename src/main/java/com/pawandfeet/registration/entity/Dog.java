package com.pawandfeet.registration.entity;

import com.pawandfeet.registration.dto.DogDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dog_id")
    private Long id;

    private String name;

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
                .size(this.size)
                .personality(this.personality)
                .gender(this.gender)
                .personId(this.personId)
                .build();
    }

    public Dog updateDog(DogDTO dogDTO) {
        BeanUtils.copyProperties(this, dogDTO, "id");
        return this;
    }
}
