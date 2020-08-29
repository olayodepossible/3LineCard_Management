package com.possible.backendtest.unitTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import com.possible.backendtest.dto.CardResponseDto;
import com.possible.backendtest.service.CardVerificationServiceImpl;
import com.possible.backendtest.utils.TestModels;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedHashMap;

@ExtendWith(MockitoExtension.class)
public class CardVerificationServiceTest {

    @Mock
        private CardVerificationServiceImpl cardVerificationServiceImpl;


        @Test
        public void shouldNotBeNull() {
            CardResponseDto dto = TestModels.newCardResponseDto();
            assertNotNull(dto);
        }

        @Test
        public void shouldInvokeValidate() {
            String cardNumber = "5399831615410053";
            cardVerificationServiceImpl.validate(cardNumber);
            verify(cardVerificationServiceImpl, times(1)).validate(cardNumber);
        }

        @Test
        public void shouldReturnCardTypeMaster() {
            String cardNumber = "5399831615410053";
            CardResponseDto dto = TestModels.newCardResponseDto();
            assertEquals("debit", dto.getResponse().getType() );
        }

        @Test
        public void shouldReturnBankName() {
            String cardNumber = "5399831615410053";
            CardResponseDto dto = TestModels.newCardResponseDto();
            assertEquals("GTBANK", dto.getResponse().getName());
        }

        @Test
        public void shouldReturnCardScheme() {
            String cardNumber = "5399831615410053";
            CardResponseDto dto = TestModels.newCardResponseDto();
            assertEquals("mastercard",  dto.getResponse().getScheme());
        }

        @Test
        public void shouldInvokeHitCount() {
            int start = 1;
            int limit = 3;
            cardVerificationServiceImpl.hitCount(start, limit);
            verify(cardVerificationServiceImpl, times(1)).hitCount(start, limit);
        }

}
