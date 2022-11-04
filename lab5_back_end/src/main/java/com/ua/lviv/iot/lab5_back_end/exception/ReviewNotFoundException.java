package com.ua.lviv.iot.lab5_back_end.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(Integer id) {
        super("Could not find 'review' with id=" + id);
    }
}
