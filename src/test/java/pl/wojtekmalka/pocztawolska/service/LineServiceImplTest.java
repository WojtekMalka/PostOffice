package pl.wojtekmalka.pocztawolska.service;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.wojtekmalka.pocztawolska.dictionary.ClientStatus;
import pl.wojtekmalka.pocztawolska.entity.Audit;
import pl.wojtekmalka.pocztawolska.entity.Client;
import pl.wojtekmalka.pocztawolska.entity.Ticket;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@SpringBootTest
public class LineServiceImplTest {
    private final static String createTimeSimulationWithoutSeconds = "2007-12-03T10:15:";

    @Autowired
    private LineServiceImpl lineService;

    @Disabled
    @Test
    void sortLineByClientStatus() {
        //given
        List<Ticket> line = new LinkedList<>();
        line.add(createLine("03", ClientStatus.STANDARD));
        line.add(createLine("02", ClientStatus.STANDARD));
        line.add(createLine("01", ClientStatus.STANDARD));

        List<Ticket> excpectedLine = new LinkedList<>();
        excpectedLine.add(createLine("01", ClientStatus.STANDARD));
        excpectedLine.add(createLine("02", ClientStatus.STANDARD));
        excpectedLine.add(createLine("03", ClientStatus.STANDARD));

        //when
        lineService.sortLineByClientStatus(line, ClientStatus.STANDARD);

        //then
        assertIterableEquals(excpectedLine, line);
    }

    @Test
    void sortLineByClientStatus1() {
        //given
        List<Ticket> line = new LinkedList<>();
        line.add(createLine("03", ClientStatus.URGENT));
        line.add(createLine("02", ClientStatus.STANDARD));
        line.add(createLine("01", ClientStatus.STANDARD));

        List<Ticket> excpectedLine = new LinkedList<>();
        excpectedLine.add(createLine("01", ClientStatus.STANDARD));
        excpectedLine.add(createLine("02", ClientStatus.STANDARD));

        //when
        List<Ticket> ticketList = lineService.sortLineByClientStatus(line, ClientStatus.URGENT);

        //then
        assertIterableEquals(excpectedLine, ticketList);
    }

    private Ticket createLine(String seconds, ClientStatus clientStatus) {
        return Ticket.builder()
                .client(Client.builder()
                        .specialStatus(clientStatus.getStatus())
                        .build())
                .audit(Audit.builder()
                        .createdOn(LocalDateTime.parse(createTimeSimulationWithoutSeconds + seconds))
                        .build())
                .build();
    }
}
