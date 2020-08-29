package com.possible.backendtest.utils;

import com.possible.backendtest.dto.CardResponseDto;
import com.possible.backendtest.dto.HitCountDto;
import com.possible.backendtest.dto.Payload;

import java.util.LinkedHashMap;

public class TestModels {

    public static CardResponseDto newCardResponseDto(){
        Payload response = new Payload( "mastercard", "debit", "GTBANK");
        return new CardResponseDto(true, response);
    }

    public static HitCountDto newHitCountDto(){
        LinkedHashMap<String, Integer> hitCount = new LinkedHashMap<>();
        hitCount.put("5399831615410053", 3);
        hitCount.put("439983161541005", 3);
        hitCount.put("4399831615412053", 2);
        return new HitCountDto(true, 1, 3, 4, hitCount);
    }
}
