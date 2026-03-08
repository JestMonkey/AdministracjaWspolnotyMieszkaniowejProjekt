package pl.gornik.model.person;


public class Tenant extends Person {

    public Tenant(String name, String surname, String email, String phoneNumber) {
        super(name, surname, email, phoneNumber);
    }

    @Override
    public void displayInfo() {
        System.out.println("Lokator: " + name + " " + surname);
    }
}
