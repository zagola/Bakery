package pl.zagola.bakery.orderitem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zagola.bakery.product.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    private Long orderItemId;
    private Product product;
    private int quantity;
    private double priceAtPurchase;
}