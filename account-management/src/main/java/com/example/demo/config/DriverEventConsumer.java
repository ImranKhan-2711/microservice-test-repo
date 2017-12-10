package com.example.demo.config;

import java.util.logging.Logger;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class DriverEventConsumer {
	
	//We assume as of now that Account will handle driver queue data
	protected Logger logger = Logger.getLogger(DriverEventConsumer.class.getName());

	  @RabbitListener(queues="driverServiceQueue")
	  public void receive(String message) {
	    logger.info("Received message '{}'"+ message);
	  }
}
