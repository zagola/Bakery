package pl.zagola.bakery;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private Client client;
    private List<BakeryProduct> products;
    private double totalPrice;
    private LocalDate orderDate;


    public Order(Client client, List<BakeryProduct> products, double orderPrice, LocalDate date) {
        this.client = client;
        this.products = products;
        this.totalPrice = orderPrice;
        this.orderDate = date;
    }
}