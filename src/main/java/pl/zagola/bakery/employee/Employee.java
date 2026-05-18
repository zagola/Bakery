package pl.zagola.bakery.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zagola.bakery.persondetails.PersonDetails;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    private PersonDetails personDetails;
    private Instant hireDate;

    @Override
    public String toString() {
        return "Employee{" +
                "details=" + personDetails +
                ", hireDate=" + hireDate +
                '}';
    }
}