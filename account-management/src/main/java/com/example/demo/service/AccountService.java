package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;

import com.example.demo.model.Account;

public interface AccountService {
	public Account getById(Long id);
	public Account getByName(String name);
	public Account getByAccountNumber(BigInteger id);
	public List<Account> getAllAccounts();	
	
	
	public Account getByUserId(Integer id);
}
