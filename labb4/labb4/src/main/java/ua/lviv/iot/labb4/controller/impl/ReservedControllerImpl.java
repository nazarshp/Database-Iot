package ua.lviv.iot.labb4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.controller.ReservedController;
import ua.lviv.iot.labb4.domain.Reserved;
import ua.lviv.iot.labb4.service.ReservedService;

import java.util.List;
import java.util.Optional;

@Service
public class ReservedControllerImpl implements ReservedController {
    @Autowired
    private ReservedService reservedService;

    @Override
    public List<Reserved> findAll() {
        return reservedService.findAll();
    }

    @Override
    public Optional<Reserved> findById(Integer id) {
        return reservedService.findById(id);
    }

    @Override
    public int create(Reserved payment) {
        return reservedService.create(payment);
    }

    @Override
    public int update(Integer id, Reserved reserved) {
        return reservedService.update(id, reserved);
    }

    @Override
    public int delete(Integer id) {
        return reservedService.delete(id);
    }

}
