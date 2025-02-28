package pl.gornik;

import java.time.LocalDate;

public class ServiceRequest {
    private Apartment apartment;
    private String damageDescription;
    private LocalDate reportDate;
    private ReportType reportType;

    public ServiceRequest(Apartment apartment, String damageDescription, LocalDate reportDate, ReportType reportType) {
        this.apartment = apartment;
        this.damageDescription = damageDescription;
        this.reportDate = reportDate;
        this.reportType = reportType;
    }
}
