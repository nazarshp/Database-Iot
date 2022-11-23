package com.ua.lviv.iot.lab5_back_end.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Integer id) {
        super("Could not find 'client' with id=" + id);
    }
}
