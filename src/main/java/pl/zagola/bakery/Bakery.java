package pl.zagola.bakery;

import java.util.List;
import java.util.Map;

public class Bakery {
    private String name;
    private GeographicAddress address;
    private Employee owner;
    private Map<String, Double> clients;
    private List<Employee> employees;
    private Map<String, BakeryProduct> products;
    private List<Order> orderHistory;
    private double pathStrategy; //separate class to calculating the shortest path?


    public Bakery(String name, GeographicAddress address, Employee owner) {
        this.name = name;
        this.address = address;
        this.owner = owner;
    }
}