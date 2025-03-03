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

        //Owner owner1
        Owner owner1 = new Owner("Alicja", "Baran", "alicjabaran@gmail.com", "123456789");
        Owner owner2 = new Owner("Kamil", "Korzeń", "kamilkorzen@gmail.com", "243213456");
        Owner owner3 = new Owner("Andrzej", "Fach", "andrzejfach@gmail.com", "539104562");
        ownerList.add(owner1);
        ownerList.add(owner2);
        ownerList.add(owner3);
        //Apartment apartment1
        Apartment apartment1 = new Apartment(14, "ul. Jakaś 4", 70, 950, owner1, 4);
        Apartment apartment2 = new Apartment(6, "ul. Jakaś 4", 55, 600, owner2, 2);
        Apartment apartment3 = new Apartment(9, "ul. Jakaś 4", 40, 400, owner3, 1);
        apartmentList.add(apartment1);
        apartmentList.add(apartment2);
        apartmentList.add(apartment3);
        //Tenant tenant1

        System.out.println("Wybierz pożądaną informacje: ");
        System.out.println("1 - Info o właścicielu");
        System.out.println("2 - Info o mieszkaniu");
        System.out.println("3 - Wypis wszystkich właścicieli i mieszkań");

        //ServiceRequest ...

    }
}