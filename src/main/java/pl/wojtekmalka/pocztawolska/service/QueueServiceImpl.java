package pl.wojtekmalka.pocztawolska.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.wojtekmalka.pocztawolska.DTO.ClientDTO;
import pl.wojtekmalka.pocztawolska.entity.Client;
import pl.wojtekmalka.pocztawolska.entity.Queue;
import pl.wojtekmalka.pocztawolska.repository.QueueRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class QueueServiceImpl implements QueueService {
    private final QueueRepository queueRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public void addClientToQueue(Long queueId, Client client) {
        Queue queue = getQueue(queueId);
        queue.setClient(client);
        queueRepository.save(queue);
    }

    public List<ClientDTO> getClientDTOQueueList(Queue queue) {
        return null;
    }

    public Integer countActualServiceTime(List<Client> queue) {
        return null;
    }

    private ClientDTO mapClientToClientDTO(Client client) {
        ClientDTO clientDTO = modelMapper.map(client, ClientDTO.class);
        return clientDTO;
    }

    private Queue getQueue(Long queueId) {
        return queueRepository.findById(queueId)
                .orElseThrow(() -> new RuntimeException("Queue didn't found"));
    }
}
