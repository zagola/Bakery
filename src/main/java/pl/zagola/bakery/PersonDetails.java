package pl.zagola.bakery;

class PersonDetails {
    private String firstName;
    private String lastName;


    PersonDetails(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}