package pl.zagola.bakery.role.entities;

import jakarta.persistence.*;
import lombok.*;
import pl.zagola.bakery.persondetails.entities.PersonDetailsEntity;

import java.util.Set;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<PersonDetailsEntity> persons;
}