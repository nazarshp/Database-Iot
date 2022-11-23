package com.ua.lviv.iot.lab5_back_end.service.impl;

import com.ua.lviv.iot.lab5_back_end.domain.Payment;
import com.ua.lviv.iot.lab5_back_end.exception.PaymentNotFoundException;
import com.ua.lviv.iot.lab5_back_end.repository.PaymentRepository;
import com.ua.lviv.iot.lab5_back_end.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Payment findById(Integer id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Transactional
    public Payment create(Payment payment) {
        paymentRepository.save(payment);
        return payment;
    }

    @Transactional
    public void update(Integer id, Payment uPayment) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));

        //update
        payment.setDate(uPayment.getDate());
        payment.setSuma(uPayment.getSuma());
        paymentRepository.save(payment);
    }

    @Transactional
    public void delete(Integer id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
        paymentRepository.delete(payment);
    }
    public int getMaxSum(){
        return paymentRepository.maxSum();
    }
}
