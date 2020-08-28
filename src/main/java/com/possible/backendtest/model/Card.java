package com.possible.backendtest.model;

public class Card {
    private CardNumber cardNum;
    private String cardScheme;
    private String cardType;
    private String cardBrand;
    private boolean paymentPlan;
    private Country address;
    private Bank bank;

    public CardNumber getCardNum() {
        return cardNum;
    }

    public void setCardNum(CardNumber cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardScheme() {
        return cardScheme;
    }

    public void setCardScheme(String cardScheme) {
        this.cardScheme = cardScheme;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public boolean isPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(boolean paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public Country getAddress() {
        return address;
    }

    public void setAddress(Country address) {
        this.address = address;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
