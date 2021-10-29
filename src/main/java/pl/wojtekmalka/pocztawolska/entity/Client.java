package pl.wojtekmalka.pocztawolska.entity;

import lombok.Data;
import pl.wojtekmalka.pocztawolska.dictionary.ClientStatus;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CLIENTS")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String name;

    private Integer clientCode;

    private ClientStatus clientStatus;

    @Embedded
    private Audit audit = new Audit();
}
