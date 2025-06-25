package com.rohit.accounts.service;

import static com.rohit.accounts.util.AccountsUtil.getRandomAccountNumber;

import java.util.HashMap;
import java.util.Optional;

import com.rohit.accounts.dto.CustomerAccountDto;
import com.rohit.accounts.dto.CustomerDto;
import com.rohit.accounts.entity.Accounts;
import com.rohit.accounts.entity.Customer;
import com.rohit.accounts.exception.CustomerAlreadyExistsException;
import com.rohit.accounts.repository.AccountsRepository;
import com.rohit.accounts.repository.CustomRepository;
import exception.InvalidCustomerNumber;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private final AccountsRepository accountsRepository;
    private final CustomRepository customRepository;
    private static final HashMap<String, CustomerAccountDto> customers = new HashMap<>();

    @Override
    public void createAccount(final CustomerDto customerDto) {

        // check if the customer already exists
        Optional<Customer> customer = customRepository.findByMobileNumber(customerDto.getMobileNumber());

        if (customer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with mobile number " + customerDto.getMobileNumber() + " already exists");
        }

        // create a new customer and account for that customer
        Customer savedCustomer = getSavedCustomer(customerDto);

        // create a new account for the customer
        createAccount(savedCustomer);
    }

    @Override
    public CustomerAccountDto getCustomerAccountDetails(final String mobileNumber) {

        // check if the customer already exists
        //  here we can do caching as well if the same mobile number
        if (customers.containsKey(mobileNumber)) {
            return customers.get(mobileNumber);
        }
        Optional<Customer> optionalCustomer = customRepository.findByMobileNumber(mobileNumber);
        if (optionalCustomer.isEmpty()) {
            throw new InvalidCustomerNumber("Customer with mobile number " + mobileNumber + " does not exists");
        }
        Customer customer = optionalCustomer.get();
        // lets get the account details as well
        Accounts accountsByCustomerId = accountsRepository.findAccountsByCustomerId((customer.getCustomerId()));

        // lets build the response
        CustomerAccountDto customerAccountDto = CustomerAccountDto.builder()
                .customerId(accountsByCustomerId.getCustomerId())
                .accountNumber(accountsByCustomerId.getAccountNumber())
                .branchAddress(accountsByCustomerId.getBranchAddress())
                .accountType(accountsByCustomerId.getAccountType())
                .email(customer.getEmail())
                .mobileNumber(mobileNumber)
                .name(customer.getName())
                .build();

        // put in the map
        customers.putIfAbsent(mobileNumber, customerAccountDto);
        return customerAccountDto;

    }


    private Customer getSavedCustomer(final CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setMobileNumber(customerDto.getMobileNumber());
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        return customRepository.save(customer);
    }

    private void createAccount(final Customer savedCustomer) {
        Accounts accounts = new Accounts();
        accounts.setAccountType("Savings");
        accounts.setBranchAddress("Pune");
        accounts.setCustomerId(savedCustomer.getCustomerId());
        accounts.setAccountNumber(getRandomAccountNumber());
        accountsRepository.save(accounts);
    }


}