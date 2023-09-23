package com.masairevision.revision1.exception;

import com.masairevision.revision1.entity.Order;


public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String message){
        super(message);
    }

    public OrderNotFoundException(){

    }
}
