package pl.zagola.bakery.persondetails;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class PersonDetailsRepositoryListBasedTest {
    private PersonDetailsRepository repository;

    private static final Long id = 1L;
    private static final String firstName = "Jan";
    private static final String lastName = "Kowalski";

    private static final Long nonExistentId = 333L;
    private static final String nonExistentFirstName = "Robin";
    private static final String nonExistentLastName = "Pigwa";


    @BeforeEach
    public void setUp() {
        List<PersonDetails> personDetails = new ArrayList<>();
        personDetails.add(PersonDetails.builder()
                .firstName(firstName)
                .lastName(lastName)
                .id(id)
                .build()
        );

        this.repository = new PersonDetailsRepositoryListBased(personDetails);
    }

    @Test
    public void shouldAddPerson() {
        //given
        Long newId = 2L;
        String newFirstName = "Kaja";
        String newLastName = "Poniedziałek";

        PersonDetails newPerson = PersonDetails.builder()
                .id(newId)
                .firstName(newFirstName)
                .lastName(newLastName)
                .build();

        //when
        boolean actual = repository.addPerson(newPerson);

        //then
        Assertions.assertTrue(actual);
        Assertions.assertEquals(2, repository.findAll().size());

        Optional<PersonDetails> existingPerson = repository.findById(id);
        Assertions.assertTrue(existingPerson.isPresent());
        PersonDetails existingPersonDetails = existingPerson.get();

        Assertions.assertAll("existing person",
                () -> Assertions.assertEquals(firstName, existingPersonDetails.getFirstName()),
                () -> Assertions.assertEquals(lastName, existingPersonDetails.getLastName())
        );

        Optional<PersonDetails> newAddedPerson = repository.findById(newId);
        Assertions.assertTrue(newAddedPerson.isPresent());
        PersonDetails newAddedPersonDetails = newAddedPerson.get();

        Assertions.assertAll("added person",
                () -> Assertions.assertEquals(newFirstName, newAddedPersonDetails.getFirstName()),
                () -> Assertions.assertEquals(newLastName, newAddedPersonDetails.getLastName())
        );

    }

    @Test
    public void shouldReturnAllPersonalDetails() {
        //given
        //when
        List<PersonDetails> actual = repository.findAll();

        //then
        Assertions.assertEquals(1, actual.size());
        Assertions.assertEquals(id, actual.getFirst().getId());
        Assertions.assertEquals(firstName, actual.getFirst().getFirstName());
        Assertions.assertEquals(lastName, actual.getFirst().getLastName());

    }

    @Test
    public void shouldReturnPersonWhenIdExists() {
        //given
        //when
        Optional<PersonDetails> actual = repository.findById(id);

        //then
        Assertions.assertTrue(actual.isPresent());
        Assertions.assertEquals(id, actual.get().getId());
    }


    @Test
    public void shouldReturnEmptyOptionalWhenIdDoesNotExist() {
        //given
        //when
        Optional<PersonDetails> actual = repository.findById(nonExistentId);

        //then
        Assertions.assertTrue(actual.isEmpty());

    }

    @Test
    public void shouldReturnPersonWithGivenLastName() {
        //given
        //when
        List<PersonDetails> actual = repository.findByLastName(lastName);

        //then
        Assertions.assertEquals(1, actual.size());
        Assertions.assertEquals(lastName, actual.getFirst().getLastName());
    }

    @Test
    public void shouldReturnEmptyListWhenLastNameDoesNotExist() {
        //given
        //when
        List<PersonDetails> actual = repository.findByLastName(nonExistentLastName);

        //then
        Assertions.assertTrue(actual.isEmpty());

    }

    @Test
    public void shouldUpdatePersonWhenExists() {
        //given
        Long updatedId = 1L;
        String updatedFirstName = "Janina";
        String updatedLastName = "Piątek";

        //when
        boolean actual = repository.updatePerson(PersonDetails.builder()
                .id(updatedId)
                .firstName(updatedFirstName)
                .lastName(updatedLastName)
                .build()
        );

        //then
        Assertions.assertTrue(actual);
        PersonDetails person = repository.findAll().getFirst();
        Assertions.assertEquals(updatedId, person.getId());
        Assertions.assertEquals(updatedFirstName, person.getFirstName());
        Assertions.assertEquals(updatedLastName, person.getLastName());

    }


    @Test
    public void shouldNotUpdateNonExistentPerson() {
        //given
        PersonDetails update = PersonDetails.builder()
                .id(nonExistentId)
                .firstName(nonExistentFirstName)
                .lastName(nonExistentLastName)
                .build();

        //when
        boolean actual = repository.updatePerson(update);

        //then
        Assertions.assertFalse(actual);

    }

    @Test
    public void shouldDeletePersonWhenExists() {
        //given
        //when
        boolean actual = repository.deletePerson(id);

        //then
        Assertions.assertTrue(actual);
        Assertions.assertEquals(0, repository.findAll().size());
    }

    @Test
    public void shouldReturnFalseWhenDeletingPersonDoesNotExist() {
        //given
        //when
        boolean actual = repository.deletePerson(nonExistentId);

        //then
        Assertions.assertFalse(actual);
    }

}