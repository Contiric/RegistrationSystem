package com.pawandfeet.registration.exception;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException() {
        super("Person not found.");
    }
}
