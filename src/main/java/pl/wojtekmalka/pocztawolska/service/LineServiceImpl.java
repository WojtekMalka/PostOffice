package pl.wojtekmalka.pocztawolska.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wojtekmalka.pocztawolska.dictionary.ClientSpecialStatus;
import pl.wojtekmalka.pocztawolska.entity.Line;
import pl.wojtekmalka.pocztawolska.entity.Ticket;
import pl.wojtekmalka.pocztawolska.repository.LineRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LineServiceImpl {
    public static final long LINE_ID = 1L;
    private final LineRepository lineRepository;

    public Line getLine(Long lineId) {
        return lineRepository.findById(lineId)
                .orElseThrow(() -> new NoSuchElementException());
    }

    public void addTicket(Ticket ticket) {
        Line line = getLine(LINE_ID);
        line.setLine(findTicketPlaceInLine(line.getLine(), ticket));
        lineRepository.save(line);
    }

    private List<Ticket> findTicketPlaceInLine(List<Ticket> line, Ticket ticket) {
        checkStatusVIP(line, ticket);
        checkStatusURGENT(line, ticket);
        return line;
    }

    private void checkStatusURGENT(List<Ticket> line, Ticket ticket) {
        if (ticket.getClient().getSpecialStatus().equals(ClientSpecialStatus.URGENT)
                && ticket.getClient().getAuthCode().equals(ClientSpecialStatus.URGENT.getStatusAuthCode())) {
            line.add(0, ticket);
        }
    }

    private void checkStatusVIP(List<Ticket> line, Ticket ticket) {
        if (ticket.getClient().getSpecialStatus().equals(ClientSpecialStatus.VIP)
                && ticket.getClient().getAuthCode().equals(ClientSpecialStatus.VIP)) {
            List<Ticket> tempLine = line.stream()
                    .filter(s -> ClientSpecialStatus.VIP.equals(s.getClient().getSpecialStatus()))
                    .sorted((o1, o2) -> o1.getAudit().getCreatedOn().compareTo(o2.getAudit().getCreatedOn()))
                    .collect(Collectors.toList());
            line.addAll(0, line);
        }
    }
}
