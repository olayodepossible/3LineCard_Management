package com.possible.backendtest.dto;

public class CardResponseDto {
    private boolean success;
    private Payload response;

    public CardResponseDto(boolean success, Payload response) {
        this.success = success;
        this.response = response;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Payload getResponse() {
        return response;
    }

    public void setResponse(Payload payload) {
        this.response = payload;
    }
}
