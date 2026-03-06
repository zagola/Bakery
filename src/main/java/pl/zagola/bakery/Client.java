package pl.zagola.bakery;

class Client {
    private PersonDetails details;
    private GeographicAddress address;
    private Integer clientId;

    protected Client(PersonDetails details, GeographicAddress address, Integer clientId) {
        this.details = details;
        this.address = address;
        this.clientId = clientId;
    }

    public GeographicAddress getAddress() {
        return address;
    }

    public PersonDetails getDetails() {
        return details;
    }
}