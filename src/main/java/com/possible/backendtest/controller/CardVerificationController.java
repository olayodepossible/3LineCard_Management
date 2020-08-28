package com.possible.backendtest.controller;

import com.possible.backendtest.api.ApiResponse;
import com.possible.backendtest.dto.CardResponseDto;
import com.possible.backendtest.dto.HitCountDto;
import com.possible.backendtest.service.CardVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CardVerificationController {

        private final CardVerificationService cardVerificationService;

        @Autowired
        public CardVerificationController(CardVerificationService cardVerificationService) {
            this.cardVerificationService = cardVerificationService;
        }

        @GetMapping("/")
        public String welcome() {
            return "Welcome";
        }

        @GetMapping("/card-scheme/verify/{cardNumber}")
        public ResponseEntity<ApiResponse<CardResponseDto>> cardValidity(
                @PathVariable(name = "cardNumber") String cardNumber) {
            CardResponseDto response = cardVerificationService.validate(cardNumber);
            ApiResponse<CardResponseDto> api = new ApiResponse<>(HttpStatus.OK);
            api.setData(response);
            api.setMessage("Card is valid");
            return new ResponseEntity<>(api, api.getStatus());
        }

        @GetMapping("/card-scheme/stats")
        public ResponseEntity<ApiResponse<HitCountDto>> hitCount(@RequestParam(name = "start", defaultValue = "1") int start,
                                                                 @RequestParam(name = "limit", defaultValue = "1") int limit) {
            HitCountDto response = cardVerificationService.hitCount(start, limit);
            ApiResponse<HitCountDto> api = new ApiResponse<>(HttpStatus.OK);
            api.setData(response);
            System.out.println("This from Controller: "+ response.toString());
            api.setMessage("Number of hits returned");
            return new ResponseEntity<>(api, api.getStatus());
        }

}
