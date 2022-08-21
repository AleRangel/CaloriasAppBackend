package com.example.demo.excepciones;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus status;
    private String message;

    public AppException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public AppException(HttpStatus status, String message, String message1) {
        this.status = status;
        this.message = message;
        this.message = message1;
    }

    /**
     * @return HttpStatus return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     * @return String return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
