package com.rohit.accounts.repository;

import com.rohit.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Accounts findAccountsByCustomerId(Long customerId);

}
