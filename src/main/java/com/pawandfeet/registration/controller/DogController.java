package com.pawandfeet.registration.controller;

import com.pawandfeet.registration.dto.DogDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface DogController {
    public static final String PATH = "/api/pawandfeet";

    public Object createDog(DogDTO dogDTO);

    public Object findDogByID(Long id);

    public Object updateDog(Long id, DogDTO dogDTO);

    public Object deleteDog(@PathVariable("id") Long id);
}
