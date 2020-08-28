package com.possible.backendtest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.possible.backendtest.controller.CardVerificationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackEndTestApplicationTests {

    @Autowired
    private CardVerificationController cardVerificationController;

    @Test
    void contextLoads() {
        assertNotNull(cardVerificationController);
    }

}
