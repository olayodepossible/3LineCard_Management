package com.possible.backendtest.dto;

public class CardResponseDto {
    private boolean success;
    private ResponsePayload response;

    public CardResponseDto(boolean success, ResponsePayload response) {
        this.success = success;
        this.response = response;
    }
}
