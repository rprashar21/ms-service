package com.rohit.loans.service;

import java.math.BigDecimal;
import java.util.Random;

import com.rohit.loans.dto.LoansDto;
import com.rohit.loans.entity.Loans;
import com.rohit.loans.repository.LoansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoansService {

    private final LoansRepository loansRepositrory;

    @Override
    public void createLoan(final LoansDto loansDto) {

        // map the dto to entity and then sae the loan and send a request back
        // if the loansDto mobile number exists  call the accounts service and check if the mobile number exists
        // this checking from anothe rmicroservice we will chekc later

        Loans loans = new Loans();
        loans.setLoanNUmber("Loan - " + new Random().nextInt(100));
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setLoanType("SAVINGS");
        loans.setTotalLoanAmount(BigDecimal.valueOf(25000));
        loansRepositrory.save(loans);

    }
}
