package pl.gornik;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private int number;
    private String address;
    private double surface;
    private double rent;
    private Owner owner;
    private int numberOfTenants;
    private List<Tenant> tenants;
    private List<Payment> payments;

    public Apartment(int number, String address, double surface, double rent, Owner owner, int numberOfTenants) {
        this.number = number;
        this.address = address;
        this.surface = surface;
        this.rent = rent;
        this.owner = owner;
        this.numberOfTenants = numberOfTenants;
        this.tenants = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public Apartment(int number, String address) {
        this.number = number;
        this.address = address;
        this.tenants = new ArrayList<>();
    }

    // add, remove, view tenants
    public void addTenant(Tenant tenant) {
        if (tenants.size() < numberOfTenants) {
            tenants.add(tenant);
        } else {
            System.out.println("To mieszkanie osiągneło już maksymalną liczbę lokatorów.");
        }
    }

    public void removeTenant(Tenant tenant) {
        tenants.remove(tenant);
        System.out.println("Usunięto lokatora: " + tenant.getName() + " " + tenant.getSurname());
    }
    // getter
    public List<Tenant> getTenants() {
        return tenants;
    }
    // returns details
    public void displayTenants() {
        if (tenants.isEmpty()) {
            System.out.println("Mieszkanie aktualnie nie ma lokatorów");
        } else {
            System.out.println("Lokatorzy w mieszkaniu nr. " + number + ":");
            for (Tenant tenant : tenants) {
                tenant.displayInfo();
            }
        }
    }

    // payment managment
    public void registerRentPayment(double amount, PaymentType paymentType) {
        if (amount >= rent) {
            Payment payment = new Payment(amount, paymentType);
            payments.add(payment);
            System.out.println("Opłata za czynsz zarejestrowana dla mieszkania nr. " + number + " o wysokości: " + amount + ", zapłacone poprzez " + paymentType);
        } else {
            System.out.println("Płatność mniejsza od wymaganego czynszu.");
        }
    }

    public void displayPaymentHistory() {
        if (payments.isEmpty()) {
            System.out.println("Brak poprzednich płatności dla mieszkania nr. " + number);
        } else {
            System.out.println("Historia płatności dla mieszkania nr. " + number + ":");
            for (Payment payment : payments) {
                System.out.println("Kwota: " + payment.getPrice() + ", Typu: " + payment.getPaymentType() + ", Data: " + payment.getPaymentDate());
            }
        }
    }

    // calculating rent payments czy cos
    public double getTotalRentCollected() {
        double total = 0;
        for (Payment payment : payments) {
            total += payment.getPrice();
        }
        return total;
    }



    public String getAddress() {
        return address;
    }

    public double getSurface() {
        return surface;
    }

    public double getRent() {
        return rent;
    }

    public Owner getOwner() {
        return owner;
    }

    //add remove tenants, payment managment?

    public int getNumber() {
        return number;
    }
}
