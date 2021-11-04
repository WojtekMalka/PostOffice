package pl.wojtekmalka.pocztawolska.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wojtekmalka.pocztawolska.dictionary.ClientSpecialStatus;
import pl.wojtekmalka.pocztawolska.entity.Client;
import pl.wojtekmalka.pocztawolska.entity.Line;
import pl.wojtekmalka.pocztawolska.entity.Ticket;
import pl.wojtekmalka.pocztawolska.repository.LineRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LineServiceImpl {
    private final LineRepository lineRepository;

    public List<Line> getAllLine() {
        return lineRepository.findAll();
    }

    public void addTicketIntoLine(Ticket ticket) {
        ClientSpecialStatus specialStatus = ticket.getClient().getSpecialStatus();
        Arrays.stream(Arrays.stream(ClientSpecialStatus.values())
                .filter(s -> s.getStatus().equals(specialStatus))
                .findFirst();

    }


//    private void updateQueue() {
//        List<Ticket> ticket = ticketRepository.findAll().stream()
//                .sorted(Comparator.comparingInt(Ticket::getClientPlaceInLine))
//                .collect(Collectors.toList());
//    }
}
