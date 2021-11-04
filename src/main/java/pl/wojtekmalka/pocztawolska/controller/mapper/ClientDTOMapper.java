package pl.wojtekmalka.pocztawolska.controller.mapper;

import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;
import pl.wojtekmalka.pocztawolska.entity.Client;

public class ClientDTOMapper {
    public static ClientDTO mapToClientDTO(Client client) {
    return ClientDTO.builder()
            .name(client.getName())
            .authCode(client.getAuthCode())
            .build();
    }
}
