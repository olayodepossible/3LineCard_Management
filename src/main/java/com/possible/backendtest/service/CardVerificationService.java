package com.possible.backendtest.service;

import com.possible.backendtest.dto.CardResponseDto;
import com.possible.backendtest.dto.HitCountDto;

public interface CardVerificationService {
    public CardResponseDto validate(String cardNumber);
    public HitCountDto hitCount(int start, int limit);
}
