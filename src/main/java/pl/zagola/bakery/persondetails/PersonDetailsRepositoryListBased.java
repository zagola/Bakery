package pl.zagola.bakery.persondetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Repository
public class PersonDetailsRepositoryListBased implements PersonDetailsRepository {
    private List<PersonDetails> personDetailsList = new ArrayList<>();
    private static PersonDetailsRepositoryListBased INSTANCE = null;

    @Override
    public boolean addPerson(PersonDetails personDetails) {
        return personDetailsList.add(personDetails);
    }

    @Override
    public List<PersonDetails> findAll() {
        return new ArrayList<>(personDetailsList);
    }

    @Override
    public Optional<PersonDetails> findById(Long personId) {
        if (personId == null) {
            return Optional.empty();
        }
        return personDetailsList.stream()
                .filter(p -> p.getPersonId().equals(personId))
                .findFirst();
    }

    @Override
    public List<PersonDetails> findByLastName(String lastName) {
        return personDetailsList.stream()
                .filter(p -> lastName.equals(p.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updatePerson(PersonDetails updatedPersonDetails) {
        if (updatedPersonDetails == null) {
            return false;
        }

        boolean found = personDetailsList.stream()
                .anyMatch(oldPerson -> oldPerson.getPersonId().equals(updatedPersonDetails.getPersonId()));

        if (found) {
            personDetailsList.removeIf(oldPerson -> oldPerson.getPersonId()
                    .equals(updatedPersonDetails.getPersonId()));
            personDetailsList.add(updatedPersonDetails);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePerson(Long personId) {
        if (personId == null) {
            return false;
        }
        return personDetailsList.removeIf(p -> p.getPersonId().equals(personId));
    }

    @Override
    public PersonDetailsRepository createRepository() {
        return new PersonDetailsRepositoryListBased(new ArrayList<>());
    }

    public static PersonDetailsRepositoryListBased createInstance() {
        return new PersonDetailsRepositoryListBased(new ArrayList<>());
    }

    public static PersonDetailsRepositoryListBased createInstanceSingleton() {
        if (INSTANCE == null) {
            INSTANCE = new PersonDetailsRepositoryListBased(new ArrayList<>());
        }
        return INSTANCE;
    }
}