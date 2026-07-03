package pl.zagola.bakery.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Long productId;
    private Long orderId;
    private String name;
    private double price;
    private String customization;
    private int stockQuantity;
}