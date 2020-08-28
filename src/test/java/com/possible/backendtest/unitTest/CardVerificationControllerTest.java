package com.possible.backendtest.unitTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import com.possible.backendtest.controller.CardVerificationController;
import com.possible.backendtest.service.CardVerificationService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = CardVerificationController.class)
public class CardVerificationControllerTest {
    @Autowired
        private MockMvc mockMvc;

        @MockBean
        private CardVerificationService cardVerificationService;

        @Test
        public void checkCardValidity() throws Exception {

            String path = "/card-scheme/verify/5399831615410053";
            this.mockMvc.perform(get(path).contentType(MediaType.APPLICATION_JSON))
                    .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.status", Is.is("OK")))
                    .andExpect(jsonPath("$.message", Is.is("Card is valid")));
        }

        @Test
        public void numberOfHits() throws Exception {

            this.mockMvc
                    .perform(get("/card-scheme/stats").param("page", "0").param("size", "1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.status", Is.is("OK")))
                    .andExpect(jsonPath("$.message", Is.is("Number of hits returned")));
        }

}
