package com.pawandfeet.registration.controller.impl;

import com.pawandfeet.registration.controller.DogController;
import com.pawandfeet.registration.dto.DogDTO;
import com.pawandfeet.registration.exception.DogNotFoundException;
import com.pawandfeet.registration.exception.PersonNotFoundException;
import com.pawandfeet.registration.service.DogService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = DogController.PATH)
public class DogControllerImp implements DogController {

    @Autowired
    private DogService dogService;

    @Override
    @PostMapping(path = "/createDog")
    public Object createDog(@RequestBody DogDTO dogDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(dogService.createDog(dogDTO));
        } catch (DogNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).eTag(exception.getMessage());
        }
    }

    @Override
    @GetMapping(path = "findDogById/{id}")
    public Object findDogByID(@PathParam("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(dogService.findDogById(id));
        } catch (DogNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).eTag(exception.getMessage());
        }
    }

    @Override
    @PatchMapping(path = "updateDog/{id}")
    public Object updateDog(@PathParam("id") Long id, @RequestBody DogDTO dogDTO) {
        try {
            dogService.updateDog(id,dogDTO);
            return ResponseEntity.status(HttpStatus.OK);
        } catch (DogNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).eTag(exception.getMessage());
        }
    }

    @Override
    @DeleteMapping(path = "deleteDog/id")
    public Object deleteDog(@PathParam("id") Long id) {
        try {
            dogService.deleteDog(id);
            return ResponseEntity.status(HttpStatus.OK);
        } catch (DogNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).eTag(exception.getMessage());
        }
    }
}
