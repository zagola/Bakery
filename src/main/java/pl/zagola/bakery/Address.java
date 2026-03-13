package pl.zagola.bakery;

public class Address {
    private Long personId;
    private double latitude;
    private double longitude;

    public Address(Long personId, double latitude, double longitude) {
        this.personId = personId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return String.format("Address{personId=%d, lat=%.4f, lon=%.4f}",
                personId, latitude, longitude);
    }
}