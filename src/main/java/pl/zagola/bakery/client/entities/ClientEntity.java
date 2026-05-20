package pl.zagola.bakery.client.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "address_id")
    private Long  addressId;
}