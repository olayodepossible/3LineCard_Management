package com.possible.backendtest.model;

public class Bank {
    private String bankName;
    private String bankLink;
    private BankContact bankContact;

    public Bank(String bankName, String bankLink, BankContact bankContact) {
        this.bankName = bankName;
        this.bankLink = bankLink;
        this.bankContact = bankContact;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankLink() {
        return bankLink;
    }

    public void setBankLink(String bankLink) {
        this.bankLink = bankLink;
    }

    public BankContact getBankContact() {
        return bankContact;
    }

    public void setBankContact(BankContact bankContact) {
        this.bankContact = bankContact;
    }
}
