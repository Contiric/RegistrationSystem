package com.pawandfeet.registration.controller;

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
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person);

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> findByIdPerson(@PathVariable("id") Long id);

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person);

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id);
}