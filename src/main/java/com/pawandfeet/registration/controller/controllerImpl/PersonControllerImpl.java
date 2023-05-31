package com.pawandfeet.registration.controller.controllerImpl;

import com.pawandfeet.registration.controller.PersonController;
import com.pawandfeet.registration.entities.Person;
import com.pawandfeet.registration.repositories.PersonRepository;
import com.pawandfeet.registration.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonControllerImpl implements PersonController {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Override
    public ResponseEntity<Person> createPerson(Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personRepository.save(person));
    }

    @Override
    public ResponseEntity<Optional<Person>> findByIdPerson(Long id) {
        return ResponseEntity.ok(personRepository.findById(id));
    }

    @Override
    public ResponseEntity<Person> updatePerson(Person person) {
        return ResponseEntity.ok(personRepository.save(person));
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);

    }
}