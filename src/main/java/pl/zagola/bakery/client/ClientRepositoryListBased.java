package pl.zagola.bakery.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.zagola.bakery.persondetails.PersonDetails;
import pl.zagola.bakery.address.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Repository
public class ClientRepositoryListBased implements ClientRepository {

    private List<Client> clientList = new ArrayList<>();

    @Override
    public boolean addClient(PersonDetails personDetails, Address address) {
        if (personDetails == null || address == null) {
            return false;
        }
        ;

        boolean exists = clientList.stream()
                .anyMatch(c -> c.getPersonDetails().getId()
                        .equals(personDetails.getId()));
        if (exists) {
            return false;
        }

        clientList.add(new Client(personDetails, address));
        return true;
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clientList);
    }

    @Override
    public Optional<Client> findByPersonId(Long personId) {
        if (personId == null) {
            return Optional.empty();
        }

        return clientList.stream()
                .filter(c -> c.getPersonDetails().getId().equals(personId))
                .findFirst();
    }

    @Override
    public boolean updateClient(PersonDetails updatedPersonDetails, Address updatedAddress) {
        if (updatedPersonDetails == null || updatedAddress == null) {
            return false;
        }

        boolean found = clientList.stream()
                .anyMatch(c -> c.getPersonDetails().getId().equals(updatedPersonDetails.getId()));

        if (found) {
            clientList.removeIf(c -> c.getPersonDetails().getId().equals(updatedPersonDetails.getId()));
            clientList.add(new Client(updatedPersonDetails, updatedAddress));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteClient(Long personId) {
        if (personId == null) {
            return false;
        }
        return clientList.removeIf(c -> c.getPersonDetails().getId().equals(personId));
    }
}