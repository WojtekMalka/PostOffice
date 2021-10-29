package pl.wojtekmalka.pocztawolska.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long queueId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Client client;

    @Embedded
    private Audit audit = new Audit();
}
