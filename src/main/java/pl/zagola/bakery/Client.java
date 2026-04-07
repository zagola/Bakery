package pl.zagola.bakery;

public class Client {
    private final PersonDetails personDetails;
    private final Address address;


    public Client(PersonDetails personDetails, Address address) {
        this.personDetails = personDetails;
        this.address = address;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "address=" + address +
                ", personDetails=" + personDetails +
                '}';
    }
}