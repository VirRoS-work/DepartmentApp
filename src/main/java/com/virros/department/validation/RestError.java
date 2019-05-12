package com.virros.department.validation;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestError {

    private Date timestamp;
    private HttpStatus status;
    private String message;
    private String debugMessage;

    public RestError() {
    }

    RestError(Date timestamp, HttpStatus status, String message, String debugMessage) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.debugMessage = debugMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    @Override
    public String toString() {
        return "RestError{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                '}';
    }
}
