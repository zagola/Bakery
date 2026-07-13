package pl.zagola.bakery.hiredate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zagola.bakery.hiredate.entities.HireDateEntity;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface HireDateJpaRepository extends JpaRepository<HireDateEntity, Long> {
    Optional<HireDateEntity> findByPerson_PersonId(Long personId);
    List<HireDateEntity> findByHireDateAfter(Instant threshold);
    List<HireDateEntity> findByHireDateBefore(Instant threshold);
    List<HireDateEntity> findByHireDateBetween(Instant from, Instant to);
}