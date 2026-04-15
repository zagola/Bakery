package pl.zagola.bakery.persondetails;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class PersonDetailsRepositoryListBasedTest {
    private PersonDetailsRepository repository;

    @BeforeEach
    public void setUp() {
        List<PersonDetails> personDetails = new ArrayList<>();
        personDetails.add(PersonDetails.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .id(2L)
                .build()
        );

        this.repository = new PersonDetailsRepositoryListBased(personDetails);
    }

    @Test
    public void shouldAddPerson() {
        //given
        PersonDetails newPerson = PersonDetails.builder()
                .id(10L)
                .firstName("Kaja")
                .lastName("Poniedziałek")
                .build();

        //when
        boolean actual = repository.addPerson(newPerson);

        //then
        Assertions.assertTrue(actual);
        Assertions.assertEquals(2, repository.findAll().size());

    }

    @Test
    public void shouldReturnAllPersonalDetails() {
        //given

        //when
        List<PersonDetails> actual = repository.findAll();

        //then
        Assertions.assertEquals(1, actual.size());
        Assertions.assertEquals(2L, actual.get(0).getId());
        Assertions.assertEquals("Jan", actual.get(0).getFirstName());
        Assertions.assertEquals("Kowalski", actual.get(0).getLastName());

    }

    @Test
    public void shouldReturnPersonWhenIdExists() {
        //given
        Long id = 2L;

        //when
        Optional<PersonDetails> actual = repository.findById(id);

        //then
        Assertions.assertTrue(actual.isPresent());
        Assertions.assertEquals(2L, actual.get().getId());
    }

    @Test
    public void shouldReturnPersonWhenIdDoesNotExist() {
        //given
        Long id = 333L;

        //when
        Optional<PersonDetails> actual = repository.findById(id);

        //then
        Assertions.assertFalse(actual.isPresent());

    }

    @Test
    public void shouldReturnPersonWithGivenLastName() {
        //given
        repository.addPerson(PersonDetails.builder()
                .id(5L)
                .firstName("Grzegorz")
                .lastName("Nowak")
                .build()
        );

        // when
        List<PersonDetails> actual = repository.findByLastName("Nowak");

        //then
        Assertions.assertEquals(1, actual.size());
        Assertions.assertEquals("Nowak", actual.get(0).getLastName());
    }

    @Test
    public void shouldReturnEmptyListWhenLastNameNotFound() {
        //given

        //when
        List<PersonDetails> actual = repository.findByLastName("Pigwa");

        //then
        Assertions.assertTrue(actual.isEmpty());

    }

    @Test
    public void shouldReturnUpdatedPerson() {
        //given

        //when
        boolean actual = repository.updatePerson(PersonDetails.builder()
                .id(2L)
                .firstName("Janina")
                .lastName("Piątek")
                .build()
        );

        //then
        Assertions.assertTrue(actual);
        Assertions.assertEquals(2L, repository.findAll().get(0).getId());
        Assertions.assertEquals("Janina", repository.findAll().get(0).getFirstName());
        Assertions.assertEquals("Piątek", repository.findAll().get(0).getLastName());

    }

    @Test
    public void shouldNotUpdateWhenPersonDoesNotExist() {
        //given
        PersonDetails update = PersonDetails.builder()
                .id(333L)
                .firstName("Janina")
                .lastName("Piątek")
                .build();

        //when
        boolean actual = repository.updatePerson(update);

        //then
        Assertions.assertFalse(actual);

    }

    @Test
    public void shouldDeletePerson() {
        //given

        //when
        boolean actual = repository.deletePerson(2L);

        //then
        Assertions.assertTrue(actual);
        Assertions.assertEquals(0, repository.findAll().size());
    }

    @Test
    public void shouldReturnFalseWhenDeletingPersonDoesNotExist() {
        //given

        //when
        boolean actual = repository.deletePerson(9L);

        //then
        Assertions.assertFalse(actual);
    }

}