package pl.gornik;

public abstract class Apartment {
    private int number;
    private String address;
    private double surface;
    private double rent;
    private Owner owner;
    private int numberOfTenants;

    public Apartment(int number, String address, double surface, double rent, Owner owner, int numberOfTenants) {
        this.number = number;
        this.address = address;
        this.surface = surface;
        this.rent = rent;
        this.owner = owner;
        this.numberOfTenants = numberOfTenants;
    }

    public Apartment(int number, String address) {
        this.number = number;
        this.address = address;
    }

    //add remove tenants, payment managment?

    public int getNumber() {
        return number;
    }
}
