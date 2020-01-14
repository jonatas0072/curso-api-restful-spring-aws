package com.springcurso.exception;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7208760595734379119L;

    public NotFoundException(String msg) {
        super(msg);
    }
}
