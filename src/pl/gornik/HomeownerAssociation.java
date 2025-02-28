package pl.gornik;

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

    public void addApartment(Apartment apartment){
        apartments.add(apartment);
    }

    public void removeApartment(Apartment apartment){
        apartments.remove(apartment);
    }
}
