package pl.zagola.bakery.legacy.client;

import pl.zagola.bakery.client.Client;
import pl.zagola.bakery.persondetails.PersonDetails;
import pl.zagola.bakery.address.Address;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    boolean addClient(PersonDetails personDetails, Address address);

    List<Client> findAll();

    Optional<Client> findByPersonId(Long personId);

    boolean updateClient(PersonDetails updatedPersonDetails, Address updatedAddress);

    boolean deleteClient(Long personId);

}