package ua.lviv.iot.labb4.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.dao.PaymentDao;
import ua.lviv.iot.labb4.domain.Payment;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class PaymentDaoImpl implements PaymentDao {
    private static final String FIND_ALL = "SELECT * FROM payment";
    private static final String CREATE = "INSERT payment(date, suma) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE payment SET date=?, suma=? WHERE id=?";
    private static final String DELETE = "DELETE FROM payment WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM payment WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Payment> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Payment.class));
    }

    @Override
    public Optional<Payment> findById(Integer id) {
        Optional<Payment> payment;
        try {
            payment = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Payment.class), id));
        } catch (EmptyResultDataAccessException e) {
            payment = Optional.empty();
        }
        return payment;
    }

    @Override
    public int create(Payment payment) {
        return jdbcTemplate.update(CREATE, payment.getDate(),  payment.getSuma());
    }

    @Override
    public int update(Integer id, Payment payment) {
        return jdbcTemplate.update(UPDATE, payment.getDate(),  payment.getSuma(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

}
