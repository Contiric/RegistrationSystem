package com.pawandfeet.registration.exception;

public class DogNotFoundException extends Exception {

    public DogNotFoundException() {
        super("Dog not found.");
    }
}
