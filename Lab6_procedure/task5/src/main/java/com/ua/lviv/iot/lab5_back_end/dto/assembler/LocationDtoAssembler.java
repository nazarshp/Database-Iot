package com.ua.lviv.iot.lab5_back_end.dto.assembler;

import com.ua.lviv.iot.lab5_back_end.controller.LocationController;
import com.ua.lviv.iot.lab5_back_end.domain.Location;
import com.ua.lviv.iot.lab5_back_end.dto.LocationDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class LocationDtoAssembler implements RepresentationModelAssembler<Location, LocationDto> {
    @Override
    public LocationDto toModel(Location entity) {
        LocationDto locationDto = LocationDto.builder()
                .id(entity.getId())
                .street(entity.getStreet())
                .city(entity.getCity())
                .build();
        Link selfLink = linkTo(methodOn(LocationController.class).getLocation(locationDto.getId())).withSelfRel();
        locationDto.add(selfLink);
        return locationDto;
    }
}
