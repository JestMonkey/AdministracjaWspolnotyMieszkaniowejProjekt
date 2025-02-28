package pl.gornik;

public abstract class Person {
    protected String name;
    protected String surname;
    protected String email;
    protected String phoneNumber;

    public Person(String name, String surname, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public abstract void displayInfo();
}
