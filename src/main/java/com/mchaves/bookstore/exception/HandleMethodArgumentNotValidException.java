package com.mchaves.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class HandleMethodArgumentNotValidException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException ex
            , ServletRequest servletRequest){
        ValidationError error = new ValidationError(System.currentTimeMillis()
                , HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos");
        for (FieldError x : ex.getBindingResult().getFieldErrors()){
            error.addErrors(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
