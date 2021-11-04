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
import pl.wojtekmalka.pocztawolska.service.ClientServiceImpl;
import pl.wojtekmalka.pocztawolska.service.QueueServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/queue")
public class QueueController {
    private final QueueServiceImpl queueService;
    private final ClientServiceImpl clientService;

    @PostMapping("/addClient")
    ResponseEntity<ResponseMessage> addClientIntoQueue(@RequestBody ClientDTO clientDTO) {
        queueService.addClientIntoQueue(clientDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Client added into the queue"));
    }
}

