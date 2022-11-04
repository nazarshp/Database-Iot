package com.ua.lviv.iot.lab5_back_end.exception;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(Integer id) {
        super("Could not find 'payment' with id=" + id);
    }
}
