package com.ust.exceptions;

public class DuplicateOrderException extends RuntimeException {
    public DuplicateOrderException(String s) {
        super(s);
    }
}
