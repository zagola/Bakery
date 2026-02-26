package pl.zagola.bakery;

import java.time.LocalDate;

public class Employee extends Person{
    private LocalDate employmentDate;


    protected Employee(String firstName, String lastName, GeographicAddress address, LocalDate employmentDate) {
        super(firstName, lastName);
        this.employmentDate = employmentDate;
    }
}