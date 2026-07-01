package pl.zagola.bakery.client.entities;

import jakarta.persistence.*;
import lombok.*;
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

    //@Column(name = "person_id")
    @OneToOne(mappedBy = "personId")
    private PersonDetailsEntity personId;

    @Column(name = "address_id")
    private Long  addressId;
}