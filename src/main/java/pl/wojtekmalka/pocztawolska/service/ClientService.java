package pl.wojtekmalka.pocztawolska.service;

import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;
import pl.wojtekmalka.pocztawolska.entity.Client;

import java.util.List;

public interface ClientService {
    void saveClient(ClientDTO clientDTO);

    ClientDTO getClientById(Long clientId);

    List<ClientDTO> getAllClients();
}
