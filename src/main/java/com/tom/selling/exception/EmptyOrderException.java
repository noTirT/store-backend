package com.tom.selling.exception;

public class EmptyOrderException extends RuntimeException {
    public EmptyOrderException(Long orderId) {
        super("Order with the id " + orderId + " contains no items.");
    }
}
