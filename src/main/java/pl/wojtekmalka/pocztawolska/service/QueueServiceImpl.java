package pl.wojtekmalka.pocztawolska.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;
import pl.wojtekmalka.pocztawolska.controller.mapper.ClientMapper;
import pl.wojtekmalka.pocztawolska.entity.Client;
import pl.wojtekmalka.pocztawolska.entity.Queue;
import pl.wojtekmalka.pocztawolska.repository.QueueRepository;

@RequiredArgsConstructor
@Service
public class QueueServiceImpl implements QueueService {
    private final QueueRepository queueRepository;

    @Override
    public void addClientIntoQueue(ClientDTO clientDTO) {
        Queue queue = queueRepository.findById(1L).orElseThrow();
        Client client = ClientMapper.mapToClient(clientDTO);
        queue.setClient(client);
    }
}
