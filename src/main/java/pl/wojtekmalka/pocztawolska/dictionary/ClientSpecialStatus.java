package pl.wojtekmalka.pocztawolska.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientSpecialStatus {
    VIP("VIP", 8888),
    URGENT("URGENT", 0000);

    private String status;
    private Integer statusAuthCode;
}
