package pl.wojtekmalka.pocztawolska.service;

import org.springframework.stereotype.Service;
import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;
import pl.wojtekmalka.pocztawolska.dictionary.ClientStatus;

@Service
public class ClientAuthorizationServiceImpl {
    public static String decodeAuthorizationCodeToString(ClientDTO clientDTO) {
        String result = ClientStatus.STANDARD.getStatus();
        for (ClientStatus value : ClientStatus.values()) {
            if (value.getStatusAuthCode().equals(clientDTO.getAuthCode())) {
                result = value.getStatus();
            }
        }
        return result;
    }
}
