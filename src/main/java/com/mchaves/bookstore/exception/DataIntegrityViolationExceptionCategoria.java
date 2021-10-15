package com.mchaves.bookstore.exception;

public class DataIntegrityViolationExceptionCategoria extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DataIntegrityViolationExceptionCategoria(String message) {
        super(message);
    }

    public DataIntegrityViolationExceptionCategoria(String message, Throwable cause) {
        super(message, cause);
    }
}
