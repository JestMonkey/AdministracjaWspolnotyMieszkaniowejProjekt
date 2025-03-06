package pl.gornik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Apartment> apartmentList = new ArrayList<>();
        List<Owner> ownerList = new ArrayList<>();
        List<ServiceRequest> serviceRequestList = new ArrayList<>();

        HomeownerAssociation hoa = new HomeownerAssociation(apartmentList, ownerList, serviceRequestList);

        Owner owner1 = new Owner("Alicja", "Baran", "alicjabaran@gmail.com", "123456789");
        Owner owner2 = new Owner("Kamil", "Korzeń", "kamilkorzen@gmail.com", "243213456");
        Owner owner3 = new Owner("Andrzej", "Fach", "andrzejfach@gmail.com", "539104562");
        ownerList.add(owner1);
        ownerList.add(owner2);
        ownerList.add(owner3);

        Apartment apartment1 = new Apartment(14, "ul. Jakaś 4", 70, 950, owner1, 4);
        Apartment apartment2 = new Apartment(6, "ul. Jakaś 4", 55, 600, owner2, 2);
        Apartment apartment3 = new Apartment(9, "ul. Jakaś 4", 40, 400, owner3, 1);
        apartmentList.add(apartment1);
        apartmentList.add(apartment2);
        apartmentList.add(apartment3);

        Tenant tenant1 = new Tenant("Jan", "Kowalski", "jankowalski@gmail.com", "123123123", apartment1);
        Tenant tenant2 = new Tenant("Anna", "Nowak", "annanowak@gmail.com", "456456456", apartment1);
        Tenant tenant3 = new Tenant("Zbigniew", "Żyła", "zbigniewzyla@gmail.com", "789789789", apartment3);
        apartment1.addTenant(tenant1);
        apartment1.addTenant(tenant2);
        apartment3.addTenant(tenant3);

        while (true) {
            System.out.println("===============================");
            System.out.println("Witamy w administracji wspólnoty mieszkaniowej :)");
            System.out.println("Wybierz pożądaną informacje: ");
            System.out.println("1 - Info o właścicielu");
            System.out.println("2 - Info o mieszkaniu");
            System.out.println("3 - Wypis wszystkich właścicieli i mieszkań");
            System.out.println("4 - Info o lokatorach");
            System.out.println("5 - Zarejestruj płatność czynszu");
            System.out.println("6 - Wyświetl historię płatności");
            System.out.println("7 - Wyjście");
            int selectedOption = scanner.nextInt();
            scanner.nextLine(); // clear scannera
            int apartmentNumber = 0;

            switch (selectedOption) {
                case 1:
                    // Info o właścicielu
                    System.out.println("Podaj email właściciela: ");
                    String email = scanner.nextLine();
                    Owner owner = hoa.findOwnerByEmail(email);
                    if (owner != null) {
                        owner.displayInfo();
                    } else {
                        System.out.println("Właściciel nie znaleziony.");
                    }
                    break;

                case 2:
                    // Info o mieszkaniu
                    System.out.println("Podaj numer mieszkania: ");
                    apartmentNumber = scanner.nextInt();
                    scanner.nextLine(); // clear scannera
                    Apartment searchedApartment = hoa.findApartmentByNumber(apartmentNumber);
                    if (searchedApartment != null) {
                        System.out.println("Informacje o mieszkaniu:");
                        System.out.println("Numer: " + searchedApartment.getNumber());
                        System.out.println("Adres: " + searchedApartment.getAddress());
                        System.out.println("Powierzchnia: " + searchedApartment.getSurface() + " m²");
                        System.out.println("Czynsz: " + searchedApartment.getRent() + " zł");
                        System.out.println("Właściciel: " + searchedApartment.getOwner().getName() + " " + searchedApartment.getOwner().getSurname());

                    } else {
                        System.out.println("Mieszkanie nie znalezione.");
                    }
                    break;

                case 3:
                    // Wypis wszystkich właścicieli i mieszkań
                    System.out.println("LISTA WŁAŚCICIELI:");
                    for (Owner o : ownerList) {
                        o.displayInfo();
                    }
                    System.out.println("\nLista mieszkań:");
                    for (Apartment a : apartmentList) {
                        System.out.println("Numer: " + a.getNumber() + ", Adres: " + a.getAddress() + ", Właściciel: " + a.getOwner().getName() + " " + a.getOwner().getSurname());
                    }
                    break;
                case 4:
                    // Info o lokatorach
                    System.out.println("Podaj numer mieszkania: ");
                    apartmentNumber = scanner.nextInt();
                    scanner.nextLine(); // clear scannera
                    Apartment apartment = hoa.findApartmentByNumber(apartmentNumber);
                    if (apartment != null) {
                        apartment.displayTenants();
                    } else {
                        System.out.println("Mieszkanie nie znalezione.");
                    }
                    break;

                case 5:
                    // Zarejestruj płatność czynszu
                    System.out.println("Podaj numer mieszkania: ");
                    apartmentNumber = scanner.nextInt();
                    scanner.nextLine(); // clear scannera
                    Apartment apt = hoa.findApartmentByNumber(apartmentNumber);
                    if (apt != null) {
                        System.out.println("Podaj kwotę płatności: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // clear scannera
                        System.out.println("Wybierz typ płatności (CASH, BLIK, CARD): ");
                        String paymentTypeStr = scanner.nextLine();
                        PaymentType paymentType = PaymentType.valueOf(paymentTypeStr.toUpperCase());
                        apt.registerRentPayment(amount, paymentType);
                    } else {
                        System.out.println("Mieszkanie nie znalezione.");
                    }
                    break;

                case 6:
                    // Wyświetl historię płatności
                    System.out.println("Podaj numer mieszkania: ");
                    apartmentNumber = scanner.nextInt();
                    scanner.nextLine(); // clear scannera
                    Apartment aptForHistory = hoa.findApartmentByNumber(apartmentNumber);
                    if (aptForHistory != null) {
                        aptForHistory.displayPaymentHistory();
                    } else {
                        System.out.println("Mieszkanie nie znalezione.");
                    }
                    break;

                case 7:
                    System.out.println("Kończenie programu...");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór.");
            }
        }

        //ServiceRequest ...

    }
}