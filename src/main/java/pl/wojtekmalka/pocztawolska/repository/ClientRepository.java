package pl.wojtekmalka.pocztawolska.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojtekmalka.pocztawolska.entity.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Override
    List<Client> findAll();
}
