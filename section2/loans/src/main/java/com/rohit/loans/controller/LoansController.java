package com.rohit.loans.controller;

import com.rohit.loans.dto.LoansDto;
import com.rohit.loans.dto.ResponseDto;
import com.rohit.loans.service.ILoansService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class LoansController {

    private final ILoansService loansService;

    @PostMapping("/loans")
    public ResponseEntity<ResponseDto> createLoan(@RequestBody LoansDto loansDto) {
        loansService.createLoan(loansDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("Loan Created", "201", null));
    }

    @GetMapping("/loans")
    public ResponseEntity<ResponseDto> checkCreditHistory(@Valid @RequestParam String mobileNumber) {

        boolean isEligible = loansService.creditHistory(mobileNumber);
        if (isEligible) {
            return ResponseEntity.ok(new ResponseDto("Eligible", "200", null));
        } else {
            return ResponseEntity.ok(new ResponseDto("Not Eligible", "", null));
        }
    }
}
