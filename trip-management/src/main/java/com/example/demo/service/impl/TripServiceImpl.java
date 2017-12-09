package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Trip;
import com.example.demo.repo.TripRepository;
import com.example.demo.service.TripService;


@Service("TripService")
public class TripServiceImpl implements TripService {
	@Autowired
	private TripRepository tripRepository;
	
	@Override
	public Trip getById(Long id) {
		return tripRepository.findOne(id);
	}

	@Override
	public Trip getByTripName(String name) {
		return tripRepository.findByTripName(name);
	}

	@Override
	public List<Trip> getAllTrips() {
		return tripRepository.findAll();
	}
	
	@Override
	public Trip getByUserId(Integer userId){
		return tripRepository.findByUserId(userId);
	}
	@Override
	public Trip getByDriverId(Integer driverId) {
		return tripRepository.findByDriverId(driverId);
	}
	
	@Override
	public Trip saveTrip(Trip trip){
		return tripRepository.save(trip);
	}

	
}