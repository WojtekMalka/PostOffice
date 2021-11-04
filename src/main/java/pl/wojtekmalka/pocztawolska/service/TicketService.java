package pl.wojtekmalka.pocztawolska.service;

import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;

public interface TicketService {
    void createTicket(ClientDTO clientDTO);
}
