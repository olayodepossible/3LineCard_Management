package com.possible.backendtest.service;

import com.possible.backendtest.dto.CardResponseDto;
import com.possible.backendtest.dto.HitCountDto;
import com.possible.backendtest.dto.ResponsePayload;
import com.possible.backendtest.exception.CustomException;
import com.possible.backendtest.model.Card;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class CardVerificationImpl implements CardVerificationService {
        private LinkedHashMap<String, Integer> countPayload = new LinkedHashMap<>();

    @Override
        public CardResponseDto validate(String cardNumber) {
            try {
                ResponseEntity<Card> responseEntity = new RestTemplate()
                        .getForEntity("https://lookup.binlist.net/{cardNumber}", Card.class, cardNumber);
                Card response = responseEntity.getBody();
                assert response != null;
                ResponsePayload payload = new ResponsePayload(response.getCardScheme(), response.getCardType(), response.getBank().getBankName());
                // update payload of number of hits
                addNumberOfHits(cardNumber);
                return new CardResponseDto(true, payload);
            } catch (Exception e) {
                throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }


    protected void addNumberOfHits(String cardNumber) {
            if (!countPayload.containsKey(cardNumber)) {
                countPayload.put(cardNumber, 1);
            } else {
                int count = countPayload.get(cardNumber) + 1;
                countPayload.put(cardNumber, count);
            }

        }


    @Override
    public HitCountDto hitCount(int start, int limit) {
        try {
            LinkedHashMap<String, Integer> payload = new LinkedHashMap<>();
            if (countPayload.size() > 0) {
                List<String> list = new ArrayList<>();
                for (String key : countPayload.keySet()) {
                    list.add(key);
                }

                if (start == 0) {
                    start = 1;
                } else if (start > countPayload.size()) {
                    throw new CustomException("Start number way too high, please reduce start numbeer",
                            HttpStatus.BAD_REQUEST);
                }

                int end;
                if ((start + limit) > countPayload.size()) {
                    end = countPayload.size() + 1;
                } else {
                    end = start + limit;
                }

                for (int i = start; i < end; i++) {
                    payload.put(list.get(i - 1), countPayload.get(list.get(i - 1)));
                }
            }
            return new HitCountDto(true, start, limit, countPayload.size(), payload);
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
