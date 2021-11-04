package pl.wojtekmalka.pocztawolska.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;
import pl.wojtekmalka.pocztawolska.message.ResponseMessage;
import pl.wojtekmalka.pocztawolska.service.ClientServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientServiceImpl clientService;

    @GetMapping("/getById/{id}")
    ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long clientId) {
        ClientDTO clientDTO = clientService.getClientById(clientId);
        return ResponseEntity.status(HttpStatus.OK).body(clientDTO);
    }

    @GetMapping("/getAll")
    ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> allClientsDTOs = clientService.getAllClients();
        return ResponseEntity.status(HttpStatus.OK).body(allClientsDTOs);
    }

    @PostMapping("/add")
    ResponseEntity<ResponseMessage> addClient(@RequestBody ClientDTO clientDTO) {
        clientService.saveClient(clientDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseMessage("Client" + clientDTO.getName() + " created"));
    }
}
