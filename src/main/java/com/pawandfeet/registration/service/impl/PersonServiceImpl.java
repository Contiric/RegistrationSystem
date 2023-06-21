package com.pawandfeet.registration.service.impl;

import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.entity.Person;
import com.pawandfeet.registration.exception.PersonNotFoundException;
import com.pawandfeet.registration.repository.PersonRepository;
import com.pawandfeet.registration.service.AddressService;
import com.pawandfeet.registration.service.DogService;
import com.pawandfeet.registration.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private DogService dogService;

    @Autowired
    private AddressService addressService;


    @Override
    public Long createPerson(PersonDTO personDTO) {
        Long personId = personRepository.save(personDTO.toPerson()).getId();
        if (personId == null){
            throw new PersonNotFoundException();
        }
            Long addresId = addressService.createAddress(personDTO.getAddressDTO().addPerson(personId));

        personDTO.getDogsDTO().forEach(dogDTO -> {
            try {
                dogDTO.setPersonId(personId);
                dogService.createDog(dogDTO);
            } catch (PersonNotFoundException e) {
                addressService.deleteAddress(addresId);
                deletePerson(personId);
                logger.info(e.getMessage());
                throw new RuntimeException();
            }

        });
        logger.info("Person created");
        return personId;
    }

    @Override
    public PersonDTO findPersonById(Long id) {
        try {
            return personRepository.findById(id).orElseThrow(PersonNotFoundException::new).toPersonDTO();
        } catch (PersonNotFoundException ex) {
            logger.info(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        try {
            Person person = personRepository.findById(id).orElseThrow();
            person.updatePerson(personDTO);
            return personRepository.save(person).toPersonDTO();
        } catch (PersonNotFoundException ex) {
            logger.info(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void deletePerson(Long id) {
        try {
            personRepository.deleteById(id);
        } catch (PersonNotFoundException ex) {
            logger.info(ex.getMessage());
            throw  new RuntimeException(ex.getMessage());
        }
    }

}
