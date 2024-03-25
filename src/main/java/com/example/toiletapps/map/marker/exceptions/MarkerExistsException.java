package com.example.toiletapps.map.marker.exceptions;

import org.springframework.http.HttpStatus;

public class MarkerExistsException extends RuntimeException{
    private final HttpStatus status;

    public MarkerExistsException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
