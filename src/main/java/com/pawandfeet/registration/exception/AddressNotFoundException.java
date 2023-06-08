package com.pawandfeet.registration.exception;

public class AddressNotFoundException extends Exception {

    public AddressNotFoundException() {
        super("Address not found.");
    }
}
