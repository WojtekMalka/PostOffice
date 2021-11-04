package pl.wojtekmalka.pocztawolska.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wojtekmalka.pocztawolska.entity.Line;
import pl.wojtekmalka.pocztawolska.entity.Ticket;
import pl.wojtekmalka.pocztawolska.repository.LineRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LineServiceImpl {
    private final LineRepository lineRepository;

    public Line getLine(Long lineId) {
        return lineRepository.findById(lineId)
                .orElseThrow(() -> new NoSuchElementException());
    }

    private void addTicket(Line line, Ticket ticket) {
        List<Ticket> lineToUpdate = line.getLine();
        lineToUpdate.add(findTicketPlaceInLine(ticket),ticket);

        Line.builder()
                .line(lineToUpdate)
                .build();
    }

    private Integer findTicketPlaceInLine(Ticket ticket){
        if (ticket.getClient().getSpecialStatus() != null) {

        }
        return 1;
    }

//    private void updateQueue() {
//        List<Ticket> ticket = ticketRepository.findAll().stream()
//                .sorted(Comparator.comparingInt(Ticket::getClientPlaceInLine))
//                .collect(Collectors.toList());
//    }
}
