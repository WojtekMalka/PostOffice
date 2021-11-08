package pl.wojtekmalka.pocztawolska.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;
import pl.wojtekmalka.pocztawolska.message.ResponseMessage;
import pl.wojtekmalka.pocztawolska.service.LineServiceImpl;
import pl.wojtekmalka.pocztawolska.service.TicketServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {
    private final TicketServiceImpl ticketService;

    @PostMapping("/addTicket")
    ResponseEntity<ResponseMessage> addTicket(@RequestBody ClientDTO clientDTO) {
        ticketService.createTicket(clientDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Ticket was created"));
    }
}

