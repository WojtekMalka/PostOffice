package pl.wojtekmalka.pocztawolska.controller.dto;

import lombok.Builder;
import lombok.Data;
import pl.wojtekmalka.pocztawolska.dictionary.ClientSpecialStatus;

@Builder
@Data
public class ClientDTO {
    private String name;
    private Integer authCode;
    private ClientSpecialStatus specialStatus;
}

