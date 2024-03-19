package com.flightmanagementsystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagementsystem.Entity.Airport;
import com.flightmanagementsystem.exception.AirportAlreadyExistsException;
import com.flightmanagementsystem.exception.ResourceNotFoundException;
import com.flightmanagementsystem.repository.IairportRepository;
import com.flightmanagementsystem.service.IairportService;
@Service
public class airportServiceImpl implements IairportService {

	 @Autowired
	 private IairportRepository airportServiceimpl;
	@Override
	public Airport addAirport(Airport airport) throws AirportAlreadyExistsException {
	
	 Optional<?>a=airportServiceimpl.findById(airport.getAirportId());
	 Airport air=null;
	 
	 if(a.isPresent())
	 {
		 throw new AirportAlreadyExistsException("Airport ia already present");
	 }
	 
		return airportServiceimpl.save(airport); 
	  
			 
		 
	}

	@Override
	public Airport deleteAirport(long airportId) throws ResourceNotFoundException {
	 Airport a=airportServiceimpl.findById(airportId).orElseThrow(()-> new ResourceNotFoundException
			 ("airport not found in database"));
	 airportServiceimpl.delete(a);
		return a;
	}

	@Override
	public List<Airport> viewAllAirport( ) throws ResourceNotFoundException {
		 List<Airport>list=airportServiceimpl.findAll();
		 if(list.isEmpty())
		 {
			 throw new ResourceNotFoundException("No airport are in database");
		 }
	 
		 else
		 {
			 return list;
		 }
	}

	@Override
	public Airport viewAirport(long airportId) throws ResourceNotFoundException {
		 return airportServiceimpl.findById(airportId).orElseThrow(()-> new ResourceNotFoundException("airport is not there"));
		 
	}

}
