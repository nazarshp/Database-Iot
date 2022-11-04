package com.ua.lviv.iot.lab5_back_end.exception;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Integer id) {
        super("Could not find 'room' with id=" + id);
    }
}
