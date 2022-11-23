package com.ua.lviv.iot.lab5_back_end.service;

import com.ua.lviv.iot.lab5_back_end.domain.Client;
import com.ua.lviv.iot.lab5_back_end.dto.ClientDto;

import java.text.ParseException;

public interface ClientService extends GeneralService<Client, Integer> {
    void addNonames() throws ParseException;
    void callAddingClientProcedure(ClientDto clientDto);
    void addTwoTables();
}
