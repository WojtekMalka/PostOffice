package pl.wojtekmalka.pocztawolska.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;
import pl.wojtekmalka.pocztawolska.controller.mapper.ClientMapper;
import pl.wojtekmalka.pocztawolska.entity.Audit;
import pl.wojtekmalka.pocztawolska.entity.Ticket;
import pl.wojtekmalka.pocztawolska.repository.TicketRepository;

@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final LineServiceImpl lineService;


    @Override
    public void createTicket(ClientDTO clientDTO) {
        Ticket ticket = Ticket.builder()
                .client(ClientMapper.mapToClient(clientDTO))
                .audit(new Audit())
                .build();
        ticketRepository.save(ticket);
        lineService.addTicketToLine(ticket);
    }
}
