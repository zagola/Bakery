package pl.zagola.bakery;

import java.util.Objects;

public class PersonDetails {
    private final Long personId;
    private final String firstName;
    private final String lastName;

    PersonDetails(Long id, String firstName, String lastName) {
        this.personId = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + personId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDetails that)) return false;
        return Objects.equals(personId, that.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personId);
    }

}