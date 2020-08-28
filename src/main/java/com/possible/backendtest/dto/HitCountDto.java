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

}
