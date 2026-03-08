package pl.gornik.model.payment;

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
