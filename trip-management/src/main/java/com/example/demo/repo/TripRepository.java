package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {
	
	@Query("SELECT t FROM Trip t WHERE t.name = :tripName")
	public Trip findByTripName(@Param("tripName") String tripName );
	
	
	@Query("SELECT t FROM Trip t WHERE t.userId = :userId")
	public Trip findByUserId(@Param("userId") Integer userId );
	
	@Query("SELECT t FROM Trip t WHERE t.driverId = :driverId")
	public Trip findByDriverId(@Param("driverId") Integer driverId );
	
}
