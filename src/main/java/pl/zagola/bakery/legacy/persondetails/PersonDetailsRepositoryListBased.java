package pl.zagola.bakery.legacy.persondetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.zagola.bakery.persondetails.PersonDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
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
                .filter(p -> p.getId().equals(personId))
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
                .anyMatch(oldPerson -> oldPerson.getId().equals(updatedPersonDetails.getId()));

        if (found) {
            personDetailsList.removeIf(oldPerson -> oldPerson.getId()
                    .equals(updatedPersonDetails.getId()));
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
        return personDetailsList.removeIf(p -> p.getId().equals(personId));
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