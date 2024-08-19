package com.ust.exceptions;

public class DuplicateBookException extends RuntimeException {
    public DuplicateBookException(String s) {
        super(s);
    }
}
