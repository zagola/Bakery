package pl.zagola.bakery.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private Long personId;
    private double latitude;
    private double longitude;

    @Override
    public String toString() {
        return String.format("Address{personId=%d, lat=%.4f, lon=%.4f}",
                personId, latitude, longitude);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Address address)) return false;
        return Objects.equals(personId, address.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personId);
    }

}