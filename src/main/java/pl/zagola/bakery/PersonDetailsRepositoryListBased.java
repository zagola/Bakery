package pl.zagola.bakery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Repository
public class PersonDetailsRepositoryListBased implements PersonDetailsRepository {
    private List<PersonDetails> personDetailsList;
    private static PersonDetailsRepositoryListBased INSTANCE = null;

    @Override
    public boolean addPerson(Long personId, String firstName, String lastName) {
        return personDetailsList.add(
                new PersonDetails(personId, firstName, lastName)
        );
    }

    @Override
    public List<PersonDetails> findAll() {
        return new ArrayList<>(personDetailsList);
    }

    @Override
    public List<PersonDetails> findById(Long personId) {
        return personDetailsList.stream()
                .filter(p -> p != null && p.getPersonId() != null && personId.equals(p.getPersonId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDetails> findByLastName(String lastName) {
        return personDetailsList.stream()
                .filter(p -> lastName.equals(p.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updatePerson(Long personId, String newLastName) {
        return personDetailsList.stream()
                .filter(p -> p != null && p.getPersonId() != null && personId.equals(p.getPersonId()))
                .findFirst()
                .map(p -> { //p - "oldPerson"
                    int index = personDetailsList.indexOf(p);
                    if (index != -1) {
                        PersonDetails updated = new PersonDetails(personId, p.getFirstName(), newLastName);
                        personDetailsList.set(index, updated); //replace
                        return true;
                    }
                    return false;
                })
                .orElse(false);

    }

    @Override
    public boolean deletePerson(Long personId, String firstName, String lastName) {
        return personDetailsList.removeIf(p -> p != null && p.getPersonId() != null
                && personId.equals(p.getPersonId()));
    }

    public static PersonDetailsRepositoryListBased createInstance() {
        return new PersonDetailsRepositoryListBased(new ArrayList<>());
    }

    public static PersonDetailsRepositoryListBased createInstanceSingleton() {
        if (INSTANCE == null) {
            INSTANCE = new PersonDetailsRepositoryListBased(new ArrayList<>());
            return INSTANCE;
        } else {
            return INSTANCE;
        }
    }

    @Override
    public PersonDetailsRepository createRepository() {
        return new PersonDetailsRepositoryListBased(new ArrayList<>());
    }
}