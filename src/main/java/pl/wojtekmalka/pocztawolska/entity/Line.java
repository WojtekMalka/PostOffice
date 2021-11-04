package pl.wojtekmalka.pocztawolska.entity;

import javax.persistence.*;

@Entity
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketNumber")
    private Ticket ticket;

    private Integer clientPlaceInLine;
}
