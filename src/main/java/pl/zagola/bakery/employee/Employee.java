package pl.zagola.bakery.employee;

import pl.zagola.bakery.persondetails.PersonDetails;

import java.time.Instant;

public class Employee {
    private final PersonDetails personDetails;
    private final Instant hireDate;

    public Employee(PersonDetails details, Instant employmentDate) {
        this.personDetails = details;
        this.hireDate = employmentDate;
    }

    public Instant getHireDate() {
        return hireDate;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "details=" + personDetails +
                ", hireDate=" + hireDate +
                '}';
    }
}