package pl.wojtekmalka.pocztawolska.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojtekmalka.pocztawolska.entity.Queue;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {
}
