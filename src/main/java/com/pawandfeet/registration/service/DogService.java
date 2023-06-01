package com.pawandfeet.registration.service;

import com.pawandfeet.registration.dto.DogDTO;
import com.pawandfeet.registration.exception.DogNotFoundException;
import com.pawandfeet.registration.exception.PersonNotFoundException;

public interface DogService {

    Long createDog(DogDTO dogDTO) throws PersonNotFoundException;
    void updateDog(Long id, DogDTO dogDTO) throws DogNotFoundException;
    DogDTO findDogById(Long id) throws DogNotFoundException;
    void deleteDog(Long id) throws DogNotFoundException;
}
