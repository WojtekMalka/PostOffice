package pl.wojtekmalka.pocztawolska.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojtekmalka.pocztawolska.entity.Client;

@Repository
interface ClientRepository extends JpaRepository<Client, Long> {
}
