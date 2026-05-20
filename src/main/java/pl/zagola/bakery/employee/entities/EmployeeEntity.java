package pl.zagola.bakery.employee.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "hire_date_id")
    private Long hireDateId;
}