package pl.zagola.bakery.address.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zagola.bakery.address.entities.AddressEntity;

import java.util.List;

@Repository
public interface AddressJpaRepository extends JpaRepository<AddressEntity, Long> {
    List<AddressEntity> findByPerson_PersonId(Long personId);
}