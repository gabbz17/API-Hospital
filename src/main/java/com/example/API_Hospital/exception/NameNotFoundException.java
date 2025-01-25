package com.example.API_Hospital.exception;

public class NameNotFoundException extends RuntimeException{
    public NameNotFoundException(String error) {
        super(error);
    }
}
