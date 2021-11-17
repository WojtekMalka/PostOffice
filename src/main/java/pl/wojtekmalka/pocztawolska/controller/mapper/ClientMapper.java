package pl.wojtekmalka.pocztawolska.controller.mapper;

import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;
import pl.wojtekmalka.pocztawolska.entity.Client;
import pl.wojtekmalka.pocztawolska.service.ClientAuthorizationServiceImpl;

public class ClientMapper {
    public static Client mapToClient(ClientDTO clientDTO) {
        return Client.builder()
                .name(clientDTO.getName())
                .authCode(clientDTO.getAuthCode())
                .specialStatus(ClientAuthorizationServiceImpl.decodeAuthorizationCodeToString(clientDTO))
                .build();
    }
}