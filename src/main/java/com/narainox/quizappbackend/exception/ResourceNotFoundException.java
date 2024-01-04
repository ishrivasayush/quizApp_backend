package com.narainox.quizappbackend.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String type;
    private Object value;

    public ResourceNotFoundException(String resource, String type, Object value) {
        super(String.format("%s Not Found With %s: %s",resource,type,value));
        this.resource = resource;
        this.type = type;
        this.value = value;
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
