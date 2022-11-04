package com.ua.lviv.iot.lab5_back_end.exception;

public class ReservedNotFoundException extends RuntimeException {
    public ReservedNotFoundException(Integer id) {
        super("Could not find 'reserved' with id=" + id);
    }
}
