package pl.zagola.bakery.client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zagola.bakery.client.entities.ClientEntity;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {
}