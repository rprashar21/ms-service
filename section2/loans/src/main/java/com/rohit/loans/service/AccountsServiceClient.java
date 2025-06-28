package com.rohit.loans.service;

import com.rohit.loans.dto.AccountsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountsServiceClient {

    private final WebClient webClient;
    private static final String ACCOUNTS_SERVICE_URL = "http://localhost:8085/api";

    public Mono<AccountsDto> getCustomerDetails(String mobileNumber) {
        return webClient.get()
                .uri(ACCOUNTS_SERVICE_URL + "/accounts?mobileNumber=" + mobileNumber)
                .retrieve()
                .bodyToMono(AccountsDto.class)
                .doOnSuccess(response -> log.info("Successfully retrieved customer details for mobile: {}", mobileNumber))
                .doOnError(error -> log.error("Error retrieving customer details for mobile: {}, error: {}", mobileNumber, error.getMessage()));
    }

    public boolean isCustomerExists(String mobileNumber) {
        try {
            return getCustomerDetails(mobileNumber)
                    .map(customer -> true)
                    .onErrorReturn(false)
                    .block();
        } catch (Exception e) {
            log.error("Error checking if customer exists for mobile: {}", mobileNumber, e);
            return false;
        }
    }
} 