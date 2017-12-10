package com.example.demo.config;

import java.util.logging.Logger;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class UserEventConsumer {
	
	protected Logger logger = Logger.getLogger(UserEventConsumer.class.getName());

	  @RabbitListener(queues="userServiceQueue")
	  public void receive(String message) {
	    logger.info("Received message '{}'"+ message);
	  }
}
