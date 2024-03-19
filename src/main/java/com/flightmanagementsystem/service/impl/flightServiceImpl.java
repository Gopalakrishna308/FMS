package com.flightmanagementsystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagementsystem.Entity.Flight;
import com.flightmanagementsystem.exception.FlightAlreadyExistsException;
import com.flightmanagementsystem.exception.ResourceNotFoundException;
import com.flightmanagementsystem.repository.IflightRepository;
import com.flightmanagementsystem.service.IflightService;
 @Service
public class flightServiceImpl implements IflightService {

	@Autowired
	private IflightRepository flightServiceImp;
	@Override
	public Flight addFlight(Flight flight) throws FlightAlreadyExistsException {
		  Optional<Flight>a=flightServiceImp.findById(flight.getFlightId());
		 Flight f=null;
		 if(a.isPresent())
		 {
			 throw new FlightAlreadyExistsException("Flight is already in database");
		 }
		 else
		 {
			return flightServiceImp.save(flight);
		 }
	  
	}

	@Override
	public Flight modifyFlight(Flight flight) throws ResourceNotFoundException {
	
		Flight f=flightServiceImp.findById(flight.getFlightId()).orElseThrow(()-> new ResourceNotFoundException("flight is not there"));
		f.setFlightModel(flight.getFlightModel());
         f.setSeatCapacity(flight.getSeatCapacity());
         f.setCarrierName(flight.getCarrierName());
         
		return flightServiceImp.save(f);
	}

	@Override
	public Flight viewFlight(long flightId) throws ResourceNotFoundException {


		return flightServiceImp.findById(flightId).orElseThrow(()-> new ResourceNotFoundException("No flight in database"));
	}

	@Override
	public List<Flight> viewAllList( ) throws ResourceNotFoundException {

		List<Flight>list=flightServiceImp.findAll();
		if(list.isEmpty())

		{
			throw new ResourceNotFoundException("No Flight are in database");
		}
		else
		{
		return list;	
		}
		 
	}

	@Override
	public Flight deleteFlight(long flightId) throws ResourceNotFoundException {
		Flight f=flightServiceImp.findById(flightId).orElseThrow(()->new ResourceNotFoundException
				("No flights are in data base"));
		flightServiceImp.delete(f);
		return f;
	}

	@Override
	public Flight validateFlight(Flight flight) {
		 return null;
	}

}
