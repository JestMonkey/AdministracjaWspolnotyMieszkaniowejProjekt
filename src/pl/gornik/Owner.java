package pl.gornik;

public class Owner extends Person {
    public Owner(String name, String surname, String email, String phoneNumber) {
        super(name, surname, email, phoneNumber);
    }

    @Override
    public void displayInfo() {
        System.out.println("Dane właściciela:\nImię: " + name + "\nNazwisko: " + surname);
    }

    //
}
