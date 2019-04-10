package com.example.MLaunchPad;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.MLaunchPad.domain.Account;
import com.example.MLaunchPad.domain.AccountRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTEST {

	@Autowired
	private AccountRepository accountRepo;
	
	@Test
	public void createNewAccount() {
		Account account = new Account("testAccount", "secretTestPassword", "test@test.com", "user");
		accountRepo.save(account);
		
		assertThat(account.getId()).isNotNull();
	}
	
}
