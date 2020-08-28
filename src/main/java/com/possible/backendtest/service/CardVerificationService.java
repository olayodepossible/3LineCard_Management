package com.possible.backendtest.service;

import com.possible.backendtest.dto.CardResponseDto;
import com.possible.backendtest.dto.HitCountDto;

public interface CardVerificationService {
    CardResponseDto validate(String cardNumber);
    HitCountDto hitCount(int start, int limit);
}
