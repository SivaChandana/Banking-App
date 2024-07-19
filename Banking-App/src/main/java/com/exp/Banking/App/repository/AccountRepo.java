package com.exp.Banking.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.Banking.App.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{

}
