package model;

public class Person {
    private String firstName;
    private String lastName;
    private boolean userHasAccess;

    public Person(String firstName, String lastName, boolean userHasAccess) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userHasAccess = userHasAccess;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean hasAccess() {
        return userHasAccess;
    }
}
