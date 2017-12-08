package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


@Configuration
public class EventConsumerConfig {

	public static final String EXCHANGE_NAME = "appExchange";
	public static final String ROUTING_KEY = "user.fetched";
	public static final String QUEUE_NAME = "userServiceQueue";
	@Bean
	public TopicExchange appExchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}

	  @Bean
	  public Queue queue() {
	    return new Queue(QUEUE_NAME);
	  }
	  
	  @Bean
		public Binding declareBindingGeneric() {
			return BindingBuilder.bind(queue()).to(appExchange()).with(ROUTING_KEY);
		}

	  @Bean
	  public EventConsumer eventReceiver() {
	    return new EventConsumer();
	  }

}
