package com.possible.backendtest.unitTest;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import com.possible.backendtest.service.CardVerificationServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CardVerificationServiceTest {

    @Mock
        private CardVerificationServiceImpl cardVerificationServiceImpl;

        @Test
        public void verifyCard() {
            String cardNumber = "5399831615410053";
            cardVerificationServiceImpl.validate(cardNumber);
            verify(cardVerificationServiceImpl, times(1)).validate(cardNumber);
        }

        @Test
        public void hitCount() {
            int start = 1;
            int limit = 3;
            cardVerificationServiceImpl.hitCount(start, limit);
            verify(cardVerificationServiceImpl, times(1)).hitCount(start, limit);
        }

}
