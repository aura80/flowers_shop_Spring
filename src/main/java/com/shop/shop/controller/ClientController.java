package com.shop.shop.controller;

import com.shop.shop.dto.ClientDto;
import com.shop.shop.model.Client;
import com.shop.shop.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/createClient")
    public ResponseEntity<ClientDto> saveClient(@RequestBody @Valid ClientDto clientDto) {
        ClientDto savedUser = clientService.saveClient(clientDto);

        return ResponseEntity.status(OK)
                .header("Message", "Client has been created successfully")
                .body(savedUser);
    }

    @PostMapping("/saveAllClients")
    public ResponseEntity<Void> saveAllClients(@RequestBody List<Client> clients) {

         clientService.saveAllClients(clients);

        return ResponseEntity.noContent()
                .header("Message", "All clients added successfully")
                .build();
    }

    @GetMapping("/getAllClients")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        List<ClientDto> allUsersList = clientService.getAllClients();

        return ResponseEntity.ok(allUsersList);
    }

    @GetMapping("/getClientById/{client_id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable("client_id") Long clientId) {
        ClientDto userDtoById = clientService.getClientById(clientId);

        return new ResponseEntity<>(userDtoById, OK);
    }

    @PutMapping("/updateClientById/{client_id}")
    public ResponseEntity<ClientDto> updateClientById(@PathVariable("client_id") Long clientId,
                                                      @RequestBody ClientDto clientDto) {
        ClientDto updatedUser = clientService.updateClientById(clientDto, clientId);

        return ResponseEntity.status(OK)
                .header("Message", "Client updated successfully")
                .body(updatedUser);
    }

    @DeleteMapping("/deleteClientById/{client_id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable("client_id") Long clientId) {
        clientService.deleteClientById(clientId);

        return ResponseEntity.noContent()
                .header("Message", "Client deleted successfully")
                .build();
    }

    @GetMapping("/getClientByName/{name}")
    public ResponseEntity<ClientDto> getClientByName(@PathVariable("name") String clientName) {
        ClientDto clientByName = clientService.getClientByName(clientName);

        return new ResponseEntity<>(clientByName, OK);
    }

    @GetMapping("/getClientByEmail/{email}")
    public ResponseEntity<ClientDto> findClientByEmail(@PathVariable("email") String clientEmail) {
        ClientDto clientByEmail = clientService.findClientByEmail(clientEmail);

        return new ResponseEntity<>(clientByEmail, OK);
    }

    @GetMapping("/getClientByNameAndPhone")
    public ResponseEntity<ClientDto> getClientByNameAndPhone(@RequestParam String clientName,
                                                             @RequestParam String clientPhone) {
        ClientDto clientByNameAndPhone = clientService.getClientByNameAndPhone(clientName, clientPhone);

        return new ResponseEntity<>(clientByNameAndPhone, OK);
    }

    @GetMapping("/getClientByEmailAndPassword")
    public ResponseEntity<ClientDto> getClientByEmailAndPassword(@RequestParam String clientEmail,
                                                                 @RequestParam String clientPassword) {
        ClientDto clientByEmailAndPassword = clientService.getClientByEmailAndPassword(clientEmail, clientPassword);

        return new ResponseEntity<>(clientByEmailAndPassword, OK);
    }
}
