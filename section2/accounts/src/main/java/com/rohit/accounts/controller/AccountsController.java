package com.rohit.accounts.controller;

import static com.rohit.accounts.constants.AccountConstants.ACCOUNT_CREATED_SUCCESSFULLY;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.rohit.accounts.dto.CustomerAccountDto;
import com.rohit.accounts.dto.CustomerDto;
import com.rohit.accounts.dto.ResponseDto;
import com.rohit.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated // tells the cpntroller to perform validation in my controller
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
public class AccountsController {

    IAccountsService accountsService;

//    AccountsConfiguration accountsConfiguration;

    @Operation(summary = "Api to create account details for a customer", description = "You can create any number of accounts")
    @ApiResponse(responseCode = "201", description = "Http Status code")
    @PostMapping("/accounts")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {

        accountsService.createAccount(customerDto);
        return ResponseEntity.status(CREATED)
                .body(new ResponseDto(ACCOUNT_CREATED_SUCCESSFULLY, CREATED.toString()));
    }

    @GetMapping("/accounts")
    public ResponseEntity<CustomerAccountDto> fetchAccountDetails(@RequestParam @Pattern(
            regexp = "^(\\+91[-\\s]?|91[-\\s]?|0)?[6-9]\\d{9}$",
            message = "Invalid mobile number format"
    ) String mobileNumber) {
        CustomerAccountDto customerAccountDetails = accountsService.getCustomerAccountDetails(mobileNumber);
        return ResponseEntity.status(OK).body(customerAccountDetails);
    }

    @GetMapping("/users")
    public ResponseEntity<String> fetchUserDetails(@Valid @RequestParam @NotEmpty String email) {
        if(email.contains("rohit")) {
            return ResponseEntity.status(OK).body("User Exists");
        }
        return ResponseEntity.status(OK).body("Please sign up");
    }
}
