package com.masairevision.revision1.exception;

public class ProductAlreadyExistException extends RuntimeException{

    public ProductAlreadyExistException(String msg){
        super(msg);
    }

    public ProductAlreadyExistException(){

    }
}
