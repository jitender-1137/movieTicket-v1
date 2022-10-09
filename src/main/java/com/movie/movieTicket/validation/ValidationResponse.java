package com.movie.movieTicket.validation;

public class ValidationResponse {

    private String timestamp;

    private String message;

    private String details;

    public ValidationResponse(String timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

}
