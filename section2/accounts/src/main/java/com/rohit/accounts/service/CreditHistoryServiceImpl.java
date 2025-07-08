package com.rohit.accounts.service;

import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreditHistoryServiceImpl implements ICreditHistoryService {

    // createa cache
    // have a time defined  time
    // call the external api ever 10 mins
    // schedule a call in the backgroudn to make that call

    private final AtomicReference<String> creditHistoryCache = new AtomicReference<>();
    // may be we wirte a logic that whenever the method is called we refresh the cache after
    // we can enhnace the logic and store if the lastcall was made say a day agao we call the external api
    // otherwiuse we get it from the cache
    private static final long REFRESH_INTERVAL_MILLIS = 10 * 60 * 1000; // 10 min
    private long lastUpdatedTime = 0;
    private LocalDateTime lastUpdatedDateTime;

    @Override
    public String getCreditScore(final String phoneNumber) {


        if (checkIfTimeHasElapsed()) {
            // call the external service and uodate the cache or
            externalCallForCreditHistory(phoneNumber);
        }

        // return from the cache
        return getfromCache(phoneNumber);
    }

    private String getfromCache(String phoneNumber) {
        if (creditHistoryCache.get() != null) {
            return creditHistoryCache.get();
        }
        return externalCallForCreditHistory(phoneNumber);
    }

    // Optional: auto-refresh in background every 10 mins
    @Scheduled(fixedDelay = 10 * 60 * 1000)
    public void scheduledRefresh() {
        // this we can make acall in the backgound and check or refill the cache
        // or we can use ths
        //  externalCallForCreditHistory();
    }

    private String externalCallForCreditHistory(final String phoneNumber) {
        log.info("Calling external credit history for phone number {}", phoneNumber);
        // Imagine this is a REST call to external service
        CompletableFuture<String> creditScore = CompletableFuture
                .supplyAsync(() -> externalCall(phoneNumber))
                .exceptionally(ex -> {
                    log.error("Error while external credit history for phone number {}", phoneNumber, ex);
                    return "No Score Available";
                });
        // we can add here a logic that if this call fails or takes more time
        String externalResponse = creditScore.join();

        creditHistoryCache.set(externalResponse);
        lastUpdatedDateTime = now();
        return externalResponse;
    }


    private boolean checkIfTimeHasElapsed() {
        if (lastUpdatedDateTime != null) {
            return (System.currentTimeMillis() - lastUpdatedTime > REFRESH_INTERVAL_MILLIS);
        }
        return false;
    }

    private String externalCall(String phoneNumber) {
        // simulate a external call


        for (int i = 0; i < 5; i++) {
            try {

                String status = String.valueOf(HttpStatus.GATEWAY_TIMEOUT);
                if (status.equals("201")) {
                    // extract response from the external api
                    return "credit score is " + phoneNumber;
                }
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // return "credit score is 800";
        return "The Application is Down , please try again";
    }
}
