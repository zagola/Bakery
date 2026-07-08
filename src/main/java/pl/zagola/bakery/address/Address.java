package pl.zagola.bakery.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Long personId;
    private double latitude;
    private double longitude;

    @Override
    public String toString() {
        return String.format("Address{personId=%d, lat=%.4f, lon=%.4f}",
                personId, latitude, longitude);
    }
}