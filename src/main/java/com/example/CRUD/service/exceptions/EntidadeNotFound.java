package com.example.CRUD.service.exceptions;

public class EntidadeNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EntidadeNotFound(String msg){
        super(msg);
    }
}
