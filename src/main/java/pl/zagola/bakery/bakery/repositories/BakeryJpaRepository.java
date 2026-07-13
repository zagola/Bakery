package pl.zagola.bakery.bakery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zagola.bakery.bakery.entities.BakeryEntity;

import java.util.Optional;

@Repository
public interface BakeryJpaRepository extends JpaRepository<BakeryEntity, Long> {
    Optional<BakeryEntity> findByName(String name);
    Optional<BakeryEntity> findByOwner_EmployeeId(Long employeeId);
}