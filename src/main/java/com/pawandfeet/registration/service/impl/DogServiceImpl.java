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

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Long createDog(DogDTO dogDTO) throws PersonNotFoundException {
        personRepository.findById(dogDTO.getPersonId()).orElseThrow(PersonNotFoundException::new);
        return dogRepository.save(dogDTO.toDog()).getId();
    }

    @Override
    public void updateDog(Long id, DogDTO dogDTO) throws DogNotFoundException {
        Dog dog = dogRepository.findById(id).orElseThrow(DogNotFoundException::new).updateDog(dogDTO);
        dogRepository.save(dog);
    }

    @Override
    public DogDTO findDogById(Long id) throws DogNotFoundException {
        return dogRepository.findById(id).orElseThrow(DogNotFoundException::new).toDogDTO();
    }

    @Override
    public void deleteDog(Long id) throws DogNotFoundException {
        Dog dog = dogRepository.findById(id).orElseThrow(DogNotFoundException::new);
        dogRepository.delete(dog);
    }
}
