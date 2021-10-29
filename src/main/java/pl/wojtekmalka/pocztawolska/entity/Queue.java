package pl.wojtekmalka.pocztawolska.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "QUEUES")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long queueId;

    @OneToMany
    private List<Client> queue;

    private Integer clientCode;

    private Integer oneClientServiceTime;

    @Embedded
    private Audit audit = new Audit();
}
