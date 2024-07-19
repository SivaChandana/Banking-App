package com.exp.Banking.App.mapper;

import com.exp.Banking.App.dto.AccountDto;
import com.exp.Banking.App.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
				accountDto.getId(),
				accountDto.getAccountHolderName(),
				accountDto.getBalance()
				);
		return account;
		
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto =  new AccountDto(
				account.getId(),
				account.getAccoutHolderName(),
				account.getBalance());
		return accountDto;
		
	}

}
