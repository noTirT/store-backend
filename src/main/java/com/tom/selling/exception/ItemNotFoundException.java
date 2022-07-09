package com.tom.selling.exception;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(Long id){
        super("No item with the id " + id + " found");
    }
}
