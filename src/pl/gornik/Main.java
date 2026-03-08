package pl.gornik;

import pl.gornik.data.DataInitializer;
import pl.gornik.model.Apartment;
import pl.gornik.model.HomeownerAssociation;
import pl.gornik.model.payment.PaymentType;
import pl.gornik.model.person.Owner;
import pl.gornik.model.service.ReportType;
import pl.gornik.model.service.ServiceRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // WEDŁUG UWAG DANE INICJALIZACYJNE MIALY BYC W INNEJ KLASIE
        HomeownerAssociation hoa = DataInitializer.initializeData();

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
            System.out.println("7 - Zarządzaj zgłoszeniami serwisowymi");
            System.out.println("8 - Generuj raport finansowy");
            System.out.println("9 - Wyjście");

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

                        // Info o mieszkaniach tego właściciela
                        System.out.println("\nMieszkania należące do tego właściciela:");
                        boolean hasApartments = false;
                        for (Apartment a : hoa.getApartments()) {
                            if (a.getOwner().getEmail().equals(email)) {
                                hasApartments = true;
                                System.out.println("  Numer: " + a.getNumber() +
                                        ", Adres: " + a.getAddress() +
                                        ", Powierzchnia: " + a.getSurface() + " m²" +
                                        ", Czynsz: " + a.getRent() + " zł" +
                                        ", Liczba lokatorów: " + a.getTenants().size() + "/" + a.getNumberOfTenants());
                            }
                        }
                        if (!hasApartments) {
                            System.out.println("  Brak mieszkań przypisanych do tego właściciela.");
                        }
                    } else {
                        System.out.println("Właściciel nie znaleziony.");
                    }
                    break;

                case 2:
                    // Info o mieszkaniu
                    System.out.println("Podaj numer mieszkania: ");
                    try {
                        apartmentNumber = scanner.nextInt();
                    } catch (Exception e){
                        System.out.println("EXCEPTION: Bład w podanym numerze mieszkania");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine(); // clear scannera
                    Apartment searchedApartment = hoa.findApartmentByNumber(apartmentNumber);
                    if (searchedApartment != null) {
                        System.out.println("Informacje o mieszkaniu:");
                        System.out.println("Numer: " + searchedApartment.getNumber());
                        System.out.println("Adres: " + searchedApartment.getAddress());
                        System.out.println("Powierzchnia: " + searchedApartment.getSurface() + " m²");
                        System.out.println("Czynsz: " + searchedApartment.getRent() + " zł");
                        System.out.println("Właściciel: " + searchedApartment.getOwner().getName() + " " + searchedApartment.getOwner().getSurname());
                        searchedApartment.displayTenants();
                    } else {
                        System.out.println("Mieszkanie nie znalezione.");
                    }
                    break;

                case 3:
                    // Wypis wszystkich właścicieli i mieszkań
                    System.out.println("LISTA WŁAŚCICIELI:");
                    for (Owner o : hoa.getOwners()) {
                        o.displayInfo();
                    }
                    System.out.println("\nLISTA MIESZKAŃ:");
                    for (Apartment a : hoa.getApartments()) {
                        System.out.println("Numer: " + a.getNumber() + ", Adres: " + a.getAddress() + ", Właściciel: " + a.getOwner().getName() + " " + a.getOwner().getSurname());
                    }
                    break;

                case 4:
                    // Info o lokatorach
                    System.out.println("Podaj numer mieszkania: ");
                    try {
                        apartmentNumber = scanner.nextInt();
                    } catch (Exception e){
                        System.out.println("EXCEPTION: Bład w podanym numerze mieszkania");
                        scanner.nextLine();
                        break;
                    }
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
                    try {
                        apartmentNumber = scanner.nextInt();
                    } catch (Exception e){
                        System.out.println("EXCEPTION: Bład w podanym numerze mieszkania");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine(); // clear scannera
                    Apartment apt = hoa.findApartmentByNumber(apartmentNumber);
                    if (apt != null) {
                        System.out.println("Wybierz typ płatności (CASH, BLIK, CARD): ");
                        String paymentTypeStr = scanner.nextLine();
                        try {
                            PaymentType paymentType = PaymentType.valueOf(paymentTypeStr.toUpperCase());
                            apt.registerRentPayment(apt.getRent(), paymentType);
                        } catch (IllegalArgumentException e){
                            System.out.println("EXCEPTION: Niepoprawny typ płatności. Podaj CASH, BLIK lub CARD");
                        }
                    } else {
                        System.out.println("Mieszkanie nie znalezione.");
                    }
                    break;

                case 6:
                    // Wyświetl historię płatności
                    System.out.println("Podaj numer mieszkania: ");
                    try {
                        apartmentNumber = scanner.nextInt();
                    } catch (Exception e){
                        System.out.println("EXCEPTION: Bład w podanym numerze mieszkania");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine(); // clear scannera
                    Apartment aptForHistory = hoa.findApartmentByNumber(apartmentNumber);
                    if (aptForHistory != null) {
                        aptForHistory.displayPaymentHistory();
                    } else {
                        System.out.println("Mieszkanie nie znalezione.");
                    }
                    break;

                case 7:
                    // Zgłoszenia serwisowe
                    manageServiceRequests(scanner, hoa);
                    break;

                case 8:
                    // Raport
                    hoa.generateFinancialReport();
                    break;

                case 9:
                    System.out.println("Kończenie programu...");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór.");
            }
        }

        //ServiceRequest ...

    }

    private static void manageServiceRequests(Scanner scanner, HomeownerAssociation hoa) {
        System.out.println("\n--- ZARZĄDZANIE ZGŁOSZENIAMI SERWISOWYMI ---");
        System.out.println("1 - Dodaj zgłoszenie serwisowe");
        System.out.println("2 - Wyświetl zgłoszenia serwisowe");
        System.out.println("3 - Usuń zgłoszenie serwisowe");
        int serviceChoice = scanner.nextInt();
        scanner.nextLine(); // clear scannera

        switch (serviceChoice) {
            case 1:
                System.out.println("Podaj numer mieszkania: ");
                int aptNumForRequest = 0;
                try {
                    aptNumForRequest = scanner.nextInt();
                } catch (Exception e){
                    System.out.println("EXCEPTION: Bład w podanym numerze mieszkania");
                    scanner.nextLine();
                    break;
                }
                scanner.nextLine(); // Consume newline
                Apartment aptForRequest = hoa.findApartmentByNumber(aptNumForRequest);
                if (aptForRequest != null) {
                    System.out.println("Podaj opis uszkodzenia: ");
                    String description = scanner.nextLine();
                    System.out.println("Wybierz typ zgłoszenia (DAMAGE, RENOVATION, CONSERVATION): ");
                    String reportTypeStr = scanner.nextLine();
                    try {
                        ReportType reportType = ReportType.valueOf(reportTypeStr.toUpperCase());
                        ServiceRequest request = new ServiceRequest(aptForRequest, description, LocalDate.now(), reportType);
                        hoa.addServiceRequest(request);
                    } catch (IllegalArgumentException e){
                        System.out.println("EXCEPTION: Niepoprawny typ zgłoszenia.");
                    }
                } else {
                    System.out.println("Mieszkanie nie znalezione.");
                }
                break;

            case 2:
                hoa.displayServiceRequests();
                break;

            case 3:
                System.out.println("Podaj numer mieszkania: ");
                int aptNumForRemoval = 0;
                try {
                    aptNumForRemoval = scanner.nextInt();
                } catch (Exception e){
                    System.out.println("EXCEPTION: Bład w podanym numerze mieszkania");
                    scanner.nextLine();
                    break;
                }
                scanner.nextLine(); // clear scannera
                List<ServiceRequest> requests = hoa.findServiceRequestsByApartment(aptNumForRemoval);
                if (!requests.isEmpty()) {
                    System.out.println("Zgłoszenia dla mieszkania " + aptNumForRemoval + ":");
                    for (int i = 0; i < requests.size(); i++) {
                        System.out.println((i + 1) + ". " + requests.get(i).getDamageDescription() +
                                " (" + requests.get(i).getReportType() + ")");
                    }
                    System.out.println("Wybierz numer zgłoszenia do usunięcia: ");
                    int requestIndex = 0;
                    try {
                        requestIndex = scanner.nextInt();
                    } catch (Exception e){
                        System.out.println("EXCEPTION: Bład w podanym numerze zgłoszenia");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine(); // Consume newline
                    if (requestIndex > 0 && requestIndex <= requests.size()) {
                        hoa.removeServiceRequest(requests.get(requestIndex - 1));
                    } else {
                        System.out.println("Nieprawidłowy numer zgłoszenia.");
                    }
                } else {
                    System.out.println("Brak zgłoszeń dla tego mieszkania.");
                }
                break;

            default:
                System.out.println("Nieprawidłowy wybór.");
        }
    }
}