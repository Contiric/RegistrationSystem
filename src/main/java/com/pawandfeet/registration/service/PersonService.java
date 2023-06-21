package com.pawandfeet.registration.service;

import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.service.impl.PersonServiceImpl;

import java.util.logging.Logger;

public interface PersonService {

    Logger logger = Logger.getLogger(String.valueOf(PersonService.class));
    Long createPerson(PersonDTO personDTO);
    PersonDTO findPersonById(Long id);
    PersonDTO updatePerson(Long id, PersonDTO personDTO);
    void deletePerson(Long id);
    //associateDog
    //void associateDog(Long id, Person person, Dog dog);

}
