package pl.wojtekmalka.pocztawolska.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Embeddable
public class Audit {
    private String createdOn;
    private String preMerge;

    @PrePersist
    void prePersist() {
        createdOn = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @PreUpdate
    void preUpdate() {
        preMerge = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
