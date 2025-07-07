package com.rohit.accounts.repository;

import java.util.UUID;

import com.rohit.accounts.entity.SampleUserAccountWithJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleUserAccountsRepository extends JpaRepository<SampleUserAccountWithJPA, UUID> {
}
