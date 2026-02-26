package pl.zagola.bakery;

public abstract class Person {
    private String firstName;
    private String lastName;

    protected Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}