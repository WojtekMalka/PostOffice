package pl.wojtekmalka.pocztawolska.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojtekmalka.pocztawolska.entity.Ticket;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Override
    <S extends Ticket> S save(S entity);

    @Override
    Optional<Ticket> findById(Long aLong);
}
