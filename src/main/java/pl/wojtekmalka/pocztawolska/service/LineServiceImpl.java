package pl.wojtekmalka.pocztawolska.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wojtekmalka.pocztawolska.dictionary.ClientStatus;
import pl.wojtekmalka.pocztawolska.entity.Line;
import pl.wojtekmalka.pocztawolska.entity.Ticket;
import pl.wojtekmalka.pocztawolska.repository.LineRepository;
import pl.wojtekmalka.pocztawolska.repository.TicketRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LineServiceImpl {
    private final LineRepository lineRepository;
    private final TicketRepository ticketRepository;

    public void addTicketToLine(Ticket ticket) {
        Line ticketInLine = Line.builder()
                .ticket(ticket)
                .build();
//        lineRepository.save(ticketInLine);
        List<Line> ticketPlaceInLine = findTicketPlaceInLine(ticket);
//        lineRepository.deleteAll();
        lineRepository.saveAll(ticketPlaceInLine);
    }

    public List<Line> getLine() {
        return lineRepository.findAll();
    }

    private List<Line> findTicketPlaceInLine(Ticket ticket) {
        List<Line> line = getLine();
        checkStatusVIP(line, ticket);
        checkStatusURGENT(line, ticket);
        return line;
    }

    private void checkStatusURGENT(List<Line> line, Ticket ticket) {
        Line ticketInLine = Line.builder()
                .ticket(ticket)
                .build();

        if (isSpecialStatus(ClientStatus.URGENT, ticket)) {
            line.add(0, ticketInLine);
        } else {
            line.add(ticketInLine);
        }
    }

    private void checkStatusVIP(List<Line> line, Ticket ticket) {
        Line ticketInLine = Line.builder()
                .ticket(ticket)
                .build();

        if (isSpecialStatus(ClientStatus.VIP, ticket)) {
            List<Line> tempLine = line.stream()
                    .filter(s -> ClientStatus.VIP.equals(s.getTicket().getClient().getSpecialStatus()))
                    .sorted((o1, o2) -> o1.getTicket().getAudit().getCreatedOn().compareTo(o2.getTicket().getAudit().getCreatedOn()))
                    .collect(Collectors.toList());
            line.addAll(0, line);
        } else {
            line.add(ticketInLine);
        }
    }

    private boolean isSpecialStatus(ClientStatus statusName, Ticket ticket) {
        return statusName.equals(ticket.getClient().getSpecialStatus()) ? true : false;
    }
}
