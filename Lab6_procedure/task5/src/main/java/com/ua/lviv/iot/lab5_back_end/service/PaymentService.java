package com.ua.lviv.iot.lab5_back_end.service;

import com.ua.lviv.iot.lab5_back_end.domain.Payment;

public interface PaymentService extends GeneralService<Payment, Integer> {
    int getMaxSum();
}
