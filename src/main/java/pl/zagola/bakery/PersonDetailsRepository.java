package pl.zagola.bakery;

import java.util.List;

public interface PersonDetailsRepository {

    boolean addPerson(Long personId, String firstName, String lastName);

    List<PersonDetails> findAll();

    List<PersonDetails> findByLastName(String lastName);

    List<PersonDetails> findById(Long personId);

    boolean updatePerson(Long personId, String newLastName);

    boolean deletePerson(Long personId, String firstName, String lastName);

    PersonDetailsRepository createRepository();

}