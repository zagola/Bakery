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
    public boolean addPerson(Long id, String firstName, String lastName) {
        return personDetailsList.add(
                new PersonDetails(id, firstName, lastName)
        );
    }

    @Override
    public List<PersonDetails> findAll() {
        return new ArrayList<>(personDetailsList);
    }

    @Override
    public List<PersonDetails> findById(Long id) {
        return personDetailsList.stream()
                .filter(p -> p != null && p.getId() != null && id.equals(p.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDetails> findByLastName(String lastName) {
        return personDetailsList.stream()
                .filter(p -> lastName.equals(p.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateLastName(Long id, String newLastName) {
        return personDetailsList.stream()
                .filter(p -> p != null && p.getId() != null && id.equals(p.getId()))
                .findFirst()
                .map(p -> {
                    p.setLastName(newLastName);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public boolean deletePerson(Long id, String firstName, String lastName) {
        return personDetailsList.removeIf(p -> p != null && p.getId() != null
                && id.equals(p.getId()));
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