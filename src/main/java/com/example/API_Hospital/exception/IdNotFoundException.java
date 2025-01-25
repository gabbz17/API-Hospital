package com.example.API_Hospital.exception;

public class IdNotFoundException extends  RuntimeException{
    public IdNotFoundException (String error){
        super(error);
    }
}
