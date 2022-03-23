package com.oluwaseun.clientmanagement.service.impl;


import com.oluwaseun.clientmanagement.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client saveClient(Client client);

    Client getClientById(Long id);

    Client updateClient(Client client);

    void deleteClientById(Long id);
}

