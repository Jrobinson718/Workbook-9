package com.pluralsight.demo.services;

public class StudentAlreadyRegisteredException extends RuntimeException {
    public StudentAlreadyRegisteredException(String message) {

        super(message);
    }

    public StudentAlreadyRegisteredException() {
        super ("Student is already registered!");
    }
}
