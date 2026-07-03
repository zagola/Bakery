package pl.zagola.bakery.product.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.zagola.bakery.orderitem.entities.OrderItemEntity;

import java.util.Set;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "customization")
    private String customization;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @OneToMany(mappedBy = "product")
    private Set<OrderItemEntity> orderItems;
}