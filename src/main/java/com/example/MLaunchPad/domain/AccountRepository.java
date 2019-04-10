package com.example.MLaunchPad.domain;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
	
	Account findByUsername(String username);
}
