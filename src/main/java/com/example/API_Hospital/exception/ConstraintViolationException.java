package com.example.API_Hospital.exception;

public class ConstraintViolationException extends RuntimeException{
    public ConstraintViolationException(String error){
        super(error);
    }
}
