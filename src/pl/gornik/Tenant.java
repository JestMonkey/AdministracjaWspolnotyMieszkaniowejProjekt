package pl.gornik;

public class Tenant extends Person {
    private Apartment apartment;

    public Tenant(String name, String surname, String email, String phoneNumber, Apartment apartment) {
        super(name, surname, email, phoneNumber);
        this.apartment = apartment;
    }

    @Override
    public void displayInfo() {
        System.out.println("Lokator: " + name + " " + surname);
    }
}
