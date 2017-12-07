package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.ResponseDTO;

import io.netty.util.concurrent.CompleteFuture;

@RestController
public class GatewayController {

	protected Logger logger = Logger.getLogger(GatewayController.class.getName());

	
	@RequestMapping("/")
	public String getUserDetails() {
		return "hello";
	}
	@RequestMapping("/userDetails/{userId}")
	public ResponseDTO getUserDetails(@PathVariable Integer userId) {
		
		logger.info("Gateway to invoke multiple services and accumulate results");
		
		RestTemplate restTemplate = new RestTemplate();
		//data should be fetched asynchronously
		/*Object userInfo =  restTemplate.getForObject("http://localhost:2222/user-management/user/"+userId, Object.class);
		Object accountInfo =  restTemplate.getForObject("http://localhost:2222/accounts-management/account/"+userId, Object.class);
		*/
		
		//Fetching data asynchronously
		Object userInfo =null;
		Object accountInfo = null;
		try {
			Future<Object> userDetailFuture =  CompletableFuture.supplyAsync(() -> restTemplate.getForObject("http://localhost:2222/user-management/user/"+userId, Object.class));
			Future<Object> accountInfoFuture = this.getAccountInfoData(restTemplate, userId);
			/**
			 * some other operation can be performed here till we get the data
			 */
			// Get the data
			userInfo = userDetailFuture.get();
			accountInfo = accountInfoFuture.get();
			System.out.println(userInfo);
			System.out.println(accountInfo);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		Map<String,Object> aggregatedObjects = new HashMap<>();
		aggregatedObjects.put("userInfo", userInfo);
		aggregatedObjects.put("accountInfo", accountInfo);
		
		ResponseDTO responseDTO = new ResponseDTO(HttpStatus.OK, aggregatedObjects);
		return responseDTO;
	}
	
	private Future<Object> getUserDetailData(RestTemplate restTemplate, Integer userId) throws InterruptedException {
	    CompletableFuture<Object> completableFuture = new CompletableFuture<>();
	 
	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(500);
	        completableFuture.complete(restTemplate.getForObject("http://localhost:2222/user-management/user/"+userId, Object.class));
	        return null;
	    });
	    System.out.println("some code before we get results");
	    return completableFuture;
	}
	
	private Future<Object> getAccountInfoData(RestTemplate restTemplate, Integer userId) throws InterruptedException {
	    CompletableFuture<Object> completableFuture = new CompletableFuture<>();
	 
	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(500);
	        completableFuture.complete(restTemplate.getForObject("http://localhost:2222/accounts-management/account/"+userId, Object.class));
	        return null;
	    });
	    System.out.println("some code before we get results");
	    return completableFuture;
	}
}
