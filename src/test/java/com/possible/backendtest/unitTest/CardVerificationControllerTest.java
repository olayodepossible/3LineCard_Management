package com.possible.backendtest.unitTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import com.possible.backendtest.controller.CardVerificationController;
import com.possible.backendtest.dto.CardResponseDto;
import com.possible.backendtest.dto.HitCountDto;
import com.possible.backendtest.exception.CustomException;
import com.possible.backendtest.service.CardVerificationService;
import com.possible.backendtest.utils.TestModels;
import com.possible.backendtest.utils.TestUtils;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = CardVerificationController.class)
public class CardVerificationControllerTest {
    @Autowired
        private MockMvc mockMvc;

        @MockBean
        private CardVerificationService cardVerificationService;

        @Test
        public void shouldCheckCardValidity() throws Exception {
            String cardNum = "5399831615410053";
            String path = "/card-scheme/verify/5399831615410053";
            CardResponseDto newDto = TestModels.newCardResponseDto();
            when(cardVerificationService.validate(cardNum)).thenReturn(newDto);
            mockMvc.perform(get(path).contentType(MediaType.APPLICATION_JSON).content(TestUtils.asJsonString(newDto)))
                    .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.status", Is.is("OK")))
                    .andExpect(jsonPath("$.message", Is.is("Card is valid")));
        }

        @Test
        public void shouldReturnBadRequestException() throws Exception {
            String cardNum = "5089237797";
            String path = "/card-scheme/verify/5089237797";
            when(cardVerificationService.validate(cardNum)).thenThrow(new CustomException("Invalid Card Number", HttpStatus.BAD_REQUEST));
            mockMvc.perform(get(path).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest()).andExpect(jsonPath("$.status", Is.is("BAD_REQUEST")));
        }

        @Test
        public void shouldReturnHitCount() throws Exception {
            int start = 1;
            int limit = 3;
            String path = "/card-scheme/stats";

            HitCountDto hitCountDto = TestModels.newHitCountDto();
            when(cardVerificationService.hitCount(start, limit)).thenReturn(hitCountDto);
            mockMvc.perform(get(path).param("start", "1").param("limit", "3")
                    .contentType(MediaType.APPLICATION_JSON).content(TestUtils.asJsonString(hitCountDto)))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.status", Is.is("OK")))
                    .andExpect(jsonPath("$.message", Is.is("Number of hits returned")));
        }

        @Test
        public void shouldReturnBadRequest() throws Exception {
            int start = 10;
            int limit = 3;
            String path = "/card-scheme/stats";
            when(cardVerificationService.hitCount(start, limit)).thenThrow(new CustomException("Please reduce start number", HttpStatus.BAD_REQUEST));
            mockMvc.perform(get(path).param("start", "10").param("limit", "3").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest()).andExpect(jsonPath("$.error").value("Please reduce start number"));
        }

}
