package pl.zagola.bakery.persondetails.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.zagola.bakery.address.entities.AddressEntity;
import pl.zagola.bakery.client.entities.ClientEntity;
import pl.zagola.bakery.employee.entities.EmployeeEntity;
import pl.zagola.bakery.hiredate.entities.HireDateEntity;
import pl.zagola.bakery.role.entities.RoleEntity;

import java.util.Set;

@Entity
@Table(name = "person_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // 1 person -> many addresses
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AddressEntity> addresses;

    // 1 person -> 1 hire date
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private HireDateEntity hireDate;

    // M:N person <-> role
    @ManyToMany
    @JoinTable(
            name = "person_role",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles;

    // 1:1 person -> client
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private ClientEntity client;

    // 1:1 person -> employee
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private EmployeeEntity employee;
}