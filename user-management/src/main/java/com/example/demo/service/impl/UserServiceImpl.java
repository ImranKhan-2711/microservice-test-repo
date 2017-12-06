package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;


@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User get(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User getByUserId(Integer userId) {
		return userRepository.findByUserId(userId);
	}
	
}