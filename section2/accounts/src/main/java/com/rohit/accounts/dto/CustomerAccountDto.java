package com.rohit.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomerAccountDto {

    // customer details
    private String name;
    private String email;
    private String mobileNumber;

    // account details
    private Long accountNumber;
    private Long customerId;
    private String accountType;
    private String branchAddress;


}
