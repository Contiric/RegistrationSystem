package com.pawandfeet.registration.controller.impl;

import com.pawandfeet.registration.controller.PersonController;
import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.exception.DogNotFoundException;
import com.pawandfeet.registration.service.DogService;
import com.pawandfeet.registration.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = PersonControllerImpl.PATH)
public class PersonControllerImpl implements PersonController {

    @Autowired
    private PersonService personService;

    @Override
    @PostMapping("createPerson")
    public ResponseEntity createPerson(@RequestBody PersonDTO personDTO) {
        //try
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personDTO));
    }

    @Override
    @GetMapping("findById/{id}")
    public ResponseEntity findPersonByID(@PathVariable("id") Long id) {
        //try
        PersonDTO person = personService.findPersonById(id);
        return ResponseEntity.ok().body(person);
    }

    @Override
    @PutMapping("updatePerson")
    public ResponseEntity updatePerson(@PathVariable("id") Long id, @RequestBody PersonDTO personDTO) {
        try {
            PersonDTO person = personService.updatePerson(id, personDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(person);
        } catch (Exception ex) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    @DeleteMapping("deletePerson/{id}")
    public void deletePerson(Long id) {
        personService.deletePerson(id);
    }
}