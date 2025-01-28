package com.example.productcatalog.Exceptions;

public class LoginException extends RuntimeException {
    private String message;

    public LoginException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}