package pl.zagola.bakery.hiredate;

import java.time.Instant;
import java.util.Objects;

public class HireDate {
    private final Long personId;
    private final Instant hireDate;

    public HireDate(Long personId, Instant hireDate) {
        this.personId = personId;
        this.hireDate = hireDate;
    }

    public Long getPersonId() {
        return personId;
    }

    public Instant getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return String.format("HireDate{personId=%d, hireDate=%s}", personId, hireDate);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HireDate hireDate)) return false;
        return Objects.equals(personId, hireDate.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personId);
    }

}