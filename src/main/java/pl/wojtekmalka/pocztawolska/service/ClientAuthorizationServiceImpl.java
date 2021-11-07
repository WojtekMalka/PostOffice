package pl.wojtekmalka.pocztawolska.service;

import org.springframework.stereotype.Service;
import pl.wojtekmalka.pocztawolska.controller.dto.ClientDTO;
import pl.wojtekmalka.pocztawolska.dictionary.ClientSpecialStatus;

@Service
public class ClientAuthorizationServiceImpl {

    public static final String STANDARD_STATUS = "standard";

    public static String decodeAuthorizationCodeToString(ClientDTO clientDTO) {
        String result = "";
        for (ClientSpecialStatus value : ClientSpecialStatus.values()) {
            if (value.getStatusAuthCode().equals(clientDTO.getAuthCode())) {
                result = value.getStatus();
            } else {
                result = STANDARD_STATUS;
            }
        }
        return result;
    }
}
