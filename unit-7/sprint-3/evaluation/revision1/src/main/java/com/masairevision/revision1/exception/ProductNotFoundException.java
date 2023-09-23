package com.masairevision.revision1.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){

    }

    public ProductNotFoundException(String msg){
        super(msg);
    }
}
