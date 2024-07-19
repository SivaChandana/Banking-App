package com.exp.Banking.App.service;

import java.util.List;

import com.exp.Banking.App.dto.AccountDto;
import com.exp.Banking.App.entity.Account;

public interface AccountService {
	
	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccountById(Long id);
	
	AccountDto deposit(Long id, double amount);
	
	AccountDto withdraw(Long id, double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteAccount(Long id);

}
