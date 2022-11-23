package com.ua.lviv.iot.lab5_back_end.service.impl;

import com.ua.lviv.iot.lab5_back_end.domain.Client;
import com.ua.lviv.iot.lab5_back_end.dto.ClientDto;
import com.ua.lviv.iot.lab5_back_end.exception.ClientNotFoundException;
import com.ua.lviv.iot.lab5_back_end.repository.ClientRepository;
import com.ua.lviv.iot.lab5_back_end.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Client findById(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client create(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Transactional
    public void update(Integer id, Client uClient) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        //update
        client.setName(uClient.getName());
        client.setSurname(uClient.getSurname());
        client.setPhoneNumber(uClient.getPhoneNumber());
        client.setEmail(uClient.getEmail());
        client.setBirthday(uClient.getBirthday());
        client.setGender(uClient.getGender());
        clientRepository.save(client);
    }

    @Transactional
    public void delete(Integer id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
        clientRepository.delete(client);
    }

    @Override
    public void addNonames() throws ParseException {
        clientRepository.cProcedure();
    }

    @Override
    public void callAddingClientProcedure(ClientDto clientDto) {
        clientRepository.addClientProcedure(clientDto.getName(),clientDto.getSurname(),clientDto.getPhone_number(),clientDto.getEmail(),new java.sql.Date(clientDto.getBirthday().getTime()),clientDto.getGender());
    }

    @Override
    public void addTwoTables() {
        clientRepository.addTwoTables();
    }
}
