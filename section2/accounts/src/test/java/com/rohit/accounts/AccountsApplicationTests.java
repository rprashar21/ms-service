package com.rohit.accounts;

import com.rohit.accounts.repository.AccountsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountsApplicationTests {

	@Autowired
	private AccountsRepository accountsRepository;

	@Test
	public void testAccountsEntity() {

		

	}

}
