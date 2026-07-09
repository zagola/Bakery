package pl.zagola.bakery.legacy.owner;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.zagola.bakery.owner.Owner;
import pl.zagola.bakery.persondetails.PersonDetails;
import pl.zagola.bakery.address.Address;
import pl.zagola.bakery.hiredate.HireDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
public class OwnerRepositoryListBased implements OwnerRepository {

    private List<Owner> ownerList = new ArrayList<>();

    @Override
    public boolean addOwner(PersonDetails personDetails, Address address, HireDate hireDate) {
        if (personDetails == null || address == null || hireDate == null) {
            return false;
        }

        boolean exists = ownerList.stream()
                .anyMatch(o -> o.getPersonDetails().getId()
                        .equals(personDetails.getId()));
        if (exists) {
            return false;
        }

        ownerList.add(new Owner(personDetails, address, hireDate));
        return true;
    }

    @Override
    public List<Owner> findOwner() {
        return new ArrayList<>(ownerList);
    }

    @Override
    public Optional<Owner> findById(Long personId) {
        if (personId == null) {
            return Optional.empty();
        }

        return ownerList.stream()
                .filter(o -> o.getPersonDetails().getId().equals(personId))
                .findFirst();
    }

    @Override
    public boolean updateOwner(PersonDetails updatedPersonDetails, Address updatedAddress, HireDate updatedHireDate) {
        if (updatedPersonDetails == null || updatedAddress == null || updatedHireDate == null) {
            return false;
        }

        boolean found = ownerList.stream()
                .anyMatch(o -> o.getPersonDetails().getId().equals(updatedPersonDetails.getId()));

        if (found) {
            ownerList.removeIf(o -> o.getPersonDetails().getId().equals(updatedPersonDetails.getId()));
            ownerList.add(new Owner(updatedPersonDetails, updatedAddress, updatedHireDate));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteOwner(Long personId) {
        if (personId == null) {
            return false;
        }
        return ownerList.removeIf(o -> o.getPersonDetails().getId().equals(personId));
    }
}