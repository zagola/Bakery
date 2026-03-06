package pl.zagola.bakery;

import java.time.Instant;

class Employee {
    private PersonDetails details;
    private Instant hireDate;


    protected Employee(PersonDetails details, Instant employmentDate) {
        this.details = details;
        this.hireDate = employmentDate;
    }

    public Instant getHireDate() {
        return hireDate;
    }

    public PersonDetails getDetails() {
        return details;
    }
}