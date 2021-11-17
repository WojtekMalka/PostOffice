package pl.wojtekmalka.pocztawolska.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wojtekmalka.pocztawolska.entity.Ticket;
import pl.wojtekmalka.pocztawolska.service.LineServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/line")
public class LineController {
    private final LineServiceImpl lineService;

    @GetMapping("/getLine")
    ResponseEntity<List<Ticket>> getTicketsInLine() {
        List<Ticket> ticketsInLine = lineService.getTicketsInLine();
        return ResponseEntity.status(HttpStatus.OK).body(ticketsInLine);
    }
}
