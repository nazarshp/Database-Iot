package com.ua.lviv.iot.lab5_back_end.dto.assembler;

import com.ua.lviv.iot.lab5_back_end.controller.PaymentController;
import com.ua.lviv.iot.lab5_back_end.domain.Payment;
import com.ua.lviv.iot.lab5_back_end.dto.PaymentDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class PaymentDtoAssembler implements RepresentationModelAssembler<Payment, PaymentDto> {
    @Override
    public PaymentDto toModel(Payment entity) {
        PaymentDto paymentDto = PaymentDto.builder()
                .id(entity.getId())
                .suma(entity.getSuma())
                .date(entity.getDate())
                .build();
        Link selfLink = linkTo(methodOn(PaymentController.class).getPayment(paymentDto.getId())).withSelfRel();
        paymentDto.add(selfLink);
        return paymentDto;
    }
}
