package pl.zagola.bakery;

import java.util.ArrayList;
import java.util.List;

public class PersonDetailsRepositoryListBased implements PersonDetailsRepository {
    private List<PersonDetails> personDetailsList = new ArrayList<>();

    @Override
    public boolean addPerson(String firstName, String lastName) {
        return personDetailsList.add(
                new PersonDetails(firstName, lastName)
        );

    }

    @Override
    public List<PersonDetails> findAll() {
        return personDetailsList;
    }

    @Override
    public PersonDetails findByLastName(String name) {
        return null;
    }

    @Override
    public boolean updateLastName(PersonDetails personDetails) {
        return false;
    }

    @Override
    public boolean delete(PersonDetails personDetails) {
        return false;
    }

}