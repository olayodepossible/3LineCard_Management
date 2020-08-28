package com.possible.backendtest.model;

public class Number {
    private int length;
    private boolean luhn;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isLuhn() {
        return luhn;
    }

    public void setCardVerify(boolean luhn) {
        this.luhn = luhn;
    }
}
