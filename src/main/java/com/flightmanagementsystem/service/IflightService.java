package com.flightmanagementsystem.service;

import java.util.List;

import com.flightmanagementsystem.Entity.Flight;
import com.flightmanagementsystem.exception.FlightAlreadyExistsException;
import com.flightmanagementsystem.exception.ResourceNotFoundException;

public interface IflightService {

	public Flight addFlight(Flight flight) throws FlightAlreadyExistsException;
	
	public Flight modifyFlight(Flight flight) throws ResourceNotFoundException;
	
	public Flight viewFlight(long flightId) throws ResourceNotFoundException;
	
	public List<Flight> viewAllList( ) throws ResourceNotFoundException;
	
	public Flight  deleteFlight(long flightId) throws ResourceNotFoundException;
	
	public Flight validateFlight (Flight flight);
}
