package com.exp.Banking.App.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.exp.Banking.App.dto.AccountDto;
import com.exp.Banking.App.entity.Account;
import com.exp.Banking.App.mapper.AccountMapper;
import com.exp.Banking.App.repository.AccountRepo;
import com.exp.Banking.App.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepo accountRepo;
	
	
	
	public AccountServiceImpl(AccountRepo accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}



	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepo
		.findById(id)
		.orElseThrow(()->new RuntimeException("Account doesn't exist"));
		
		return AccountMapper.mapToAccountDto(account);
		
	}
	
	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepo
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account doesn't exist"));
				
		double total =account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
		
	}



	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepo
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account doesn't exist"));
		
		if(account.getBalance()< amount) {
			throw new RuntimeException("Insufficient amount");
		}
		
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = accountRepo.save(account);
	
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepo.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
		.collect(Collectors.toList());
		
	}



	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepo
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account doesn't exist"));
		accountRepo.deleteById(id);
		
	}

}
