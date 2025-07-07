package com.rohit.accounts.controller;

import com.rohit.accounts.service.ICreditHistoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/credit", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
public class CreditController {

    private final ICreditHistoryService creditHistoryService;

    @GetMapping
    public ResponseEntity<String> getCreditScore(@Valid
                                                 @RequestParam
                                                 @Pattern(regexp = "\"^(\\\\+91[-\\\\s]?|91[-\\\\s]?|0)?[6-9]\\\\d{9}$\"",
                                                         message = "Invalida Phone Number -- eg +91 9876543210")
                                                 String phoneNumber) {

        return ResponseEntity.ok(creditHistoryService.getCreditScore(phoneNumber));

    }


}
