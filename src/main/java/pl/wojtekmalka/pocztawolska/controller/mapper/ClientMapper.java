package pl.wojtekmalka.pocztawolska.controller.mapper;

import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;
import pl.wojtekmalka.pocztawolska.entity.Client;

public class ClientMapper {
    public static Client mapToClient(ClientDTO clientDTO) {
        return Client.builder()
                .name(clientDTO.getName())
                .authCode(clientDTO.getAuthCode())
                .build();
    }
}