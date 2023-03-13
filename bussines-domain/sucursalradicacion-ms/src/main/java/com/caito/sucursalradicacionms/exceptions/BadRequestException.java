package com.caito.sucursalradicacionms.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String msg){
        super(msg);
    }
}
