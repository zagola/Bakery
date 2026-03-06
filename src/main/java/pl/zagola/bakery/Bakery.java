package pl.zagola.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private GeographicAddress address;
    private Employee owner;
    private List<Employee> employees = new ArrayList<>();
    private List<Order> orderHistory = new ArrayList<>();
    private double pathStrategy; //separate class to calculating the shortest path?


    public Bakery(String name, GeographicAddress address, Employee owner) {
        this.name = name;
        this.address = address;
        this.owner = owner;
    }

}