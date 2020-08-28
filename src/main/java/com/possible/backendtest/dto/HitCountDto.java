package com.possible.backendtest.dto;

import java.util.LinkedHashMap;

public class HitCountDto {
    private boolean success;
    private int start;
    private int limit;
    private int size;
    private LinkedHashMap<String, Integer> response;

    public HitCountDto(boolean success, int start, int limit, int size, LinkedHashMap<String, Integer> response) {
        this.success = success;
        this.start = start;
        this.limit = limit;
        this.size = size;
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedHashMap<String, Integer> getResponse() {
        return response;
    }

    public void setResponse(LinkedHashMap<String, Integer> response) {
        this.response = response;
    }
}
