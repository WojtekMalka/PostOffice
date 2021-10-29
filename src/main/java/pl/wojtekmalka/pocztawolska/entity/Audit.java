package pl.wojtekmalka.pocztawolska.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Embeddable
@Data
public class Audit {
    private String createdOn;
    private String preMerge;

    @PrePersist
    void prePersist() {
        createdOn = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @PreUpdate
    void preUpdate() {
        preMerge = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
