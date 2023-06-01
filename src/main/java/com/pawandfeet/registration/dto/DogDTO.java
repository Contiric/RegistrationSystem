package com.pawandfeet.registration.dto;

import com.pawandfeet.registration.entity.Dog;
import com.pawandfeet.registration.entity.GenderEnum;
import com.pawandfeet.registration.entity.PersonalityEnum;
import com.pawandfeet.registration.entity.SizeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DogDTO {

    private String name;
    private LocalDate birthDate;
    private String breed;
    private String size;
    private String personality;
    private String gender;
    private Long personId;

    public Dog toDog() {
        return Dog.builder()
                .name(this.name)
                .birthDate(this.birthDate)
                .breed(this.breed)
                .size(SizeEnum.valueOf(this.size))
                .personality(PersonalityEnum.valueOf(this.personality))
                .gender(GenderEnum.valueOf(this.gender))
                .personId(this.personId)
                .build();
    }
}
