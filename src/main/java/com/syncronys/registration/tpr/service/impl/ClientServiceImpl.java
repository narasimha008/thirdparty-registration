package com.syncronys.registration.tpr.service.impl;

import com.syncronys.registration.tpr.dto.ClientDto;
import com.syncronys.registration.tpr.entity.Client;
import com.syncronys.registration.tpr.repository.ClientRepository;
import com.syncronys.registration.tpr.repository.UserRepository;
import com.syncronys.registration.tpr.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    public static final String MM_DD_YYYY = "MM-dd-yyyy";
    private UserRepository userRepository;
    private ClientRepository clientRepository;

    public ClientServiceImpl(UserRepository userRepository,
                             ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void saveClient(ClientDto userDto) {
        Client client = new Client();
        BeanUtils.copyProperties(userDto, client);
        client.setStatus("Deny");
        clientRepository.save(client);
    }

    @Override
    public ClientDto findByClient(ClientDto clientDto) {
        Client client = clientRepository.findById(clientDto.getId()).get();
        return convertEntityToDto(client);
    }

    @Override
    public List<ClientDto> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map((client) -> convertEntityToDto(client))
                .collect(Collectors.toList());
    }

    private ClientDto convertEntityToDto(Client client) {
        if (ObjectUtils.isEmpty(client)) {
            return null;
        }
        ClientDto userDto = new ClientDto();
        BeanUtils.copyProperties(client, userDto);
        return userDto;
    }


    @Override
    public void updateClient(ClientDto clientDto) {
        Client client = clientRepository.findById(clientDto.getId()).get();
        client.setStatus(clientDto.getStatus());
        clientRepository.save(client);
    }

}
