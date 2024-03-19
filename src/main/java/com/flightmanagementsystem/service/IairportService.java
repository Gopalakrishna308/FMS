package com.flightmanagementsystem.service;

import java.util.List;

import com.flightmanagementsystem.Entity.Airport;
import com.flightmanagementsystem.exception.AirportAlreadyExistsException;
import com.flightmanagementsystem.exception.ResourceNotFoundException;

public interface IairportService {
	
	public Airport addAirport(Airport airport) throws AirportAlreadyExistsException;
	
	public Airport deleteAirport(long airportId) throws ResourceNotFoundException;
	
	public  List<Airport> viewAllAirport() throws ResourceNotFoundException;
	
	public Airport viewAirport(long airportId) throws ResourceNotFoundException;
	
	

}
