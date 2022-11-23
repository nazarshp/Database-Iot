package com.ua.lviv.iot.lab5_back_end.dto.assembler;

import com.ua.lviv.iot.lab5_back_end.controller.HotelController;
import com.ua.lviv.iot.lab5_back_end.domain.Hotel;
import com.ua.lviv.iot.lab5_back_end.dto.HotelDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class HotelDtoAssembler implements RepresentationModelAssembler<Hotel, HotelDto> {
    @Override
    public HotelDto toModel(Hotel entity) {
        HotelDto hotelDto = HotelDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .hotel_code(entity.getHotelCode())
                .build();
        Link selfLink = linkTo(methodOn(HotelController.class).getHotel(hotelDto.getId())).withSelfRel();
        hotelDto.add(selfLink);
        return hotelDto;
    }
}
