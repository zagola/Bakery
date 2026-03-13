package pl.zagola.bakery;

import java.util.List;

public interface AddressRepository {

    boolean addAddress(Long personId, double latitude, double longitude);

    List<Address> findAll();

    List<Address> findByPersonId(Long personId);

    boolean updateAddress(Long personId, double latitude, double longitude);

    boolean deleteAddress(Long personId);

}