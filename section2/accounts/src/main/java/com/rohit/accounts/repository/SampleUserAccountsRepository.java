package com.rohit.accounts.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.rohit.accounts.entity.SampleUserAccountWithJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleUserAccountsRepository extends JpaRepository<SampleUserAccountWithJPA, UUID> {


    @Query("select uas from SampleUserAccountWithJPA uas where uas=:username")
    List<SampleUserAccountWithJPA> findUsingUserName(String username);

    @Query(value = "select * from user_accounts_sample uas where user_name =:username ",nativeQuery = true)
    List<SampleUserAccountWithJPA> findUsingUserNameV2(String username);
}
