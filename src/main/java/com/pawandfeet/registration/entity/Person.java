package com.pawandfeet.registration.entity;

import com.pawandfeet.registration.dto.AddressDTO;
import com.pawandfeet.registration.dto.DogDTO;
import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.service.impl.PersonServiceImpl;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private LocalDate birthDate;

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
                .gender(this.gender)
                .build();
    }

    public void updatePerson(PersonDTO personDTO) {
        BeanUtils.copyProperties(this, personDTO, "id");
    }

    public List<DogDTO> convertObjectToDTO(List<Dog> dog){
        return dog.stream().map(Dog::toDogDTO).collect(Collectors.toList());
    }
}
