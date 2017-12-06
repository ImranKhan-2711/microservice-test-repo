package com.example.demo.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;


@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	protected Logger logger = Logger.getLogger(UserServiceImpl.class
			.getName());
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/users/{id}")
	public User get(@PathVariable Long id) {
		logger.info("ACCESSED");;
		return userService.get(id);
	}
	
	@RequestMapping("/user/{userId}")
	public User getByUserId(@PathVariable Integer userId) {
		return userService.getByUserId(userId);
	}
	
}