package com.rohit.accounts.service;

import com.rohit.accounts.dto.CustomerAccountDto;
import com.rohit.accounts.dto.CustomerDto;
import com.rohit.accounts.entity.Accounts;

public interface IAccountsService {

    void createAccount(CustomerDto customerDto);

    CustomerAccountDto getCustomerAccountDetails(String mobileNumber);
}
