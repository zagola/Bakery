package pl.zagola.bakery.bakery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zagola.bakery.address.Address;
import pl.zagola.bakery.employee.Employee;
import pl.zagola.bakery.order.Order;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bakery {
    private String name;
    private Address address;
    private Employee owner;
    private List<Employee> employees = new ArrayList<>();
    private List<Order> orderHistory = new ArrayList<>();
    private double pathStrategy;

    public Bakery(String name, Address address, Employee owner) {
        this.name = name;
        this.address = address;
        this.owner = owner;
    }
}