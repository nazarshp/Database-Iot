package ua.lviv.iot.labb4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.dao.ReservedDao;
import ua.lviv.iot.labb4.domain.Reserved;
import ua.lviv.iot.labb4.service.ReservedService;

import java.util.List;
import java.util.Optional;

@Service
public class ReservedServiceImpl implements ReservedService {
    @Autowired
    private ReservedDao reservedDao;

    @Override
    public List<Reserved> findAll() {
        return reservedDao.findAll();
    }

    @Override
    public Optional<Reserved> findById(Integer id) {
        return reservedDao.findById(id);
    }

    @Override
    public int create(Reserved reserved) {
        return reservedDao.create(reserved);
    }

    @Override
    public int update(Integer id, Reserved reserved) {
        return reservedDao.update(id, reserved);
    }

    @Override
    public int delete(Integer id) {
        return reservedDao.delete(id);
    }

}
