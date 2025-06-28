package com.rohit.accounts.exception;

public class InvalidCustomerNumber extends RuntimeException {
    public InvalidCustomerNumber(final String message) {
        super(message);
    }
}
