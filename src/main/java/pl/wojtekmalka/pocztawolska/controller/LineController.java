package pl.wojtekmalka.pocztawolska.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wojtekmalka.pocztawolska.entity.Ticket;
import pl.wojtekmalka.pocztawolska.message.ResponseMessage;
import pl.wojtekmalka.pocztawolska.service.LineServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/line")
public class LineController {
    private final LineServiceImpl lineService;

    @PostMapping("/addTicket")
    ResponseEntity<ResponseMessage> addTicket(@RequestBody Ticket ticket) {
        lineService.addTicket(ticket);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Ticket added"));
    }
}
