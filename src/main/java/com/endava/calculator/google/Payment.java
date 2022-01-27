package com.endava.calculator.google;

import java.util.Objects;

public class Payment {

    private double amount;
    private String currency;
    private String cardNUmber;
    private String customerName;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCardNUmber() {
        return cardNUmber;
    }

    public void setCardNUmber(String cardNUmber) {
        this.cardNUmber = cardNUmber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.amount, amount) == 0 && Objects.equals(currency, payment.currency)
                && Objects.equals(cardNUmber, payment.cardNUmber)
                && Objects.equals(customerName, payment.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency, cardNUmber, customerName);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                ", cardNUmber='" + cardNUmber + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
