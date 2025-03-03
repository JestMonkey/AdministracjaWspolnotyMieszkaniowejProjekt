package pl.gornik;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Apartment> apartmentList = new ArrayList<>();
        List<Owner> ownerList = new ArrayList<>();
        List<ServiceRequest> serviceRequestList = new ArrayList<>();

        HomeownerAssociation hoa = new HomeownerAssociation(apartmentList, ownerList, serviceRequestList);

        //Owner owner1
        //Apartment apartment1
        //Tenant tenant1
        //ServiceRequest ...

    }
}