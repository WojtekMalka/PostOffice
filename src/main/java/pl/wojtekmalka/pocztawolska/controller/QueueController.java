package pl.wojtekmalka.pocztawolska.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wojtekmalka.pocztawolska.entity.Client;
import pl.wojtekmalka.pocztawolska.message.ResponseMessage;
import pl.wojtekmalka.pocztawolska.service.QueueServiceImpl;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class QueueController {
    private final QueueServiceImpl queueService;

    @GetMapping("/test")
    ResponseEntity<ResponseMessage> test() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Test"));
    }

    @PostMapping("/addClient")
    ResponseEntity<ResponseMessage> addClientIntoQueue(@RequestBody Client client) {
        queueService.addClientToQueue(1L, client);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Client added into the queue"));
    }

}
