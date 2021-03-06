package com.melibootcamp.DesafioQuality.exceptionHandler;

import jdk.jshell.spi.ExecutionControlProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.UnexpectedTypeException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler({UnexpectedTypeException.class, HttpMessageNotReadableException.class, DistrictNotFoundException.class})
    public ResponseEntity UnexpectedTypeException(Exception e, WebRequest request){
        return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request){

        List<InvalidField> invalidFieldsList = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            invalidFieldsList.add(new InvalidField(fieldError.getField(), fieldError.getDefaultMessage()));
        });

        return new ResponseEntity<ErrorMessage>(new ErrorMessage("MethodArgumentNotValidException", invalidFieldsList), HttpStatus.BAD_REQUEST);

    }

}
