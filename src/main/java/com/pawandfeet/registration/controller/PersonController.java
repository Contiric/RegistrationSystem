package com.pawandfeet.registration.controller;

import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.entities.Person;
import com.pawandfeet.registration.repositories.PersonRepository;
import com.pawandfeet.registration.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public interface PersonController {

    public ResponseEntity createPerson(PersonDTO personDTO);

    public ResponseEntity findPersonByID( Long id);

    public ResponseEntity<Person> updatePerson(Long id, PersonDTO personDTO);

    public void deletePerson(@PathVariable("id") Long id);
}