package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Trip;
import com.example.demo.service.TripService;

@RestController
@RequestMapping("trips")
public class TripController {
	@Autowired
	private TripService tripService;

/*	@Value( "${exchangeName}" )*/
	private String exchangeName = "appExchange";
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	protected Logger logger = Logger.getLogger(TripController.class
			.getName());
	
	public TripController(TripService tripService) {
		this.tripService = tripService;
	}
	
	@RequestMapping("/{id}")
	public Trip getByid(@PathVariable Long id) {
		logger.info("ACCESSED");;
		return tripService.getById(id);
	}
	
	@RequestMapping("all")
	public List<Trip> getAllTrips() {
		return tripService.getAllTrips();
	}
	
	@RequestMapping("/{userId}")
	public Trip getByTripId(@PathVariable Integer userId) {
		return tripService.getByUserId(userId);
	}
	@RequestMapping("/{driverId}")
	public Trip getByDriverId(@PathVariable Integer driverId) {
		return tripService.getByDriverId(driverId);
	}
	
	@RequestMapping("/createTrip")
	public Trip createTrip() {
		Trip trip = new Trip();
		trip.setTripId((long) Math.random());
		trip.setUserId(27);
		trip.setDriverId(82);
		trip.setSource("2212, Sector 71");
		trip.setDestination("3022, Sector 71");
		trip.setName("Trip for you");
		
		String routingKeyUser = "trip.created.user";
		String routingKeyDriver = "trip.created.driver";
	    logger.info("Sending message for user fetched");
	    rabbitTemplate.convertAndSend(exchangeName, routingKeyUser, "trip created for user");
	    rabbitTemplate.convertAndSend(exchangeName, routingKeyDriver, "trip created for driver");
		
		//tripService.saveTrip(trip);
		return trip;
	}
	
}