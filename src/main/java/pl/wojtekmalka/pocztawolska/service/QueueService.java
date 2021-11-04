package pl.wojtekmalka.pocztawolska.service;

import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;

public interface QueueService {
    void addClientIntoQueue(ClientDTO clientDTO);
}
