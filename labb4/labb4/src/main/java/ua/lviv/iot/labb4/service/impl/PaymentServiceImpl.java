package ua.lviv.iot.labb4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.dao.PaymentDao;
import ua.lviv.iot.labb4.domain.Payment;
import ua.lviv.iot.labb4.service.PaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public List<Payment> findAll() {
        return paymentDao.findAll();
    }

    @Override
    public Optional<Payment> findById(Integer id) {
        return paymentDao.findById(id);
    }

    @Override
    public int create(Payment payment) { return paymentDao.create(payment);
    }

    @Override
    public int update(Integer id, Payment payment) {
        return paymentDao.update(id, payment);
    }

    @Override
    public int delete(Integer id) {
        return paymentDao.delete(id);
    }

}
