package ua.lviv.iot.labb4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.dao.RoomDao;
import ua.lviv.iot.labb4.domain.Room;
import ua.lviv.iot.labb4.service.RoomService;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;

    @Override
    public List<Room> findAll() {
        return roomDao.findAll();
    }

    @Override
    public Optional<Room> findById(Integer id) {
        return roomDao.findById(id);
    }

    @Override
    public int create(Room room) {
        return roomDao.create(room);
    }

    @Override
    public int update(Integer id, Room room) {
        return roomDao.update(id, room);
    }

    @Override
    public int delete(Integer id) {
        return roomDao.delete(id);
    }

}
