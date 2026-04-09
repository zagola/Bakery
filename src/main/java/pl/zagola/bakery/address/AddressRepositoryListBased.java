package pl.zagola.bakery.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Repository
public class AddressRepositoryListBased implements AddressRepository {
    private List<Address> addressList = new ArrayList<>();

    @Override
    public boolean addAddress(Long personId, double latitude, double longitude) {
        if (personId == null) {
            return false;
        }
        //checks for duplicates - add address only if it doesn't exist, update only if exists
        boolean exists = addressList.stream()
                .anyMatch(a -> a.getPersonId().equals(personId));

        if (exists) {
            return false;
        }

        return addressList.add(new Address(personId, latitude, longitude));
    }

    @Override
    public List<Address> findAll() {
        return new ArrayList<>(addressList);
    }

    @Override
    public List<Address> findByPersonId(Long personId) {
        if (personId == null) {
            return List.of();
        }

        return addressList.stream()
                .filter(a -> a.getPersonId().equals(personId))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateAddress(Long personId, double latitude, double longitude) {
        if (personId == null) {
            return false;
        }

        boolean found = addressList.stream()
                .anyMatch(a -> a.getPersonId().equals(personId));

        if (found) {
            addressList.removeIf(a -> a.getPersonId().equals(personId));
            addressList.add(new Address(personId, latitude, longitude));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAddress(Long personId) {
        if (personId == null) {
            return false;
        }
        return addressList.removeIf(a -> a.getPersonId().equals(personId));
    }
}