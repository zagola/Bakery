package pl.zagola.bakery;

import java.util.List;
import java.util.Optional;

public interface PersonDetailsRepository {

    boolean addPerson(PersonDetails personDetails);

    List<PersonDetails> findAll();

    List<PersonDetails> findByLastName(String lastName);

    Optional<PersonDetails> findById(Long personId);

    boolean updatePerson(PersonDetails updatedPersonDetails);

    boolean deletePerson(Long personId);

    PersonDetailsRepository createRepository();

}