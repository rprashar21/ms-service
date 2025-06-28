package com.rohit.loans.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseDto {

    private String responseMessage;
    private String responseCode;
    private LoansDto loansDto;
}
