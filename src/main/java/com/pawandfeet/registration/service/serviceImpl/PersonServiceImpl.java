package com.pawandfeet.registration.service.serviceImpl;

import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.entity.Person;
import com.pawandfeet.registration.repository.PersonRepository;
import com.pawandfeet.registration.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Long createPerson(PersonDTO personDTO) {
        return personRepository.save(personDTO.toPerson()).getId();
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
