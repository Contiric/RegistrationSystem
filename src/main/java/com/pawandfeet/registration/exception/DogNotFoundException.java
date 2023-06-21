package com.pawandfeet.registration.exception;

public class DogNotFoundException extends RuntimeException {

    public DogNotFoundException() {
        super("Dog not found.");
    }
}
