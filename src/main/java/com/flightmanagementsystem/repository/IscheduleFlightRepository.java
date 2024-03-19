package com.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightmanagementsystem.Entity.ScheduledFlight;

public interface IscheduleFlightRepository extends JpaRepository<ScheduledFlight, Long> {
	
	/*
	 * @Query(value = "select c from  ScheduledFlight where c.startAirportId=?1 ")
	 * public ScheduledFlight findByAirportName(Airport startAirportId);
	 * 
	 * 
	 */

}
