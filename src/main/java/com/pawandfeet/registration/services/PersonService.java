package com.pawandfeet.registration.services;

import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.entities.Person;

import java.util.Optional;

public interface PersonService {

    //createPerson
    PersonDTO createPerson(PersonDTO personDTO);
    //findById
    PersonDTO findPersonById(Long id);

    //updatePerson
    PersonDTO updatePerson(Long id, PersonDTO personDTO);

    //deletePerson
    void deletePerson(Long id);

    //associateDog
    //void associateDog(Long id, Person person, Dog dog);

}
