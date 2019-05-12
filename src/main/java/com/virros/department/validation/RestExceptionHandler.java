package com.virros.department.validation;

import com.virros.department.validation.exceptions.EntityDeleteException;
import com.virros.department.validation.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFoundEx(EntityNotFoundException ex, WebRequest request) {

        RestError error = new RestError(new Date(), HttpStatus.NOT_FOUND, "Entity not Found!", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityDeleteException.class)
    protected ResponseEntity<Object> handleEntityDeleteEx(EntityDeleteException ex, WebRequest request) {

        RestError error = new RestError(new Date(), HttpStatus.CONFLICT, "Error deleting!", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
