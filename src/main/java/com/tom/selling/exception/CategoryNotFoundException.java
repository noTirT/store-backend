package com.tom.selling.exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Long categoryId){
        super("No category with the id " + categoryId + " found");
    }
}
