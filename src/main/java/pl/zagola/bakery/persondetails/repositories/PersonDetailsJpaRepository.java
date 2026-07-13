package pl.zagola.bakery.persondetails.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zagola.bakery.persondetails.entities.PersonDetailsEntity;

@Repository
public interface PersonDetailsJpaRepository extends JpaRepository<PersonDetailsEntity, Long> {
}