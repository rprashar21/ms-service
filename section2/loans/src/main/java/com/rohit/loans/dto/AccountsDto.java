package com.rohit.loans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {
    private String name;
    private String email;
    private String mobileNumber;
    private Long accountNumber;
    private Long customerId;
    private String accountType;
    private String branchAddress;
} 