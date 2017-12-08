package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserManagementApplication {

	public static final String EXCHANGE_NAME = "appExchange";
	
	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}
}
