package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import com.example.demo.service.impl.AccountServiceImpl;


@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	protected Logger logger = Logger.getLogger(AccountServiceImpl.class
			.getName());
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@RequestMapping("accounts/{id}")
	public Account getByid(@PathVariable Long id) {
		logger.info("ACCESSED");;
		return accountService.getById(id);
	}
	
	/*@RequestMapping("accounts/{name}")
	public Accounts getByName(@PathVariable String name) {
		return accountService.getByName(name);
	}
	
	@RequestMapping("accounts/{accountNumber}")
	public Accounts getByName(@PathVariable BigInteger accountNumber) {
		return accountService.getByAccountNumber(accountNumber);
	}*/
	@RequestMapping("accounts")
	public List<Account> getByName() {
		return accountService.getAllAccounts();
	}
	
	
	@RequestMapping("account/{userId}")
	public Account getByUserId(@PathVariable Integer userId) {
		return accountService.getByUserId(userId);
	}
	
}