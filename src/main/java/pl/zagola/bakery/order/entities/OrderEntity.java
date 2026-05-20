package pl.zagola.bakery.order.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

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

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "order_date")
    private Instant orderDate;
}