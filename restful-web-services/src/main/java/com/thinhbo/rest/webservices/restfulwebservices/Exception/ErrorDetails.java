package com.thinhbo.rest.webservices.restfulwebservices.Exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timesStamp;
    private String message;
    private String details;

    public ErrorDetails() {
    }

    public ErrorDetails(LocalDateTime timesStamp, String message, String details) {
        this.timesStamp = timesStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimesStamp() {
        return timesStamp;
    }

    public void setTimesStamp(LocalDateTime timesStamp) {
        this.timesStamp = timesStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
