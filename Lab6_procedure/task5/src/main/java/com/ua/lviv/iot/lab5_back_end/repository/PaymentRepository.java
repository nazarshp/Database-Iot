package com.ua.lviv.iot.lab5_back_end.repository;

import com.ua.lviv.iot.lab5_back_end.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Procedure(value = "dp")
    int maxSum();

}
