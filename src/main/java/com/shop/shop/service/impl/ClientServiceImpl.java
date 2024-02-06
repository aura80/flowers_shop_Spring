package com.shop.shop.service.impl;

import com.shop.shop.dto.ClientDto;
import com.shop.shop.exceptions.NotFoundException;
import com.shop.shop.model.Client;
import com.shop.shop.repository.ClientRepository;
import com.shop.shop.service.ClientService;
import com.shop.shop.utils.DualEntityDtoConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override   // create
    public ClientDto saveClient(ClientDto clientDto) {
        log.info("---> Saving client <---");
        Client clientEntity = DualEntityDtoConverter.toEntity(clientDto);
        Client savedClientEntity = clientRepository.save(clientEntity);

        return DualEntityDtoConverter.toDto(savedClientEntity);
    }

    @Override
    public void saveAllClients(List<Client> clients) {
        log.info("---> Saving all the clients <---");

        clientRepository.saveAll(clients);
    }

    @Override
    public List<ClientDto> getAllClients() {
        log.info("---> Retrieving all the clients <---");
        List<Client> clients = clientRepository.findAll();

        return clients.stream()
                .map(DualEntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto getClientById(Long id) {
        log.info("---> Retrieving client by ID: {} <---", id);
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("the client with id: " + id + " was not found"));

        return DualEntityDtoConverter.toDto(client);
    }

    @Override
    public ClientDto getClientByName(String name) {
        log.info("---> Retrieving client by name: {} <---", name);
        Client client = clientRepository.getClientByName(name)
                .orElseThrow(() -> new NotFoundException("Client with name: " + name + " was not found"));

        return DualEntityDtoConverter.toDto(client);
    }

    @Override
    public ClientDto findClientByEmail(String email) {
        log.info("---> Retrieving client by email: {} <---", email);
        Client client = clientRepository.findClientByEmail(email)
                .orElseThrow(() -> new NotFoundException("Client with email: " + email + " was not found"));

        return DualEntityDtoConverter.toDto(client);
    }

    @Override
    public ClientDto getClientByNameAndPhone(String name, String phone) {
        log.info("---> Retrieving client by name: {} and phone: {} <---", name, phone);
        Client client = clientRepository.getClientByNameAndPhone(name, phone)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Client with name: " + name + " and phone " + phone + " was not found")
                ));

        return DualEntityDtoConverter.toDto(client);
    }

    @Override
    public ClientDto getClientByEmailAndPassword(String email, String password) {
        log.info("---> Retrieving client by email: {} and password: {} <---", email, password);
        Client client = clientRepository.getClientByEmailAndPassword(email, password)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Client with email: " + email + " and password " + password + " was not found")
                ));

        return DualEntityDtoConverter.toDto(client);
    }

    @Override
    public ClientDto updateClientById(ClientDto clientDto, Long id) {
        log.info("---> Updating client by ID: {} <---", id);
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("the client with id: " + id + " was not found"));

        client.setName(clientDto.getName());
        client.setAddress(clientDto.getAddress());
        client.setEmail(clientDto.getEmail());
        client.setPassword(clientDto.getPassword());
        client.setPhone(clientDto.getPhone());

        Client updatedClient = clientRepository.save(client);

        return DualEntityDtoConverter.toDto(updatedClient);
    }

    @Override
    public void deleteClientById(Long id) {
        log.info("---> Deleting client by ID: {} <---", id);
        clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Client with id: " + id + " was not found"));

        clientRepository.deleteById(id);
    }
}
