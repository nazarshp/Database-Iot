package com.ua.lviv.iot.lab5_back_end.dto.assembler;

import com.ua.lviv.iot.lab5_back_end.controller.ClientController;
import com.ua.lviv.iot.lab5_back_end.domain.Client;
import com.ua.lviv.iot.lab5_back_end.dto.ClientDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ClientDtoAssembler implements RepresentationModelAssembler<Client, ClientDto> {
    @Override
    public ClientDto toModel(Client entity) {
        ClientDto clientDto = ClientDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .phone_number(entity.getPhoneNumber())
                .surname(entity.getSurname())
                .email(entity.getEmail())
                .birthday(entity.getBirthday())
                .gender(entity.getGender())
                .build();
        Link selfLink = linkTo(methodOn(ClientController.class).getClient(clientDto.getId())).withSelfRel();
        clientDto.add(selfLink);
        return clientDto;
    }
}
