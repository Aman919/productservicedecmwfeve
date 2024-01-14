package com.scaler.productservicedecmwfeve.controlleradvices;

import com.scaler.productservicedecmwfeve.dto.ArithmeticExceptionDto;
import com.scaler.productservicedecmwfeve.dto.ExceptionDto;
import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException() {
        ArithmeticExceptionDto arithmeticExceptionDto = new ArithmeticExceptionDto();
        arithmeticExceptionDto.setMessage("Something has gone wrong");
        return new ResponseEntity<>(arithmeticExceptionDto, HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotExistException.class)
    public ResponseEntity<ExceptionDto> handleProductNotExistException(ProductNotExistException exception){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(exception.getMessage());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    };

}
