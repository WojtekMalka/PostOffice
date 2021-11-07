package pl.wojtekmalka.pocztawolska.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDTO {
    private String name;
    private Integer authCode;
    private String specialStatus;
}

