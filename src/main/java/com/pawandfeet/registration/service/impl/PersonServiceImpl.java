package com.pawandfeet.registration.service.impl;

import com.pawandfeet.registration.dto.AddressDTO;
import com.pawandfeet.registration.dto.PersonDTO;
import com.pawandfeet.registration.entity.Address;
import com.pawandfeet.registration.entity.Person;
import com.pawandfeet.registration.exception.PersonNotFoundException;
import com.pawandfeet.registration.repository.PersonRepository;
import com.pawandfeet.registration.service.AddressService;
import com.pawandfeet.registration.service.DogService;
import com.pawandfeet.registration.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        addressService.createAddress(personDTO.getAddressDTO().addPerson(personId));
        personDTO.getDogsDTO().forEach(dogDTO -> {
            try {
                dogDTO.setPersonId(personId);
                dogService.createDog(dogDTO);
            } catch (PersonNotFoundException e) {
                logger.info(e.getMessage());
                throw new RuntimeException();
            }
        });
        return personId;
    }

    @Override
    public PersonDTO findPersonById(Long id) {
        try {
            return personRepository.findById(id).orElseThrow(PersonNotFoundException::new).toPersonDTO();
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
