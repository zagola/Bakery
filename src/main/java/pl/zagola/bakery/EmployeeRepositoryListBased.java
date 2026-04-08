package pl.zagola.bakery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Repository
public class EmployeeRepositoryListBased implements EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public boolean addEmployee(PersonDetails personDetails, Instant hireDate) {
        if (personDetails == null || hireDate == null) {
            return false;
        }

        boolean exists = employeeList.stream()
                .anyMatch(e -> e.getPersonDetails().getPersonId()
                        .equals(personDetails.getPersonId()));

        if (exists) {
            return false;
        }

        employeeList.add(new Employee(personDetails, hireDate));
        return true;
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeList);
    }

    @Override
    public Optional<Employee> findByPersonId(Long personId) {  //Optional -> 0 || 1 employee/personId
        if (personId == null) {
            return Optional.empty();
        }

        return employeeList.stream()
                .filter(e -> e.getPersonDetails().getPersonId().equals(personId))
                .findFirst();
    }

    @Override
    public boolean updateEmployee(PersonDetails updatedPersonDetails, Instant newHireDate) {
        if (updatedPersonDetails == null || newHireDate == null) {
            return false;
        }

        boolean found = employeeList.stream()
                .anyMatch(e -> e.getPersonDetails().getPersonId().equals(updatedPersonDetails.getPersonId()));

        if (found) {
            employeeList.removeIf(e -> e.getPersonDetails().getPersonId().equals(updatedPersonDetails.getPersonId()));
            employeeList.add(new Employee(updatedPersonDetails, newHireDate));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(Long personId) {
        if (personId == null) {
            return false;
        }

        return employeeList.removeIf(e -> e.getPersonDetails().getPersonId().equals(personId));
    }
}