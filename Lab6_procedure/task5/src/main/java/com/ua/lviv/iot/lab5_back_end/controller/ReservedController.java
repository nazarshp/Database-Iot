package com.ua.lviv.iot.lab5_back_end.controller;

import com.ua.lviv.iot.lab5_back_end.domain.Reserved;
import com.ua.lviv.iot.lab5_back_end.dto.ReservedDto;
import com.ua.lviv.iot.lab5_back_end.dto.assembler.ReservedDtoAssembler;
import com.ua.lviv.iot.lab5_back_end.service.ReservedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/reserveds")
public class ReservedController {
    @Autowired
    private ReservedService reservedService;
    @Autowired
    private ReservedDtoAssembler reservedDtoAssembler;

    @GetMapping(value = "/{reservedId}")
    public ResponseEntity<ReservedDto> getReserved(@PathVariable Integer reservedId) {
        Reserved reserved = reservedService.findById(reservedId);
        ReservedDto reservedDto = reservedDtoAssembler.toModel(reserved);
        return new ResponseEntity<>(reservedDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ReservedDto>> getAllReserveds() {
        List<Reserved> reserveds = reservedService.findAll();
        CollectionModel<ReservedDto> reservedDtos = reservedDtoAssembler.toCollectionModel(reserveds);
        return new ResponseEntity<>(reservedDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ReservedDto> addReserved(@RequestBody Reserved reserved) {
        Reserved newReserved = reservedService.create(reserved);
        ReservedDto reservedDto = reservedDtoAssembler.toModel(newReserved);
        return new ResponseEntity<>(reservedDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{reservedId}")
    public ResponseEntity<?> updateReserved(@RequestBody Reserved uReserved, @PathVariable Integer reservedId) {
        reservedService.update(reservedId, uReserved);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{reservedId}")
    public ResponseEntity<?> deleteReserved(@PathVariable Integer reservedId) {
        reservedService.delete(reservedId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
