package pl.wojtekmalka.pocztawolska.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.wojtekmalka.pocztawolska.DTO.ClientDTO;
import pl.wojtekmalka.pocztawolska.entity.Client;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueueServiceImpl implements QueueService {
    private final ModelMapper modelMapper = new ModelMapper();

    private List<Client> queue;

    public void addClientToQueue(Client client) {
        queue.add(client);
    }

    public List<ClientDTO> getClientDTOQueueList() {
       return queue.stream()
                .map(this::mapClientToClientDTO)
                .collect(Collectors.toList());
    }

    private Integer countActualServiceTime(List<Client> queue) {
        return null;
    }

    private ClientDTO mapClientToClientDTO(Client client) {
        ClientDTO clientDTO = modelMapper.map(client, ClientDTO.class);
        return clientDTO;
    }
}
