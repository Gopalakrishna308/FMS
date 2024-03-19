package com.flightmanagementsystem.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightmanagementsystem.Entity.Airport;
@Repository
public interface IairportRepository extends JpaRepository<Airport, Long> {

	@Query(value = "select c from Airport c where c.airportName=?1 AND c.airportName=?1AND date=?1")
	Airport findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDate(Airport airportName1, Airport airportName,
			LocalDate date);

	 
}
