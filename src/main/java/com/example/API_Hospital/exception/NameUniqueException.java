package com.example.API_Hospital.exception;

public class NameUniqueException extends RuntimeException{
    public NameUniqueException(String error){
        super(error);
    }
}
