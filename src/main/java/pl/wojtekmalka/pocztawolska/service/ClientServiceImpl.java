package pl.wojtekmalka.pocztawolska.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;
import pl.wojtekmalka.pocztawolska.controller.mapper.ClientDTOMapper;
import pl.wojtekmalka.pocztawolska.controller.mapper.ClientMapper;
import pl.wojtekmalka.pocztawolska.entity.Client;
import pl.wojtekmalka.pocztawolska.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public void saveClient(ClientDTO clientDTO) {
        Client client = ClientMapper.mapToClient(clientDTO);
        clientRepository.save(client);
    }

    @Override
    public ClientDTO getClientById(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException());
        return ClientDTOMapper.mapToClientDTO(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(client -> ClientDTO.builder()
                        .name(client.getName())
                        .authCode(client.getAuthCode())
                        .specialStatus(client.getSpecialStatus())
                        .build())
                .collect(Collectors.toList());

    }
}
