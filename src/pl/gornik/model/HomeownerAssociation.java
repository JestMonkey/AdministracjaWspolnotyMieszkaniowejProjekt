package pl.gornik.model;

import pl.gornik.model.person.Owner;
import pl.gornik.model.service.ServiceRequest;

import java.util.ArrayList;
import java.util.List;

public class HomeownerAssociation {
    private List<Apartment> apartments;
    private List<Owner> owners;
    private List<ServiceRequest> serviceRequests;

    public HomeownerAssociation(List<Apartment> apartments, List<Owner> owners, List<ServiceRequest> serviceRequests) {
        this.apartments = apartments;
        this.owners = owners;
        this.serviceRequests = serviceRequests;
    }

    public Apartment findApartmentByNumber(int number){
        for (Apartment apartment : apartments){
            if (apartment.getNumber() == number){
                return apartment;
            }
        }
        return null;
    }

    public Owner findOwnerByEmail(String email){
        for (Owner owner : owners){
            if (owner.getEmail().equals(email)) {
                return owner;
            }
        }
        return null;
    }

    // Metody dla ServiceRequest
    public void addServiceRequest(ServiceRequest request){serviceRequests.add(request);}

    public void removeServiceRequest(ServiceRequest request){serviceRequests.remove(request);}

    public List<ServiceRequest> findServiceRequestsByApartment(int apartmentNumber) {
        List<ServiceRequest> requests = new ArrayList<>();
        for (ServiceRequest request : serviceRequests) {
            if (request.getApartment().getNumber() == apartmentNumber) {
                requests.add(request);
            }
        }
        return requests;
    }

    public void displayServiceRequests() {
        if (serviceRequests.isEmpty()) {
            System.out.println("Brak zgłoszeń serwisowych.");
        } else {
            System.out.println("\n=== LISTA ZGŁOSZEŃ SERWISOWYCH ===");
            for (ServiceRequest request : serviceRequests) {
                System.out.println("Mieszkanie nr: " + request.getApartment().getNumber() +
                        ", Opis: " + request.getDamageDescription() +
                        ", Typ: " + request.getReportType() +
                        ", Data: " + request.getReportDate());
            }
        }
    }

    public void generateFinancialReport() {
        double totalRentCollected = 0;
        double totalOutstandingRent = 0;

        System.out.println("\n=== RAPORT FINANSOWY ===");
        for (Apartment apartment : apartments) {
            double rentCollected = apartment.getTotalRentCollected();
            double outstandingRent = apartment.getOutstandingRent();
            totalRentCollected += rentCollected;
            totalOutstandingRent += outstandingRent;

            System.out.println("Mieszkanie " + apartment.getNumber() + ":");
            System.out.println("  Zebrany czynsz: " + rentCollected + " zł");
            System.out.println("  Zaległości: " + outstandingRent + " zł");
        }

        System.out.println("\n--- PODSUMOWANIE ---");
        System.out.println("Łącznie zebrany czynsz: " + totalRentCollected + " zł");
        System.out.println("Łączne zaległości: " + totalOutstandingRent + " zł");
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public List<Owner> getOwners() {
        return owners;
    }
}
