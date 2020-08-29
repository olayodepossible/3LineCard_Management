package com.possible.backendtest.service;

import com.possible.backendtest.dto.CardResponseDto;
import com.possible.backendtest.dto.HitCountDto;
import com.possible.backendtest.dto.Payload;
import com.possible.backendtest.exception.CustomException;
import com.possible.backendtest.model.Card;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CardVerificationServiceImpl implements CardVerificationService {
    private LinkedHashMap<String, Integer> trackCardNumberHit = new LinkedHashMap<>();

    @Override
    public CardResponseDto validate(String cardNumber) {
        try {
            ResponseEntity<Card> responseEntity = new RestTemplate().getForEntity("https://lookup.binlist.net/{cardNumber}", Card.class, cardNumber);
            Card response = responseEntity.getBody();
            assert response != null;
            Payload payload = new Payload(response.getScheme(), response.getType(), response.getBank().getName());
            addNumberOfHits(cardNumber);
            return new CardResponseDto(true, payload);
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    public void addNumberOfHits(String cardNumber) {
            if (!trackCardNumberHit.containsKey(cardNumber)) {
                trackCardNumberHit.put(cardNumber, 1);
            }
            else {
                trackCardNumberHit.put(cardNumber, trackCardNumberHit.get(cardNumber) + 1);
            }
        }


    @Override
    public HitCountDto hitCount(int start, int limit) {
        try {
            if(start > trackCardNumberHit.size()){
                throw new CustomException("Please reduce start number", HttpStatus.BAD_REQUEST);
            }

            else {
                LinkedHashMap<String, Integer> payload = trackCardNumberHit.entrySet()
                        .stream()
                        .limit(limit)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, value) -> value, LinkedHashMap::new));

                return new HitCountDto(true, start, limit, trackCardNumberHit.size(), payload);
            }
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
