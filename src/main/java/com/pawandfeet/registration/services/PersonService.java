package com.pawandfeet.registration.services;

import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.entities.Person;

import java.util.Optional;

public interface PersonService {

    PersonDTO createPerson(PersonDTO personDTO);
    PersonDTO findPersonById(Long id);
    PersonDTO updatePerson(Long id, PersonDTO personDTO);
    void deletePerson(Long id);
    //associateDog
    //void associateDog(Long id, Person person, Dog dog);

}
