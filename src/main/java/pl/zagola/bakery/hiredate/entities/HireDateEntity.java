package pl.zagola.bakery.hiredate.entities;

import jakarta.persistence.*;
import lombok.*;
import pl.zagola.bakery.persondetails.entities.PersonDetailsEntity;

import java.time.Instant;

@Entity
@Table(name = "hire_date")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HireDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hire_date_id")
    private Long hireDateId;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonDetailsEntity person;

    @Column(name = "hire_date")
    private Instant hireDate;
}