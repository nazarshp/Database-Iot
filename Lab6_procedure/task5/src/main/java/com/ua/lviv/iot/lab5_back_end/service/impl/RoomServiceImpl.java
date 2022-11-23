package com.ua.lviv.iot.lab5_back_end.service.impl;

import com.ua.lviv.iot.lab5_back_end.domain.Room;
import com.ua.lviv.iot.lab5_back_end.exception.RoomNotFoundException;
import com.ua.lviv.iot.lab5_back_end.repository.RoomRepository;
import com.ua.lviv.iot.lab5_back_end.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;

    public Room findById(Integer id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Transactional
    public Room create(Room room) {
        roomRepository.save(room);
        return room;
    }

    @Transactional
    public void update(Integer id, Room uRoom) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));

        //update
        room.setNumber(uRoom.getNumber());
        room.setFloor(uRoom.getFloor());
        room.setType(uRoom.getType());
        room.setPrice(uRoom.getPrice());
        roomRepository.save(room);
    }

    @Transactional
    public void delete(Integer id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
        roomRepository.delete(room);
    }

    @Override
    public void addMtoM(int reservedId) {
        roomRepository.AddMToM(reservedId);
    }
}
