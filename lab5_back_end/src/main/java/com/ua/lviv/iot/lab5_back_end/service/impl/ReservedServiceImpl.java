package com.ua.lviv.iot.lab5_back_end.service.impl;

import com.ua.lviv.iot.lab5_back_end.domain.Reserved;
import com.ua.lviv.iot.lab5_back_end.exception.ReservedNotFoundException;
import com.ua.lviv.iot.lab5_back_end.repository.ReservedRepository;
import com.ua.lviv.iot.lab5_back_end.service.ReservedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReservedServiceImpl implements ReservedService {

    @Autowired
    ReservedRepository reservedRepository;

    public Reserved findById(Integer id) {
        return reservedRepository.findById(id)
                .orElseThrow(() -> new ReservedNotFoundException(id));
    }

    public List<Reserved> findAll() {
        return reservedRepository.findAll();
    }

    @Transactional
    public Reserved create(Reserved reserved) {
        reservedRepository.save(reserved);
        return reserved;
    }

    @Transactional
    public void update(Integer id, Reserved uReserved) {
        Reserved reserved = reservedRepository.findById(id)
                .orElseThrow(() -> new ReservedNotFoundException(id));

        //update
        reserved.setFromDate(uReserved.getFromDate());
        reserved.setToDate(uReserved.getToDate());
        reservedRepository.save(reserved);
    }

    @Transactional
    public void delete(Integer id) {
        Reserved reserved = reservedRepository.findById(id)
                .orElseThrow(() -> new ReservedNotFoundException(id));
        reservedRepository.delete(reserved);
    }
}
