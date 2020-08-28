package com.possible.backendtest.dto;

public class ResponsePayload {
    private String cardScheme;
    private String cardType;
    private String bankName;

    public ResponsePayload(String cardScheme, String cardType, String bankName) {

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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
