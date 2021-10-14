package com.mchaves.bookstore.exception;

public class DataIntegrityViolationExceptionMChaves extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DataIntegrityViolationExceptionMChaves(String message) {
        super(message);
    }

    public DataIntegrityViolationExceptionMChaves(String message, Throwable cause) {
        super(message, cause);
    }
}
