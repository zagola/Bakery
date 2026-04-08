package pl.zagola.bakery;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    boolean addEmployee(PersonDetails personDetails, Instant hireDate);

    List<Employee> findAll();

    Optional<Employee> findByPersonId(Long personId);

    boolean updateEmployee(PersonDetails updatedPersonDetails, Instant newHireDate);

    boolean deleteEmployee(Long personId);
}