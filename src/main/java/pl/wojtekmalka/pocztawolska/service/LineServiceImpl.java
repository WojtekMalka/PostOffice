package pl.wojtekmalka.pocztawolska.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wojtekmalka.pocztawolska.dictionary.ClientStatus;
import pl.wojtekmalka.pocztawolska.entity.Ticket;
import pl.wojtekmalka.pocztawolska.repository.TicketRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LineServiceImpl {
    private final TicketRepository ticketRepository;

    public List<Ticket> getTicketsInLine() {
        return createLine(ticketRepository.findAll());
    }

    private List<Ticket> createLine(List<Ticket> line) {
//        line.addAll(sortLineByClientStatus(line, ClientStatus.STANDARD));
        line.addAll(0, sortLineByClientStatus(line, ClientStatus.VIP));
        line.addAll(0, sortLineByClientStatus(line, ClientStatus.URGENT));
        return line;
    }

    public List<Ticket> sortLineByClientStatus(List<Ticket> line, ClientStatus clientStatus) {
        return line.stream()
                .filter(s -> s.getClient().getSpecialStatus().equals(clientStatus))
//                .sorted(Comparator.comparing(o -> o.getAudit().getCreatedOn()))
                .collect(Collectors.toList());
    }
}

