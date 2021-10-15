package com.mchaves.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class HandleDataIntegrityViolationExceptionMChaves {
    @ExceptionHandler(DataIntegrityViolationExceptionCategoria.class)
    public ResponseEntity<StandardError> dataIntegrityViolationExceptionMChaves(DataIntegrityViolationExceptionCategoria ex
            , ServletRequest servletRequest){
        StandardError error = new StandardError(System.currentTimeMillis()
                , HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationExceptionLivro.class)
    public ResponseEntity<StandardError> dataIntegrityViolationExceptionLivro(DataIntegrityViolationExceptionLivro ex
            , ServletRequest servletRequest){
        StandardError error = new StandardError(System.currentTimeMillis()
                , HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
