package com.ua.lviv.iot.lab5_back_end.exception;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(Integer id) {
        super("Could not find 'hotel' with id=" + id);
    }
}
