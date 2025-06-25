package com.rohit.accounts.repository;

import java.util.Optional;

import com.rohit.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByMobileNumber(String mobileNumber);
}
