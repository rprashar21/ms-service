package com.rohit.loans.service;

import java.util.Random;

import com.rohit.loans.dto.LoansDto;
import com.rohit.loans.entity.Loans;
import com.rohit.loans.repository.LoansRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanServiceImpl implements ILoansService {

    private final LoansRepository loansRepositrory;
    private final AccountsServiceClient accountsServiceClient;

    @Override
    public void createLoan(final LoansDto loansDto) {

        // Create the loan
        Loans loans = new Loans();
        loans.setLoanNUmber("LOAN" + String.format("%06d", new Random().nextInt(999999)));
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setTotalLoanAmount(loansDto.getTotalLoanAmount());
        
        loansRepositrory.save(loans);
        
        log.info("Loan created successfully for mobile number: {}", loansDto.getMobileNumber());
    }

    @Override
    public boolean creditHistory(final String mobileNmber) {
        //
        // or may be call to cards sevrice to check the credit hostory of the user if good proceed with loan application
        // then we will use redis or caching mechanism
        boolean customerExists = accountsServiceClient.isCustomerExists(mobileNmber);

        if (!customerExists) {
            log.error("Customer with mobile number {} does not exist in accounts service", mobileNmber);
          //  throw new RuntimeException("Customer not found in accounts service. Please create an account first.");
        }

        log.info("Customer with mobile number {} exists. Proceeding with loan creation.", mobileNmber);
        return customerExists;
    }

    @Override
    public void getLoan(final String mobileNmber) {

    }


}
