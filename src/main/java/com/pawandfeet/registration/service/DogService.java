package com.pawandfeet.registration.service;

import com.pawandfeet.registration.dto.DogDTO;
import com.pawandfeet.registration.exception.DogNotFoundException;
import com.pawandfeet.registration.exception.PersonNotFoundException;

import java.util.logging.Logger;

public interface DogService {

    Logger logger = Logger.getLogger(String.valueOf(DogService.class));
    Long createDog(DogDTO dogDTO) throws PersonNotFoundException;
    DogDTO updateDog(Long id, DogDTO dogDTO) throws DogNotFoundException;
    DogDTO findDogById(Long id) throws DogNotFoundException;
    void deleteDog(Long id) throws DogNotFoundException;
}
