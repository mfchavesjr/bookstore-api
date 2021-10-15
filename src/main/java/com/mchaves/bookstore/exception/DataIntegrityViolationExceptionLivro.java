package com.mchaves.bookstore.exception;

public class DataIntegrityViolationExceptionLivro extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DataIntegrityViolationExceptionLivro(String message) {
        super(message);
    }

    public DataIntegrityViolationExceptionLivro(String message, Throwable cause) {
        super(message, cause);
    }
}
