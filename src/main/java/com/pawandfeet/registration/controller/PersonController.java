package com.pawandfeet.registration.controller;

import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.entity.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface PersonController {

    public static final String PATH = "/api/pawandfeet";

    public ResponseEntity createPerson(PersonDTO personDTO);

    public ResponseEntity findPersonByID( Long id);

    public ResponseEntity<Person> updatePerson(Long id, PersonDTO personDTO);

    public void deletePerson(@PathVariable("id") Long id);
}