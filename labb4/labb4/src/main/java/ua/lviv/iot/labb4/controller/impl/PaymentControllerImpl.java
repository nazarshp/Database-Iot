package ua.lviv.iot.labb4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.controller.PaymentController;
import ua.lviv.iot.labb4.domain.Payment;
import ua.lviv.iot.labb4.service.PaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentControllerImpl implements PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Override
    public List<Payment> findAll() {
        return paymentService.findAll();
    }

    @Override
    public Optional<Payment> findById(Integer id) {
        return paymentService.findById(id);
    }

    @Override
    public int create(Payment payment) {
        return paymentService.create(payment);
    }

    @Override
    public int update(Integer id, Payment payment) {
        return paymentService.update(id, payment);
    }

    @Override
    public int delete(Integer id) {
        return paymentService.delete(id);
    }

}
