package com.possible.backendtest.model;

public class Card {
    private Number number;
    private String scheme;
    private String type;
    private String brand;
    private boolean prepaid;
    private Country country;
    private Bank bank;


    public String getScheme() {
        return scheme;
    }

    public String getType() {
        return type;
    }

    public Bank getBank() {
        return bank;
    }
}
