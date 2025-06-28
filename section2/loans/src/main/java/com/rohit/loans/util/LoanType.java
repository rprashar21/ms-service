package com.rohit.loans.util;

public enum LoanType {

    SAVING(25),
    PERSONAL(30),
    MARRIAGE(15);

    private int value;

    LoanType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
