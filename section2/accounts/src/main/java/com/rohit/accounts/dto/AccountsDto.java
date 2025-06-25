package com.rohit.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AccountsDto {

    private Long accountNumber;
    private String accountType;
    private String branchAddress;
    private Long customerId;

}
