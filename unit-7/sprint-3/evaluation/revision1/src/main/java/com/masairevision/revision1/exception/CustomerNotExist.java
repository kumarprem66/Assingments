package com.masairevision.revision1.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;






public class CustomerNotExist extends RuntimeException{

    public CustomerNotExist(String msg){
        super(msg);
    }

    public CustomerNotExist(){

    }
}
