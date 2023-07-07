package com.pawandfeet.registration.service;

import com.pawandfeet.registration.dto.AddressDTO;
import com.pawandfeet.registration.dto.DogDTO;
import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.entity.*;
import com.pawandfeet.registration.exception.PersonNotFoundException;
import com.pawandfeet.registration.repository.PersonRepository;
import com.pawandfeet.registration.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Spy
    @InjectMocks
    private PersonServiceImpl personService;
    @Mock
    private PersonRepository personRepository;
    @Mock
    private Person person;
    @Mock
    private PersonDTO personDTO;
    @Mock
    private Dog dog;
    @Mock
    private DogDTO dogDTO;
    @Mock
    private List<DogDTO> dogDTOS;
    @Mock
    private Address address;
    @Mock
    private AddressDTO addressDTO;
    @Mock
    private AddressService addressService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        addressDTO = AddressDTO.builder().street("Actor Vale").city("Lisbon").state("LIS").country("Portugal").personId(1L).build();
        address = Address.builder().id(1L).street("Actor Vale").city("Lisbon").state("LIS").country("Portugal").personId(1L).build();
        dog = Dog.builder().id(1L).name("Jerry").birthDate(LocalDate.of(2019,2,19)).breed("German Shepherd").size(SizeEnum.LARGE).personality(PersonalityEnum.PLAYFUL).gender(GenderEnum.MALE).personId(1L).build();
        dogDTOS.set(1, dogDTO);
        person = Person.builder().id(1L).name("John").birthDate(LocalDate.of(1994, 8,15)).email("john@gmail.com").phone("9123456789").gender(GenderEnum.MALE).build();
        personDTO = PersonDTO.builder().name("Emma").birthDate(LocalDate.of(2002, 5, 9)).email("emma@gmail.com").phone("945678123").gender(GenderEnum.FEMALE).dogsDTO(dogDTOS).addressDTO(addressDTO).build();
    }
    @Test
    public void createPerson() {
        when(personRepository.save(Mockito.any(Person.class))).thenReturn(person);

        Long personDTOId = personService.createPerson(personDTO);
        Long address = addressService.createAddress(personDTO.getAddressDTO().addPerson(personDTOId));

        Assertions.assertNotNull(personDTOId);
        Assertions.assertNotNull(address);
    }
    @Test
    public void createPersonNotFoundException() {
        PersonDTO personDTO1 = new PersonDTO();

        when(personRepository.save(ArgumentMatchers.any()))
                .thenThrow(new PersonNotFoundException());

        PersonNotFoundException personNotFoundException =
               Assertions.assertThrows(PersonNotFoundException.class, () -> {
                           personService.createPerson(personDTO1);
                       });

        assertThat("Person not found.").isEqualTo(personNotFoundException.getMessage());
    }
    @Test
    public void insertPersonToDog(){
        dogDTOS.forEach(dogDTO -> dogDTO.setPersonId(personDTO.toPerson().getId()));

        when(personRepository.save(Mockito.any(Person.class))).thenReturn(person);

        Long personDTOId = personService.createPerson(personDTO);

        Assertions.assertNotNull(personDTOId);
        Assertions.assertNotNull(dogDTOS);
    }
    @Test
    public void insertNullPersonToDogException(){
        PersonDTO personDTO1 = new PersonDTO();
        List<DogDTO> dogDTOS1 = new ArrayList<>();
        dogDTOS1.forEach(dogDTO1 -> dogDTO.setPersonId(personDTO1.toPerson().getId()));

        when(personRepository.save(ArgumentMatchers.any()))
                .thenThrow(new PersonNotFoundException());

        PersonNotFoundException personNotFoundException =
                Assertions.assertThrows(PersonNotFoundException.class, () -> {
                    personService.createPerson(personDTO1);
                });

        assertThat("Person not found.").isEqualTo(personNotFoundException.getMessage());
    }
    @Test
    public void findPersonById() {
        when(personRepository.findById(1L)).thenReturn(Optional.ofNullable(person));

        PersonDTO personById = personService.findPersonById(1L);

        verify(personRepository, times(1)).findById(1L);

        Assertions.assertNotNull(personById);
    }

    @Test
    public void personByIdNotFoundException() {
        PersonDTO personDTO1 = new PersonDTO();

        when(personRepository.save(ArgumentMatchers.any()))
                .thenThrow(new PersonNotFoundException());

        PersonNotFoundException personNotFoundException =
                Assertions.assertThrows(PersonNotFoundException.class, () -> {
                    personService.createPerson(personDTO1);
                });

        assertThat("Person not found.").isEqualTo(personNotFoundException.getMessage());
    }
    @Test
    public void updatePerson() {
        when(personRepository.findById(1L)).thenReturn(Optional.ofNullable(person));
        when(personRepository.save(Mockito.any(Person.class))).thenReturn(person);

        PersonDTO personDTOId = personService.updatePerson(1L, personDTO);

        Assertions.assertNotNull(personDTOId);
    }
    @Test
    public void deletePerson() {
        doNothing().when(personRepository).deleteById(1L);

        Assertions.assertAll(() ->  personService.deletePerson(1L));
    }
}