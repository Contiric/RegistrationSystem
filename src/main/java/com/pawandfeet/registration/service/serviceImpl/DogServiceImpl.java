package com.pawandfeet.registration.service.serviceImpl;

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

    private PersonRepository personRepository;

    @Override
    public Long createDog(DogDTO dogDTO) throws PersonNotFoundException {
        Optional<Person> person = personRepository.findById(dogDTO.getPersonId());
        if (person.isEmpty()) throw new PersonNotFoundException();
        return dogRepository.save(dogDTO.toDog()).getId();
    }

    @Override
    public void updateDog(Long id, DogDTO dogDTO) throws DogNotFoundException {
        Optional<Dog> dog = dogRepository.findById(id);
        if (dog.isEmpty()) throw new DogNotFoundException();
        BeanUtils.copyProperties(dog.get(), dogDTO, "id");
        dogRepository.save(dog.get());
    }

    @Override
    public DogDTO findDogById(Long id) throws DogNotFoundException {
        Optional<Dog> dog = dogRepository.findById(id);
        if (dog.isEmpty()) throw new DogNotFoundException();
        return dog.get().toDogDTO();
    }

    @Override
    public void deleteDog(Long id) throws DogNotFoundException {
        Optional<Dog> dog = dogRepository.findById(id);
        if (dog.isEmpty()) throw new DogNotFoundException();
        dogRepository.delete(dog.get());
    }
}
