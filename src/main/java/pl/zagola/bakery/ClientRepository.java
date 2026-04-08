package pl.zagola.bakery;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    boolean addClient(PersonDetails personDetails, Address address);

    List<Client> findAll();

    Optional<Client> findByPersonId(Long personId);

    boolean updateClient(PersonDetails updatedPersonDetails, Address updatedAddress);

    boolean deleteClient(Long personId);

}