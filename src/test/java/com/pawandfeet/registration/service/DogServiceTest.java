package com.pawandfeet.registration.service;

import com.pawandfeet.registration.dto.AddressDTO;
import com.pawandfeet.registration.dto.DogDTO;
import com.pawandfeet.registration.entity.*;
import com.pawandfeet.registration.exception.DogNotFoundException;
import com.pawandfeet.registration.exception.PersonNotFoundException;
import com.pawandfeet.registration.repository.DogRepository;
import com.pawandfeet.registration.repository.PersonRepository;
import com.pawandfeet.registration.service.impl.DogServiceImpl;
import com.pawandfeet.registration.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DogServiceTest {
    @Spy
    @InjectMocks
    private DogServiceImpl dogService;
    @Mock
    private Dog dog;
    @Mock
    private DogDTO dogDTO;
    @Mock
    private DogRepository dogRepository;
    @Mock
    private List<DogDTO> dogDTOS;
    @Mock
    private PersonServiceImpl personService;
    @Mock
    private Person person;
    @Mock
    private PersonRepository personRepository;
    @Mock
    private AddressDTO addressDTO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        dog = Dog.builder().id(1L).name("Jerry").birthDate(LocalDate.of(2019,2,19)).breed("German Shepherd").size(SizeEnum.LARGE).personality(PersonalityEnum.PLAYFUL).gender(GenderEnum.MALE).personId(1L).build();
        dogDTO = DogDTO.builder().name("Rex").birthDate(LocalDate.of(2020,4,15)).breed("Boxer").size(SizeEnum.LARGE).personality(PersonalityEnum.PLAYFUL).gender(GenderEnum.MALE).personId(1L).build();
        person = Person.builder().id(1L).name("John").birthDate(LocalDate.of(1994, 8,15)).email("john@gmail.com").phone("9123456789").gender(GenderEnum.MALE).build();
    }
    @Test
    public void createDog() {
        when(personRepository.findById(1L)).thenReturn(Optional.ofNullable(person));
        when(dogRepository.save(Mockito.any(Dog.class))).thenReturn(dog);

        Long dog1 = dogService.createDog(dogDTO);

        Assertions.assertNotNull(dog1);
    }
    @Test
    public void dogWithoutPersonException(){
        DogDTO dogDTO1 = new DogDTO();

        when(dogRepository.save(ArgumentMatchers.any()))
                .thenThrow(new PersonNotFoundException());

        RuntimeException runtimeException =
                Assertions.assertThrows(RuntimeException.class, () -> {
                    dogService.createDog(dogDTO1);
                });

        assertThat("Person not found.").isEqualTo(runtimeException.getMessage());
    }
    @Test
    public void findDog() {
        when(dogRepository.findById(1L)).thenReturn(Optional.ofNullable(dog));

        DogDTO dogById = dogService.findDogById(1L);

        verify(dogRepository, times(1)).findById(1L);

        Assertions.assertNotNull(dogById);
    }
    @Test
    public void updateDog() {
        when(dogRepository.findById(1L)).thenReturn(Optional.ofNullable(dog));
        when(dogRepository.save(Mockito.any(Dog.class))).thenReturn(dog);

        DogDTO dogDTOUpdated = dogService.updateDog(1L, dogDTO);

        Assertions.assertNotNull(dogDTOUpdated);
    }
    @Test
    public void deleteDog() {
        when(dogRepository.findById(1L)).thenReturn(Optional.ofNullable(dog));
        doNothing().when(dogRepository).delete(dog);

        Assertions.assertAll(() -> dogService.deleteDog(1L));
    }
    @Test
    public void dogNotFoundException() {
        DogDTO dogDTO1 = new DogDTO();

        when(dogRepository.save(ArgumentMatchers.any()))
                .thenThrow(new DogNotFoundException());

        DogNotFoundException dogNotFoundException =
                Assertions.assertThrows(DogNotFoundException.class, () -> {
                    dogService.createDog(dogDTO1);
                });

        assertThat("Dog not found.").isEqualTo(dogNotFoundException.getMessage());
    }
}
