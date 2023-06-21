package com.pawandfeet.registration.entity;

import com.pawandfeet.registration.exception.PersonNotFoundException;
import com.pawandfeet.registration.repository.PersonRepository;
import com.pawandfeet.registration.service.impl.PersonServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonEntityTest {

    @Spy
    @InjectMocks
    private PersonServiceImpl personService;
    @Mock
    GenderEnum genderEnum;
    @Mock
    PersonNotFoundException exception;

    @Mock
    PersonRepository personRepository;

    @Before("init")
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
//
//    @Test
//    public void updatePerson(){
//        Person person = new Person(1L, "John", new Date(),
//                "john10@gmail.com", "9124755647", genderEnum.MALE);
//
//        person.setEmail("john@gmail.com");
//
//        when(personRepository.findById(person.getId())).thenReturn(Optional.of(person));
//
//        personService.updatePerson(person.getId(), person.toPersonDTO());
//
//        Assertions.assertNotSame(person, person.getEmail());
//
//    }
}
