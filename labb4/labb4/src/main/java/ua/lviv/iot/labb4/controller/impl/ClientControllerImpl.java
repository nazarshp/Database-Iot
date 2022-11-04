package ua.lviv.iot.labb4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.labb4.controller.ClientController;
import ua.lviv.iot.labb4.domain.Client;
import ua.lviv.iot.labb4.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientControllerImpl implements ClientController {
    @Autowired
    private ClientService clientService;

    @Override
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public int create(Client client) {
        return clientService.create(client);
    }

    @Override
    public int update(Integer id, Client client) {
        return clientService.update(id, client);
    }

    @Override
    public int delete(Integer id) {
        return clientService.delete(id);
    }

}
