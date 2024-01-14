package com.scaler.productservicedecmwfeve.exceptions;

public class ProductNotExistException extends Exception {
    public ProductNotExistException(String message) {
        super(message);
    }
}

//we have created an exceptiondto, the reason being, the exception class not have an attriibute,
//so we have created a dto and two attributes in the dto, which will take those messages and show it to the client.