package com.rohit.loans.service;

import com.rohit.loans.dto.LoansDto;
import org.springframework.stereotype.Service;


public interface LoansService {

   void createLoan(LoansDto loansDto);
}
