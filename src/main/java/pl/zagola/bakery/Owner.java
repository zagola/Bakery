package pl.zagola.bakery;

public class Owner {
    private final PersonDetails personDetails;
    private final Address address;
    private final HireDate hireDate;

    public Owner(PersonDetails personDetails, Address address, HireDate hireDate) {
        this.personDetails = personDetails;
        this.address = address;
        this.hireDate = hireDate;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public Address getAddress() {
        return address;
    }

    public HireDate getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "personDetails=" + personDetails +
                ", address=" + address +
                ", hireDate=" + hireDate +
                '}';
    }
}