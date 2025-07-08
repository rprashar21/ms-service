package com.rohit.accounts.controller;

import java.util.concurrent.CompletableFuture;

import com.rohit.accounts.service.ICreditHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class CreditController {

    private final ICreditHistoryService creditHistoryService;

    // lets also try api versioning

    // this is a sync method ,, here the  user will keep waiting
    @GetMapping(path = "sync")
    public ResponseEntity<String> getCreditScoreV0(@Valid @RequestParam
                                                   String phoneNumber) {

        // how do i make this async and send the response after some time
        return ResponseEntity.ok(creditHistoryService.getCreditScore(phoneNumber));

    }

    @GetMapping(path = "/async")
    public CompletableFuture<ResponseEntity<String>> getCreditScoreV1(@Valid @RequestParam
                                                                      String phoneNumber) {

        // how do i make this async and send the response after some time
        return CompletableFuture.supplyAsync(() -> {
            String score = creditHistoryService.getCreditScore(phoneNumber);
            return ResponseEntity.ok(score);
        });
    }
}
