package com.ua.lviv.iot.lab5_back_end.repository;

import com.ua.lviv.iot.lab5_back_end.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Procedure(value = "c")
    void cProcedure();
    @Procedure(value = "a")
    void addClientProcedure(String name, String surname, String phone, String email, Date date, String gender);

    @Procedure(value = "e")
    void addTwoTables();
}