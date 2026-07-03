package pl.zagola.bakery.bakery.entities;

import jakarta.persistence.*;
import lombok.*;
import pl.zagola.bakery.address.entities.AddressEntity;
import pl.zagola.bakery.employee.entities.EmployeeEntity;

import java.util.Set;

@Entity
@Table(name = "bakery")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BakeryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bakery_id")
    private Long bakeryId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private EmployeeEntity owner;

    @ManyToMany
    @JoinTable(
            name = "bakery_employees",
            joinColumns = @JoinColumn(name = "bakery_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<EmployeeEntity> employees;
}