package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
	public User get(Long id);
	
	public User getByUserId(Integer userId);
}
