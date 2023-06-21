package com.pawandfeet.registration.exception;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException() {
        super("Address not found.");
    }
}
