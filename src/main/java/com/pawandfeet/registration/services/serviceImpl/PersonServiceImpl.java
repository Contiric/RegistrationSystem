package com.pawandfeet.registration.services.serviceImpl;

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
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public Optional<Person> personFindById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        Optional<Person> optionalPerson = personFindById(id);
        Person updatedPerson = optionalPerson.orElse(person);
        updatedPerson.setEmail(person.getEmail());
        updatedPerson.setPhone(person.getPhone());
        return personRepository.save(updatedPerson);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }
}
