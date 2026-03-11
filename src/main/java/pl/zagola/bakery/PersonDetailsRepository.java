package pl.zagola.bakery;

import java.util.List;

public interface PersonDetailsRepository {

    boolean addPerson(Long id, String firstName, String lastName);

    List<PersonDetails> findAll();

    List<PersonDetails> findByLastName(String lastName);

    List<PersonDetails> findById(Long id);

    boolean updateLastName(Long id, String newLastName);


    boolean deletePerson(PersonDetails personDetails);

}