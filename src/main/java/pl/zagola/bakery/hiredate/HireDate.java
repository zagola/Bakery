package pl.zagola.bakery.hiredate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HireDate {
    private Long personId;
    private Instant hireDate;

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