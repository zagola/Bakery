package pl.zagola.bakery.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zagola.bakery.order.entities.OrderEntity;

import java.time.Instant;
import java.util.List;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByClient_ClientId(Long clientId);
    List<OrderEntity> findByOrderDateBetween(Instant from, Instant to);
}