package pl.zagola.bakery.client.entities;

import jakarta.persistence.*;
import lombok.*;
import pl.zagola.bakery.address.entities.AddressEntity;
import pl.zagola.bakery.persondetails.entities.PersonDetailsEntity;

@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonDetailsEntity person;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;
}