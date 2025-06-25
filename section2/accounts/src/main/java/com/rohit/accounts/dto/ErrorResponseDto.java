package com.rohit.accounts.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponseDto {

    private String errorMessage;
    private String apiPath;
    private String errorCode;
    private LocalDateTime errorTime;
}

// why dto is used ? tranfer data between process ,reduce http calls , performance
// also multiple layers data can transfer using dto , it is a good practice
