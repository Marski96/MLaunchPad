package com.example.MLaunchPad.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.MLaunchPad.domain.Account;
import com.example.MLaunchPad.domain.AccountRepository;


@Service
public class AccountService implements UserDetailsService{
	private final AccountRepository repository;
	
	@Autowired
	public AccountService(AccountRepository accountRepository) {
			this.repository = accountRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account curruser = repository.findByUsername(username);
		UserDetails account = new org.springframework.security.core.userdetails.User(username, curruser.getHashedPassword(),
				AuthorityUtils.createAuthorityList(curruser.getRole()));
		
		
		return account;
	}

}
