package com.ua.lviv.iot.lab5_back_end.dto.assembler;

import com.ua.lviv.iot.lab5_back_end.controller.ReservedController;
import com.ua.lviv.iot.lab5_back_end.domain.Reserved;
import com.ua.lviv.iot.lab5_back_end.dto.ReservedDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ReservedDtoAssembler implements RepresentationModelAssembler<Reserved, ReservedDto> {
    @Override
    public ReservedDto toModel(Reserved entity) {
        ReservedDto reservedDto = ReservedDto.builder()
                .id(entity.getId())
                .from_date(entity.getFromDate())
                .to_date(entity.getToDate())
                .build();
        Link selfLink = linkTo(methodOn(ReservedController.class).getReserved(reservedDto.getId())).withSelfRel();
        reservedDto.add(selfLink);
        return reservedDto;
    }
}
