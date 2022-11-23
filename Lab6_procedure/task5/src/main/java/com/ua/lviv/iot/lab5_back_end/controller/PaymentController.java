package com.ua.lviv.iot.lab5_back_end.controller;

import com.ua.lviv.iot.lab5_back_end.domain.Payment;
import com.ua.lviv.iot.lab5_back_end.dto.PaymentDto;
import com.ua.lviv.iot.lab5_back_end.dto.assembler.PaymentDtoAssembler;
import com.ua.lviv.iot.lab5_back_end.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PaymentDtoAssembler paymentDtoAssembler;

    @GetMapping(value = "/{paymentId}")
    public ResponseEntity<PaymentDto> getPayment(@PathVariable Integer paymentId) {
        Payment payment = paymentService.findById(paymentId);
        PaymentDto paymentDto = paymentDtoAssembler.toModel(payment);
        return new ResponseEntity<>(paymentDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<PaymentDto>> getAllPayments() {
        List<Payment> payments = paymentService.findAll();
        CollectionModel<PaymentDto> paymentDtos = paymentDtoAssembler.toCollectionModel(payments);
        return new ResponseEntity<>(paymentDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<PaymentDto> addPayment(@RequestBody Payment payment) {
        Payment newPayment = paymentService.create(payment);
        PaymentDto paymentDto = paymentDtoAssembler.toModel(newPayment);
        return new ResponseEntity<>(paymentDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{paymentId}")
    public ResponseEntity<?> updatePayment(@RequestBody Payment uPayment, @PathVariable Integer paymentId) {
        paymentService.update(paymentId, uPayment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{paymentId}")
    public ResponseEntity<?> deletePayment(@PathVariable Integer paymentId) {
        paymentService.delete(paymentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/maxSum")
    public int getMaxSum(){
        return paymentService.getMaxSum();
    }
}
