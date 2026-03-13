package pl.zagola.bakery;

class Client {
    private PersonDetails details;
    private Address address;
    private Integer clientId;

    protected Client(PersonDetails details, Address address, Integer clientId) {
        this.details = details;
        this.address = address;
        this.clientId = clientId;
    }

    public Address getAddress() {
        return address;
    }

    public PersonDetails getDetails() {
        return details;
    }
}