package com.ust.exceptions;

public class OrderNoStockException extends RuntimeException {
    public OrderNoStockException(String s) {
        super(s);
    }
}
