package tech.chillo.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.chillo.sa.entites.Client;


@Repository
public interface  ClientRepository  extends JpaRepository<Client,Long> {
    Client findByEmail(String email);
    Boolean existsByEmail(String email);
}
