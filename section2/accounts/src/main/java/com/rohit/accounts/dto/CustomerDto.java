package com.rohit.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {

    // here we can do simple input validataion , this can be done on the ui side as well

    @NotBlank(message = "Name must be provided")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;
    @NotEmpty(message = "Email should be provided")
    @Email(message = "Email format should be correct eg abc@gmail.com or abc@asia")
    private String email;

    @Pattern(
            regexp = "^(\\+91[-\\s]?|91[-\\s]?|0)?[6-9]\\d{9}$",
            message = "Invalid mobile number format , eg 91 9234500576"
    )
    private String mobileNumber;
}
