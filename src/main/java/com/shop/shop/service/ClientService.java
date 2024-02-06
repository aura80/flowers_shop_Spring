package com.shop.shop.service;

import com.shop.shop.dto.ClientDto;
import com.shop.shop.model.Client;

import java.util.List;

public interface ClientService {

    ClientDto saveClient(ClientDto clientDto);
    void saveAllClients(List<Client> clientsDto);
    List<ClientDto> getAllClients();
    ClientDto getClientById(Long id);
    ClientDto getClientByName(String name);
    ClientDto findClientByEmail(String email);
    ClientDto getClientByNameAndPhone(String name, String email);
    ClientDto getClientByEmailAndPassword(String email, String password);
    ClientDto updateClientById(ClientDto clientDto, Long id);
    void deleteClientById(Long id);
}
