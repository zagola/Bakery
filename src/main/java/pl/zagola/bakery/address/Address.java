package pl.zagola.bakery.address;

import java.util.Objects;

public class Address {
    private final Long personId;
    private final double latitude;
    private final double longitude;

    public Address(Long personId, double latitude, double longitude) {
        this.personId = personId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getPersonId() {
        return personId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

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