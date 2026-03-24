package pl.zagola.bakery;

import java.time.Instant;

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
}