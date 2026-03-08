package pl.gornik.data;

import pl.gornik.model.HomeownerAssociation;
import pl.gornik.model.Apartment;
import pl.gornik.model.person.Owner;
import pl.gornik.model.person.Tenant;
import pl.gornik.model.service.ServiceRequest;
import pl.gornik.model.service.ReportType;
import pl.gornik.model.payment.Payment;
import pl.gornik.model.payment.PaymentType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    public static HomeownerAssociation initializeData() {
        List<Apartment> apartmentList = new ArrayList<>();
        List<Owner> ownerList = new ArrayList<>();
        List<ServiceRequest> serviceRequestList = new ArrayList<>();

        // Tworzenie właścicieli
        Owner owner1 = new Owner("Alicja", "Baran", "alicjabaran@gmail.com", "123456789");
        Owner owner2 = new Owner("Kamil", "Korzeń", "kamilkorzen@gmail.com", "243213456");
        Owner owner3 = new Owner("Andrzej", "Fach", "andrzejfach@gmail.com", "539104562");
        Owner owner4 = new Owner("Magdalena", "Kowalska", "magdalena.kowalska@email.com", "987654321");
        Owner owner5 = new Owner("Piotr", "Wiśniewski", "piotr.wisniewski@email.com", "876543219");

        ownerList.add(owner1);
        ownerList.add(owner2);
        ownerList.add(owner3);
        ownerList.add(owner4);
        ownerList.add(owner5);

        // Tworzenie mieszkań
        Apartment apartment1 = new Apartment(14, "ul. Jakaś 4", 70, 950, owner1, 4);
        Apartment apartment2 = new Apartment(6, "ul. Jakaś 4", 55, 600, owner2, 2);
        Apartment apartment3 = new Apartment(9, "ul. Jakaś 4", 40, 400, owner3, 1);
        Apartment apartment4 = new Apartment(21, "ul. Kwiatowa 12", 85, 1200, owner4, 3);
        Apartment apartment5 = new Apartment(32, "ul. Leśna 7", 62, 750, owner5, 2);
        Apartment apartment6 = new Apartment(45, "ul. Słoneczna 3", 95, 1500, owner1, 5); // owner1 ma drugie mieszkanie

        apartmentList.add(apartment1);
        apartmentList.add(apartment2);
        apartmentList.add(apartment3);
        apartmentList.add(apartment4);
        apartmentList.add(apartment5);
        apartmentList.add(apartment6);

        // Tworzenie lokatorów
        Tenant tenant1 = new Tenant("Jan", "Kowalski", "jankowalski@gmail.com", "123123123");
        Tenant tenant2 = new Tenant("Anna", "Nowak", "annanowak@gmail.com", "456456456");
        Tenant tenant3 = new Tenant("Marek", "Zieliński", "marek.zielinski@email.com", "789789789");
        Tenant tenant4 = new Tenant("Katarzyna", "Wójcik", "katarzyna.wojcik@email.com", "321321321");
        Tenant tenant5 = new Tenant("Tomasz", "Kamiński", "tomasz.kaminski@email.com", "654654654");
        Tenant tenant6 = new Tenant("Agnieszka", "Lewandowska", "agnieszka.lewandowska@email.com", "987987987");
        Tenant tenant7 = new Tenant("Paweł", "Dąbrowski", "pawel.dabrowski@email.com", "147147147");

        apartment1.addTenant(tenant1);
        apartment1.addTenant(tenant2);
        apartment2.addTenant(tenant3);
        apartment3.addTenant(tenant4);
        apartment4.addTenant(tenant5);
        apartment4.addTenant(tenant6);
        apartment5.addTenant(tenant7);

        // Tworzenie przykładowych płatności
        Payment payment1 = new Payment(950, PaymentType.CARD);
        Payment payment2 = new Payment(950, PaymentType.BLIK);
        Payment payment3 = new Payment(600, PaymentType.CASH);
        Payment payment4 = new Payment(400, PaymentType.CARD);

        apartment1.registerRentPayment(payment1.getPrice(), payment1.getPaymentType());
        apartment1.registerRentPayment(payment2.getPrice(), payment2.getPaymentType());
        apartment2.registerRentPayment(payment3.getPrice(), payment3.getPaymentType());
        apartment3.registerRentPayment(payment4.getPrice(), payment4.getPaymentType());

        // Tworzenie przykładowych zgłoszeń serwisowych
        ServiceRequest request1 = new ServiceRequest(apartment1, "Przeciekający kran w kuchni", LocalDate.now().minusDays(5), ReportType.DAMAGE);
        ServiceRequest request2 = new ServiceRequest(apartment2, "Malowanie ścian w salonie", LocalDate.now().minusDays(3), ReportType.RENOVATION);
        ServiceRequest request3 = new ServiceRequest(apartment4, "Konserwacja instalacji elektrycznej", LocalDate.now().minusDays(1), ReportType.CONSERVATION);
        ServiceRequest request4 = new ServiceRequest(apartment6, "Wymiana pieca grzewczego", LocalDate.now(), ReportType.RENOVATION);

        serviceRequestList.add(request1);
        serviceRequestList.add(request2);
        serviceRequestList.add(request3);
        serviceRequestList.add(request4);

        return new HomeownerAssociation(apartmentList, ownerList, serviceRequestList);
    }
}