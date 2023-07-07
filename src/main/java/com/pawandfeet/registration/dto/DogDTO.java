package com.pawandfeet.registration.dto;

import com.pawandfeet.registration.entity.Dog;
import com.pawandfeet.registration.entity.GenderEnum;
import com.pawandfeet.registration.entity.PersonalityEnum;
import com.pawandfeet.registration.entity.SizeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.engine.jdbc.Size;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DogDTO {

    private String name;
    private LocalDate birthDate;
    private String breed;
    private SizeEnum size;
    private PersonalityEnum personality;
    private GenderEnum gender;
    private Long personId;

    public Dog toDog() {
        return Dog.builder()
                .name(this.name)
                .birthDate(this.birthDate)
                .breed(this.breed)
                .size((this.size))
                .personality((this.personality))
                .gender((this.gender))
                .personId(this.personId)
                .build();
    }
}
