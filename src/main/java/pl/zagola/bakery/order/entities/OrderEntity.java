package pl.zagola.bakery.order.entities;

import jakarta.persistence.*;
import lombok.*;
import pl.zagola.bakery.client.entities.ClientEntity;
import pl.zagola.bakery.orderitem.entities.OrderItemEntity;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "order_date")
    private Instant orderDate;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<OrderItemEntity> orderItems;

}