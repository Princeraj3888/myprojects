package com.demo.springboot_cache.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timeStamp, String message, String details){
        this.timeStamp = timeStamp;
        this.details = details;
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
