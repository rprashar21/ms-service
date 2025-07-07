package com.rohit.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class SampleUserDto {

    private String userName;
    private String password;
    private String email;
}
