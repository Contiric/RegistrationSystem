package com.pawandfeet.registration.exception;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException() {
        super("Person not found.");
    }
}
