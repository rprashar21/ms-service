package com.rohit.loans.dto;


import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data // ia combination of RequiredArgConstructor final ,getter sertter tostring eaulasand hashcde annd value
@AllArgsConstructor
public class LoansDto {

    // Dto is data transfer object // used for performance
    //// why dto is used ? tranfer data between process ,reduce http calls , performance
    //// also multiple layers data can transfer using dto , it is a good practice

    @NotEmpty(message = "Mobile number should not be empty")
    private String mobileNumber;
    private String loanNumber;
    private String loanType;
    private BigDecimal totalLoanAmount;

}
