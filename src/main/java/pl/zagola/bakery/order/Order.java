package pl.zagola.bakery.order;

import pl.zagola.bakery.bakeryproduct.BakeryProduct;
import pl.zagola.bakery.client.Client;

import java.time.Instant;
import java.util.List;

public class Order {
    private Client client;
    private List<BakeryProduct> products;
    private double totalPrice;
    private Instant orderDate;


    public Order(Client client, List<BakeryProduct> products, double orderPrice, Instant date) {
        this.client = client;
        this.products = products;
        this.totalPrice = orderPrice;
        this.orderDate = date;
    }
}