package com.ua.lviv.iot.lab5_back_end.dto.assembler;

import com.ua.lviv.iot.lab5_back_end.controller.RoomController;
import com.ua.lviv.iot.lab5_back_end.domain.Room;
import com.ua.lviv.iot.lab5_back_end.dto.RoomDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class RoomDtoAssembler implements RepresentationModelAssembler<Room, RoomDto> {
    @Override
    public RoomDto toModel(Room entity) {
        RoomDto roomDto = RoomDto.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .type(entity.getType())
                .floor(entity.getFloor())
                .price(entity.getPrice())
                .build();
        Link selfLink = linkTo(methodOn(RoomController.class).getRoom(roomDto.getId())).withSelfRel();
        roomDto.add(selfLink);
        return roomDto;
    }
}
