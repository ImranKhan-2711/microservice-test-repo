package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


@Configuration
public class DriverEventConsumerConfig {

	public static final String EXCHANGE_NAME = "appExchange";
	public static final String ROUTING_KEY_DRIVER = "trip.created.driver";
	public static final String QUEUE_NAME_DRIVER = "driverServiceQueue";
	@Bean
	public TopicExchange appExchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}

	  @Bean
	  public Queue queue() {
	    return new Queue(QUEUE_NAME_DRIVER);
	  }
	  
	  @Bean
		public Binding declareBindingGeneric() {
			return BindingBuilder.bind(queue()).to(appExchange()).with(ROUTING_KEY_DRIVER);
		}

	  @Bean
	  public DriverEventConsumer eventReceiver() {
	    return new DriverEventConsumer();
	  }

}
