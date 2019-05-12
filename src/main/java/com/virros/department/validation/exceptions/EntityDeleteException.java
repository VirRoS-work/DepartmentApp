package com.virros.department.validation.exceptions;

public class EntityDeleteException extends RuntimeException{

    public EntityDeleteException() {
    }

    public EntityDeleteException(String message) {
        super(message);
    }
}
