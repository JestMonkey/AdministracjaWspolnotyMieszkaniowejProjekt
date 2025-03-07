package pl.gornik;

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

    public void addApartment(Apartment apartment){ apartments.add(apartment);}

    public void removeApartment(Apartment apartment){
        apartments.remove(apartment);
    }

    public Apartment findApartmentByNumber(int number){
        for (Apartment apartment : apartments){
            if (apartment.getNumber() == number){
                return apartment;
            }
        }
        return null;
    }

    public void addOwner(Owner owner){owners.add(owner);}

    public void removeOwner(Owner owner){owners.remove(owner);}

    public Owner findOwnerByEmail(String email){
        for (Owner owner : owners){
            if (owner.getEmail().equals(email)) {
                return owner;
            }
        }
        return null;
    }

    public void addServiceRequest(ServiceRequest request){serviceRequests.add(request);}

    public void removeServiceRequest(ServiceRequest request){serviceRequests.remove(request);}

    public void displayServiceRequests() {
        if (serviceRequests.isEmpty()) {
            System.out.println("Nie znaleziono zgłoszeń serwisowych");
        } else {
            System.out.println("ZGŁOSZENIA SERWISOWE:");
            for (ServiceRequest request : serviceRequests) {
                System.out.println("Mieszkanie nr: " + request.getApartment().getNumber() +
                        ", Opis zgłoszenia: " + request.getDamageDescription() +
                        ", Typ: " + request.getReportType() +
                        ", Data: " + request.getReportDate());
            }
        }
    }

    public List<ServiceRequest> findServiceRequestsByApartmentNumber(int apartmentNumber) {
        List<ServiceRequest> requests = new ArrayList<>();
        for (ServiceRequest request : serviceRequests) {
            if (request.getApartment().getNumber() == apartmentNumber) {
                requests.add(request);
            }
        }
        return requests;
    }

    public void generateFinancialReport() {
        double totalRentCollected = 0;

        System.out.println("Financial Report:");
        for (Apartment apartment : apartments) {
            double rentCollected = apartment.getTotalRentCollected();
            totalRentCollected += rentCollected;

            System.out.println("Apartment " + apartment.getNumber() + ":\n");
            System.out.println("Zebrany czynsz: " + rentCollected);
        }

        System.out.println("\nPodsumowanie:");
        System.out.println("Całość finansów: " + totalRentCollected);
    }
}
