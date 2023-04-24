package com.example.rockpaperscissor.exceptions;

public class InvalidChoiceException extends RuntimeException {

    public InvalidChoiceException(String message) {
        super(message);
    }
}
