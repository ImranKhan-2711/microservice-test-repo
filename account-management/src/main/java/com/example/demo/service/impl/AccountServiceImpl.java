package com.example.demo.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repo.AccountRepository;
import com.example.demo.service.AccountService;


@Service("AccountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account getById(Long id) {
		return accountRepository.findOne(id);
	}

	@Override
	public Account getByName(String name) {
		return accountRepository.findByName(name);
	}

	@Override
	public Account getByAccountNumber(BigInteger accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}
	
	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}
	
	@Override
	public Account getByUserId(Integer userId){
		return accountRepository.findByUserId(userId);
	}
}