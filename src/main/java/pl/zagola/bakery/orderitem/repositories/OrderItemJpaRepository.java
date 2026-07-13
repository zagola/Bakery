package pl.zagola.bakery.orderitem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zagola.bakery.orderitem.entities.OrderItemEntity;

import java.util.List;

@Repository
public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, Long> {
    List<OrderItemEntity> findByOrder_OrderId(Long orderId);
    List<OrderItemEntity> findByProduct_ProductId(Long productId);
}