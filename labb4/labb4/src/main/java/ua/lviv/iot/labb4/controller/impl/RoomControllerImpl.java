package ua.lviv.iot.labb4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.controller.RoomController;
import ua.lviv.iot.labb4.domain.Room;
import ua.lviv.iot.labb4.service.RoomService;

import java.util.List;
import java.util.Optional;

@Service
public class RoomControllerImpl implements RoomController {
    @Autowired
    private RoomService roomService;

    @Override
    public List<Room> findAll() {
        return roomService.findAll();
    }

    @Override
    public Optional<Room> findById(Integer id) {
        return roomService.findById(id);
    }

    @Override
    public int create(Room room) {
        return roomService.create(room);
    }

    @Override
    public int update(Integer id, Room room) {
        return roomService.update(id, room);
    }

    @Override
    public int delete(Integer id) {
        return roomService.delete(id);
    }

}