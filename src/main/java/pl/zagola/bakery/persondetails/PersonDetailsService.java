package pl.zagola.bakery.persondetails;

import org.springframework.stereotype.Service;
import pl.zagola.bakery.persondetails.entities.PersonDetailsEntity;
import pl.zagola.bakery.persondetails.repositories.PersonDetailsJpaRepository;

import java.util.List;

@Service
public class PersonDetailsService {
    private final PersonDetailsJpaRepository personDetailsJpaRepository;

    public PersonDetailsService(PersonDetailsJpaRepository personDetailsJpaRepository) {
        this.personDetailsJpaRepository = personDetailsJpaRepository;
    }

    public List<PersonDetails> getPersonDetails() {
        return personDetailsJpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    public boolean addPersonDetails(PersonDetails personDetails) {
        PersonDetailsEntity entity = toEntity(personDetails);
        PersonDetailsEntity saved = personDetailsJpaRepository.save(entity);
        return saved.getPersonId() != null;
    }

    private PersonDetails toDomain(PersonDetailsEntity entity) {
        return PersonDetails.builder()
                .id(entity.getPersonId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }

    private PersonDetailsEntity toEntity(PersonDetails personDetails) {
        PersonDetailsEntity entity = new PersonDetailsEntity();
        entity.setPersonId(personDetails.getId());
        entity.setFirstName(personDetails.getFirstName());
        entity.setLastName(personDetails.getLastName());
        return entity;
    }
}