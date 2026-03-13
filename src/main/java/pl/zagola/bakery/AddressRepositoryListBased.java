package pl.zagola.bakery;

import java.util.ArrayList;
import java.util.List;

public class AddressRepositoryListBased implements AddressRepository {
    private Address address;
    private List<Address> addressList = new ArrayList<>();

    @Override
    public boolean addAddress(Long personId, double latitude, double longitude) {
        return addressList.add(new Address(personId, latitude, longitude));
    }

    @Override
    public List<Address> findAll() {
        return new ArrayList<>(addressList);
    }

    @Override
    public List<Address> findByPersonId(Long personId) {
        return List.of();
    }

    @Override
    public boolean updateAddress(Long personId, double latitude, double longitude) {
        return false;
    }

    @Override
    public boolean deleteAddress(Long personId) {
        return addressList.removeIf(a -> a != null && a.getPersonId().equals(personId));
    }
}