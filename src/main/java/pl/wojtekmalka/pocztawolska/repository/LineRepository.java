package pl.wojtekmalka.pocztawolska.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojtekmalka.pocztawolska.entity.Line;

@Repository
public interface LineRepository extends JpaRepository<Line, Long> {
}
