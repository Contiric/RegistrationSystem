package com.pawandfeet.registration.service;

import com.pawandfeet.registration.dto.DogDTO;
import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.entity.Address;
import com.pawandfeet.registration.entity.Dog;
import com.pawandfeet.registration.entity.GenderEnum;
import com.pawandfeet.registration.entity.Person;
import com.pawandfeet.registration.repository.PersonRepository;
import com.pawandfeet.registration.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Spy
    @InjectMocks
    private PersonServiceImpl personService;
    @Mock
    private PersonRepository personRepository;
    @Mock
    private PersonDTO person;
    @Mock
    private DogDTO dogDTO;
    @Mock
    private Dog dog;
    @Mock
    private Address address;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createPerson() {
        List<Dog> dogs = Mockito.mock(List.class);
        dogs.set(1, dog);
        address = new Address(1L, "rua bela",
                "lisboa", "lisboa", "portugal", 1L);

        Person person1 = Person.builder()
                .id(1L)
                .name("John")
                .birthDate(new Date())
                .email("john@gmail.com")
                .phone("9123456789")
                .gender(GenderEnum.MALE)
                .dogs(dogs)
                .address(address)
                .build();

        List<DogDTO> dogsDTO = Mockito.mock(List.class);
        dogsDTO.set(1, dogDTO);

        address = new Address(2L, "rua actor vale",
                "lisboa", "lisboa", "portugal", 2L);

        PersonDTO personDTO = PersonDTO.builder()
                .id(1L)
                .name("John Morris")
                .birthDate(new Date())
                .email("john10@gamil.com")
                .phone("9123456745")
                .gender(GenderEnum.MALE)
                .dogsDTO(dogsDTO)
                .addressDTO(address.toAddressDTO())
                .build();

        when(personRepository.save(Mockito.any(Person.class))).thenReturn(person1);

        Long personDTOId = personService.createPerson(personDTO);

        Assertions.assertNotNull(personDTOId);
    }

    @Test
    public void findPersonById() {
        List<Dog> dogs = Mockito.mock(List.class);
        dogs.set(1, dog);
        address = new Address(1L, "rua bela",
                "lisboa", "lisboa", "portugal", 1L);

        Person person1 = Person.builder()
                .id(0L)
                .name("John")
                .birthDate(new Date())
                .email("john@gmail.com")
                .phone("9123456789")
                .gender(GenderEnum.MALE)
                .dogs(dogs)
                .address(address)
                .build();

        when(personRepository.findById(1L)).thenReturn(Optional.ofNullable(person1));

        PersonDTO personById = personService.findPersonById(1L);

        verify(personRepository, times(1)).findById(1L);

        Assertions.assertNotNull(personById);
    }

    @Test
    public void updatePerson() {
        List<Dog> dogs = Mockito.mock(List.class);
        dogs.set(1, dog);
        address = new Address(1L, "rua bela",
                "lisboa", "lisboa", "portugal", 1L);

        Person person1 = Person.builder()
                .id(1L)
                .name("John")
                .birthDate(new Date())
                .email("john@gmail.com")
                .phone("9123456789")
                .gender(GenderEnum.MALE)
                .dogs(dogs)
                .address(address)
                .build();

        List<DogDTO> dogsDTO = Mockito.mock(List.class);
        dogsDTO.set(1, dogDTO);
        address = new Address(2L, "rua actor vale",
                "lisboa", "lisboa", "portugal", 2L);

        PersonDTO personDTO = PersonDTO.builder()
                .id(1L)
                .name("John Morris")
                .birthDate(new Date())
                .email("john10@gamil.com")
                .phone("9123456745")
                .gender(GenderEnum.MALE)
                .dogsDTO(dogsDTO)
                .addressDTO(address.toAddressDTO())
                .build();

        when(personRepository.findById(1L)).thenReturn(Optional.ofNullable(person1));
        when(personRepository.save(Mockito.any(Person.class))).thenReturn(person1);

        PersonDTO personDTOId = personService.updatePerson(1L, personDTO);

        Assertions.assertNotNull(personDTOId);
    }

    @Test
    public void deletePerson() {
        List<Dog> dogs = Mockito.mock(List.class);
        dogs.set(1, dog);
        address = new Address(1L, "rua bela",
                "lisboa", "lisboa", "portugal", 1L);

        Person person1 = Person.builder()
                .id(1L)
                .name("John")
                .birthDate(new Date())
                .email("john@gmail.com")
                .phone("9123456789")
                .gender(GenderEnum.MALE)
                .dogs(dogs)
                .address(address)
                .build();

        doNothing().when(personRepository).deleteById(1L);

        Assertions.assertAll(() ->  personService.deletePerson(1L));
    }
}
