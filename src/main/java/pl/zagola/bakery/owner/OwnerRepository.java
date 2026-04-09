package pl.zagola.bakery.owner;

import pl.zagola.bakery.persondetails.PersonDetails;
import pl.zagola.bakery.address.Address;
import pl.zagola.bakery.hiredate.HireDate;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

    boolean addOwner(PersonDetails personDetails, Address address, HireDate hireDate);

    List<Owner> findOwner();

    Optional<Owner> findById(Long personId);

    boolean updateOwner(PersonDetails personDetails, Address address, HireDate hireDate);

    boolean deleteOwner(Long personId);
}