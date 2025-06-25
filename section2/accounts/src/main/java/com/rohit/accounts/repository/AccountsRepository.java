package com.rohit.accounts.repository;

import java.util.List;

import com.rohit.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Accounts findAccountsByCustomerId(Long customerId);
}
