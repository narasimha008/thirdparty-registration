package com.syncronys.registration.tpr.service;

import com.syncronys.registration.tpr.dto.ClientDto;

import java.util.List;

public interface ClientService {
    void saveClient(ClientDto userDto);

    void updateClient(ClientDto userDto);

    ClientDto findByClient(ClientDto clientDto);

    List<ClientDto> findAllClients();
}
