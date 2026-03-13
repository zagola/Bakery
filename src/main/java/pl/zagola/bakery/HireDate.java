package pl.zagola.bakery;

import java.time.Instant;

public class HireDate {
    private Long personId;
    private Instant hireDate;

    public HireDate(Long personId, Instant hireDate) {
        this.personId = personId;
        this.hireDate = hireDate;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Instant getHireDate() {
        return hireDate;
    }

    public void setHireDate(Instant hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return String.format("HireDate{personId=%d, hireDate=%s}", personId, hireDate);
    }
}