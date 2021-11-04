package pl.wojtekmalka.pocztawolska.service;

import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;

public interface ClientService {
    void saveClient(ClientDTO clientDTO);

    ClientDTO getClient(Long clientId);
}
