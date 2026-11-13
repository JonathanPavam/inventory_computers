package com.inventory.exceptions;

public class RequiredObjectsNullException extends RuntimeException {
    public RequiredObjectsNullException() {
        super("It is not allowed to persisted a null object");
    }
    public RequiredObjectsNullException(String message) {
        super(message);
    }
}
