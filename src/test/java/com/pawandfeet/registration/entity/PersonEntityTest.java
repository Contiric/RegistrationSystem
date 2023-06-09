package com.pawandfeet.registration.entity;

import com.pawandfeet.registration.service.impl.PersonServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class PersonEntityTest {

    @Spy
    @InjectMocks
    private PersonServiceImpl personService;
    @Mock
    Person person;
    @Mock
    GenderEnum genderEnum;

    @Before("init")
    public void setup(){
        MockitoAnnotations.initMocks(this);
        personService = new PersonServiceImpl();
    }

    @Test
    public void updatePerson(){

        Person person = new Person(1L, "John", new Date(),
                "john10@gmail.com", "9124755647", genderEnum.MALE);

        Person person2 = new Person(1L, "John", new Date(),
                "john@gmail.com", "9124754511", genderEnum.MALE);


        personService.findPersonById(person.getId());
        personService.updatePerson(person2.getId(), person.toPersonDTO());

        
    }

}
