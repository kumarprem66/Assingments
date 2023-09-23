package com.masairevision.revision1.exception;

public class CustomerAlreadyExist extends RuntimeException{

    public CustomerAlreadyExist(String msg){
        super(msg);
    }

    public CustomerAlreadyExist(){

    }
}
