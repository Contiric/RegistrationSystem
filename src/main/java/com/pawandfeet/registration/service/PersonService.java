package com.pawandfeet.registration.service;

import com.pawandfeet.registration.dto.PersonDTO;

public interface PersonService {

    Long createPerson(PersonDTO personDTO);
    PersonDTO findPersonById(Long id);
    PersonDTO updatePerson(Long id, PersonDTO personDTO);
    void deletePerson(Long id);
    //associateDog
    //void associateDog(Long id, Person person, Dog dog);

}
