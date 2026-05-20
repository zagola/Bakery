package pl.zagola.bakery.hiredate.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "hire_date")
    private Instant hireDate;

}