package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Trip;

public interface TripService {
	public Trip getById(Long id);
	public Trip getByTripName(String name);
	public List<Trip> getAllTrips();	
	
	
	public Trip getByUserId(Integer userId);
	public Trip getByDriverId(Integer driverId);
	
	public Trip saveTrip(Trip trip);
}
