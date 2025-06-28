package com.rohit.loans.service;

import com.rohit.loans.dto.LoansDto;


public interface ILoansService {

   void createLoan(LoansDto loansDto);

   boolean creditHistory(String mobileNmber);

   void getLoan(String mobileNmber);
}
