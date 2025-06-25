package com.rohit.accounts.util;

import java.util.Random;

public class AccountsUtil {
    private static final Random RANDOM = new Random();

    public static long getRandomAccountNumber() {
        // Generate a random 10-digit number (between 1,000,000,000 and 9,999,999,999)
        return 1_000_000_000L + RANDOM.nextLong(9_000_000);
    }

    public static void main(String[] args) {
        System.out.println(getRandomAccountNumber());
    }
}
