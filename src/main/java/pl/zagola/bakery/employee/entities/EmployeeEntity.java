package pl.zagola.bakery.employee.entities;

import jakarta.persistence.*;
import lombok.*;
import pl.zagola.bakery.bakery.entities.BakeryEntity;
import pl.zagola.bakery.hiredate.entities.HireDateEntity;
import pl.zagola.bakery.persondetails.entities.PersonDetailsEntity;

import java.util.Set;

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

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonDetailsEntity person;

    @OneToOne
    @JoinColumn(name = "hire_date_id")
    private HireDateEntity hireDate;

    @ManyToMany(mappedBy = "employees")
    private Set<BakeryEntity> bakeries;
}