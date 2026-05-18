package pl.zagola.bakery.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zagola.bakery.bakeryproduct.BakeryProduct;
import pl.zagola.bakery.client.Client;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private Client client;
    private List<BakeryProduct> products;
    private double totalPrice;
    private Instant orderDate;

}