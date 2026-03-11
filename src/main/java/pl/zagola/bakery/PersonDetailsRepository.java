package pl.zagola.bakery;

import java.util.List;

public interface PersonDetailsRepository {

    boolean addPerson(String firstName, String lastName);

    List<PersonDetails> findAll();

    PersonDetails findByLastName(String name);

    boolean updateLastName(PersonDetails personDetails);

    boolean delete(PersonDetails personDetails);

}