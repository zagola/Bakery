package pl.zagola.bakery;

public class Client extends Person {
    private GeographicAddress address;

    protected Client(String firstName, String lastName, GeographicAddress address) {
        super(firstName, lastName);
        this.address = address;
    }
}