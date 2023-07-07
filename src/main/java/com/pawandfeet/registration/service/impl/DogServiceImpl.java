package com.pawandfeet.registration.service.impl;

import com.pawandfeet.registration.dto.DogDTO;
import com.pawandfeet.registration.entity.Dog;
import com.pawandfeet.registration.entity.Person;
import com.pawandfeet.registration.exception.DogNotFoundException;
import com.pawandfeet.registration.exception.PersonNotFoundException;
import com.pawandfeet.registration.repository.DogRepository;
import com.pawandfeet.registration.repository.PersonRepository;
import com.pawandfeet.registration.service.DogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Long createDog(DogDTO dogDTO){
        try {
            personRepository.findById(dogDTO.getPersonId());
            logger.info("Dog created");
            return dogRepository.save(dogDTO.toDog()).getId();
        } catch (PersonNotFoundException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public DogDTO findDogById(Long id) throws DogNotFoundException {
        return dogRepository.findById(id).orElseThrow(DogNotFoundException::new).toDogDTO();
    }

    @Override
    public DogDTO updateDog(Long id, DogDTO dogDTO) throws DogNotFoundException {
        Dog dog = dogRepository.findById(id).orElseThrow(DogNotFoundException::new).updateDog(dogDTO);
        return dogRepository.save(dog).toDogDTO();
    }

    @Override
    public void deleteDog(Long id) {
        Dog dog = dogRepository.findById(id).orElseThrow(DogNotFoundException::new);
        dogRepository.delete(dog);
    }
}
