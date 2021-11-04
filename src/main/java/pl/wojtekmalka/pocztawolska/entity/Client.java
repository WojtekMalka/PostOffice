package pl.wojtekmalka.pocztawolska.entity;

import lombok.*;
import pl.wojtekmalka.pocztawolska.dictionary.ClientStatus;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String name;

    private Integer clientCode;

    private ClientStatus clientStatus;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Queue queue;

    @Embedded
    private Audit audit = new Audit();
}
