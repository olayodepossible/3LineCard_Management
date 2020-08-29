package com.possible.backendtest.dto;

public class Payload {
    private String scheme;
    private String type;
    private String name;

    public Payload(){}
    public Payload(String scheme, String type, String name) {
        this.scheme = scheme;
        this.type = type;
        this.name = name;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
