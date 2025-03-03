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

    //
    //public List<ServiceRequest> getServiceRequestsByType(ReportType type) {
    //public List<ServiceRequest> getAllServiceRequests() {
}
