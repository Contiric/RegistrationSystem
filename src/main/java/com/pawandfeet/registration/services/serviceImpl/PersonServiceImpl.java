package com.pawandfeet.registration.services.serviceImpl;

import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.entities.Person;
import com.pawandfeet.registration.repositories.PersonRepository;
import com.pawandfeet.registration.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        return personRepository.save(personDTO.toPerson()).toPersonDTO();
    }

    @Override
    public PersonDTO findPersonById(Long id) {
        try {
            Person person = personRepository.findById(id).orElseThrow();
            return person.toPersonDTO();
        } catch (Exception ex) {
            //TODO
            return null;
        }
    }

    @Override
    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        try {
            Person person = personRepository.findById(id).orElseThrow();
            person.updatePerson(personDTO);
            return personRepository.save(person).toPersonDTO();
        } catch (Exception exception) {
            //TODO
            return null;
        }
    }

    @Override
    public void deletePerson(Long id) {
        try {
            personRepository.deleteById(id);
        } catch (Exception ex) {
            //TODO
        }
    }

}
