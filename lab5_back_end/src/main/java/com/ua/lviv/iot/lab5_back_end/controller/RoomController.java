package com.ua.lviv.iot.lab5_back_end.controller;

import com.ua.lviv.iot.lab5_back_end.domain.Room;
import com.ua.lviv.iot.lab5_back_end.dto.RoomDto;
import com.ua.lviv.iot.lab5_back_end.dto.assembler.RoomDtoAssembler;
import com.ua.lviv.iot.lab5_back_end.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomDtoAssembler roomDtoAssembler;

    @GetMapping(value = "/{roomId}")
    public ResponseEntity<RoomDto> getRoom(@PathVariable Integer roomId) {
        Room room = roomService.findById(roomId);
        RoomDto roomDto = roomDtoAssembler.toModel(room);
        return new ResponseEntity<>(roomDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<RoomDto>> getAllRooms() {
        List<Room> rooms = roomService.findAll();
        CollectionModel<RoomDto> roomDtos = roomDtoAssembler.toCollectionModel(rooms);
        return new ResponseEntity<>(roomDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<RoomDto> addRoom(@RequestBody Room room) {
        Room newRoom = roomService.create(room);
        RoomDto roomDto = roomDtoAssembler.toModel(newRoom);
        return new ResponseEntity<>(roomDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{roomId}")
    public ResponseEntity<?> updateRoom(@RequestBody Room uRoom, @PathVariable Integer roomId) {
        roomService.update(roomId, uRoom);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{roomId}")
    public ResponseEntity<?> deleteRoom(@PathVariable Integer roomId) {
        roomService.delete(roomId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
