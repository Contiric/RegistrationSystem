package com.pawandfeet.registration.services;

import com.pawandfeet.registration.entities.Person;

import java.util.Optional;

public interface PersonService {

    //createPerson
    void createPerson(Person person);
    //findById
    Optional<Person> personFindById(Long id);

    //updatePerson
    Person updatePerson(Long id, Person person);

    //deletePerson
    void deletePerson(Person person);

    //associateDog
    //void associateDog(Long id, Person person, Dog dog);

}
