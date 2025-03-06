package pl.gornik;

import java.time.LocalDate;

public class Payment {
    private double price;
    private PaymentType paymentType;
    private LocalDate paymentDate;

    public Payment(double price, PaymentType paymentType) {
        this.price = price;
        this.paymentType = paymentType;
        this.paymentDate = LocalDate.now();
    }

    public void processPayment(double price, PaymentType paymentType){
        this.price = price;
        this.paymentType = paymentType;
        this.paymentDate = LocalDate.now();
        System.out.println("Przetworzono płatność o wysokości " + price + " poprzez " + paymentType);
    }

    public double getPrice() {
        return price;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
}
